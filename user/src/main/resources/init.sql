CREATE DATABASE IF NOT EXISTS user_management_db;

USE user_management_db;

CREATE TABLE IF NOT EXISTS User (
    Id int AUTO_INCREMENT,
    FirstName varchar(50),
    LastName varchar(50),
    EmailId varchar(100),
    Mobile varchar(15),
    Password varchar(100),
    JobRole varchar(50),
    PRIMARY KEY (Id)
);