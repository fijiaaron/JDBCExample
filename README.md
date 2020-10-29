# JDBCExample

JDBC and Selenium Examples

Create database:

	MariaDB [(none)]> source src/main/resources/family.ddl.sql

Load family data into database:

	MariaDB [family]> source src/main/resources/family.dataload.sql
  
View results in database:

	MariaDB [family]> select * from people;


	+----+--------+------+
	| id | name   | age  |
	+----+--------+------+
	|  1 | Aaron  |   45 |
	|  2 | Kelsey |   38 |
	+----+--------+------+


Run Java class LoadFamilyDatabase.java to load kids.json into database

  
	MariaDB [family]> select * from people;
	+----+----------+------+
	| id | name     | age  |
	+----+----------+------+
	|  1 | Aaron    |   45 |
	|  2 | Kelsey   |   38 |
	|  4 | Harmon   |   12 |
	|  5 | Samantha |   10 |
	|  6 | Allison  |    7 |
	|  7 | Michael  |    5 |
	+----+----------+------+
	6 rows in set (0.007 sec)

