SET MODE PostgreSQL;


CREATE TABLE IF NOT EXISTS departments(
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 numberofemployees int,
);

CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 name VARCHAR
);

CREATE TABLE users (
 id SERIAL PRIMARY KEY,
 roles VARCHAR,
 post VARCHAR,
 departmentId INTEGER,
);


CREATE DATABASE OrgAPI_test WITH TEMPLATE OrgAPI;
