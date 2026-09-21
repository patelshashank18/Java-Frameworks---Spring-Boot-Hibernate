# Customer Management System

A simple **Customer Management System** built using **Spring Boot, Spring Data JPA, MySQL, HTML, CSS, and JavaScript**.

This project demonstrates basic **CRUD operations** through REST APIs and provides a simple web interface for managing customer records.

## Features

* Add a new customer
* View all customers
* View a customer by ID
* Update customer details
* Delete a customer
* Simple and responsive user interface
* MySQL database integration
* RESTful APIs
* Spring Data JPA for database operations

## Technologies Used

| Technology      | Purpose                      |
| --------------- | ---------------------------- |
| Java            | Programming language         |
| Spring Boot     | Backend framework            |
| Spring Data JPA | Database operations          |
| Hibernate       | ORM                          |
| MySQL           | Database                     |
| HTML            | Frontend structure           |
| CSS             | Frontend styling             |
| JavaScript      | Frontend functionality       |
| Maven           | Project management and build |

## Project Structure

 text
fst-5/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── fst5/
│   │   │       └── practical/
│   │   │           └── customermanagement/
│   │   │               ├── controller/
│   │   │               │   └── CustomerController.java
│   │   │               ├── dto/
│   │   │               │   └── CustomerDto.java
│   │   │               ├── entity/
│   │   │               │   └── Customer.java
│   │   │               ├── repository/
│   │   │               │   └── CustomerRepository.java
│   │   │               ├── service/
│   │   │               │   ├── CustomerService.java
│   │   │               │   ├── GenericService.java
│   │   │               │   └── impl/
│   │   │               │       └── CustomerServiceImpl.java
│   │   │               └── DemoApplication.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │           ├── EmployeeData.sql
│   │           ├── index.html
│   │           └── style.css
│   │
│   └── test/
│       └── java/
│
├── pom.xml
├── mvnw
└── mvnw.cmd
 

## Customer Details

The system manages the following customer information:

* Customer ID
* First Name
* Last Name
* Date of Birth
* Mobile Number
* Address 1
* Address 2
* Age
* Gender
* Email

## Database Setup

The project uses **MySQL**.

### 1. Create the database

Open MySQL or DBeaver and run:


CREATE DATABASE EmployeeData;


### 2. Select the database


USE EmployeeData;

### 3. Create the customer table


CREATE TABLE customer (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100) NOT NULL,

    date_of_birth DATE NOT NULL,

    mobile VARCHAR(20) NOT NULL UNIQUE,

    address1 VARCHAR(255),

    address2 VARCHAR(255),

    age INT,

    gender VARCHAR(20),

    email VARCHAR(150)
);

The complete SQL script is available in:


src/main/resources/static/EmployeeData.sql

## Configure Database Connection

Open:


src/main/resources/application.properties


Configure your MySQL connection:

properties
spring.application.name=customer-management

spring.datasource.url=jdbc:mysql://localhost:3306/EmployeeData
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> Change the MySQL username and password according to your local MySQL configuration.

## Run the Application

Open the terminal and navigate to the project:


cd "Java Frameworks - Spring Boot & Hibernate/fst-5"


Run the Spring Boot application:


./mvnw spring-boot:run


On Windows:


mvnw.cmd spring-boot:run

The application will start on:


http://localhost:8080

## Open the Frontend

Since `index.html` is inside Spring Boot's `static` folder, open:


http://localhost:8080/


The Customer Management System page will be displayed.

## REST API Endpoints

The application provides the following endpoints.

### Create Customer


POST /customers

Example request:

{
    "firstName": "Rahul",
    "lastName": "Patel",
    "dateOfBirth": "1998-05-10",
    "mobile": "9876543210",
    "address1": "Ahmedabad",
    "address2": "Gujarat",
    "age": 28,
    "gender": "Male",
    "email": "rahul@gmail.com"
}


### Get All Customers


GET /customers


Returns all customer records.

### Get Customer by ID


GET /customers/{id}

Example:


GET /customers/1

### Update Customer


PUT /customers/{id}

Example:


PUT /customers/1


Example request:

{
    "firstName": "Rahul",
    "lastName": "Patel",
    "dateOfBirth": "1998-05-10",
    "mobile": "9876543210",
    "address1": "Ahmedabad",
    "address2": "Gujarat",
    "age": 29,
    "gender": "Male",
    "email": "rahulpatel@gmail.com"
}

### Delete Customer


DELETE /customers/{id}

Example:


DELETE /customers/1


## CRUD Flow


             Customer Management System
                       |
          ┌────────────┼────────────┐
          |            |            |
        CREATE        READ        UPDATE
          |            |            |
         POST       GET /customers  PUT
          |            |            |
          └────────────┼────────────┘
                       |
                     DELETE
                       |
                      DELETE


## Application Screens

The web interface contains:

### Customer Form

Users can enter:


First Name
Last Name
Date of Birth
Mobile
Address 1
Address 2
Age
Gender
Email


The form provides:

* Add Customer
* Update Customer
* Clear

### Customer List

The customer table displays:

* ID
* First Name
* Last Name
* Date of Birth
* Mobile
* Address
* Age
* Gender
* Email
* Update
* Delete

## Update Operation

To update a customer:

1. Click the **Update** button for a customer.
2. Existing customer information is loaded into the form.
3. Modify the required information.
4. Click **Update Customer**.
5. The frontend sends a `PUT` request to the backend.
6. The database record is updated.
7. The customer list is refreshed.

## Delete Operation

To delete a customer:

1. Click the **Delete** button.
2. A confirmation message is displayed.
3. Confirm the deletion.
4. The frontend sends a `DELETE` request.
5. The customer is removed from the database.
6. The customer list is refreshed.

## Testing APIs

You can test the REST APIs using tools such as:

* Postman
* Browser for GET requests
* The application's web interface

Example:


GET http://localhost:8080/customers


## Author

Developed as a Spring Boot and Hibernate practical project.

## License

This project is created for learning and educational purposes.
