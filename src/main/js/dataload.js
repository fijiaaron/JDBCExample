const mariadb = require('mariadb');

const kids = require('../resources/kids.json');
console.log(kids);


const pool = mariadb.createPool(
{
 	host: 'localhost', 
	database: 'family',
	user:'user', 
	password: 'password',
	connectionLimit: 5
});

async function loadFamilyData()
{

	console.log("loading...");

	let connection;
	let result;

	try
	{
		connection = await pool.getConnection();
		result = await connection.query("SELECT * FROM people");
		console.log(result);

		kids.forEach(kid=> {
			loadKid(connection, kid);
		});


		result = await connection.query("SELECT * FROM people");
		console.log(result);
	}
	catch (error)
	{
		console.log('error', error);
		throw error;
	}
	finally
	{
		console.log('finally');
		if (connection) 
		{
			console.log("closing connection");
			connection.release();
		}
	}
}


async function loadKid(connection, kid)
{
	console.log("inserting kid: ", kid.name, kid.age);
	const insertStatment = "INSERT INTO people (name, age) VALUES (?, ?)";
	result = await connection.query(insertStatment, [kid.name, kid.age]);
	console.log(result);
}

loadFamilyData().then(()=> pool.end());

