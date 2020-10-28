CREATE DATABASE IF NOT EXISTS family;
GRANT ALL PRIVILEGES ON family.* to 'user'@'localhost' IDENTIFIED BY 'password';

USE family;

DROP TABLE IF EXISTS people;
CREATE TABLE people (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    age INT);

