import com.google.gson.Gson;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoadFamilyDatabase
{
	public static void main(String[] args) throws SQLException, IOException
	{
		String jdbcURL = "jdbc:mariadb://localhost:3306/family?user=user&password=password";
		Connection connection = DriverManager.getConnection(jdbcURL);
		String sql = "INSERT INTO people (name, age) VALUES(?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);

		Person[] kids = getJsonFromFile("kids.json");
		for (Person kid : kids)
		{
			System.out.println("Kid: " + kid.name + " is " + kid.age);

			statement.setString(1, kid.name);
			statement.setInt(2, kid.age);

			System.out.println(statement);

			statement.execute();
		}
	}

	public static Person[] getJsonFromFile(String filename) throws IOException
	{
		ClassLoader loader = LoadFamilyDatabase.class.getClassLoader();
		InputStream stream = loader.getResourceAsStream(filename);
		Reader reader = new BufferedReader(new InputStreamReader(stream));

		Gson gson = new Gson();
		Person[] kids = gson.fromJson(reader, Person[].class);

		return kids;
	}

	public class Person
	{
		public String name;
		public int age;
	}
}
