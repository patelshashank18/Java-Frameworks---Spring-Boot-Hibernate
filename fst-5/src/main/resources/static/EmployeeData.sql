/** Create the EmployeeData database */
CREATE DATABASE EmployeeData;

/** Select the EmployeeData database */
USE EmployeeData;


/** Create the customer table */
CREATE TABLE customer (

    /** Unique ID for each customer */
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    /** Customer's first name */
    first_name VARCHAR(100) NOT NULL,

    /** Customer's last name */
    last_name VARCHAR(100) NOT NULL,

    /** Customer's date of birth */
    date_of_birth DATE NOT NULL,

    /** Customer's mobile number must be unique */
    mobile VARCHAR(20) NOT NULL UNIQUE,

    /** Customer's first address */
    address1 VARCHAR(255),

    /** Customer's second address */
    address2 VARCHAR(255),

    /** Customer's age */
    age INT,

    /** Customer's gender */
    gender VARCHAR(20),

    /** Customer's email address */
    email VARCHAR(150)
);


/** Display the structure of the customer table */
DESCRIBE customer;


/** Display all records from the customer table */
SELECT * FROM customer;