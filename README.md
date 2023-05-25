<h1 align="center"> Digital Banking Application </h1>
<br>
This web application allows you to manage bank accounts. It is developed using Spring Boot for the backend and Angular for the frontend.

[![View Backend](https://img.shields.io/badge/View_Backend-GitHub-blue.svg)](https://github.com/oussama-tahri/Digital-Banking/tree/master/Digital%20Banking%20Backend) [![View Frontend](https://img.shields.io/badge/View_Frontend-GitHub-green.svg)](https://github.com/oussama-tahri/Digital-Banking/tree/master/Digital-Banking-Web)

## Description

The Digital Banking Application provides functionality to manage different types of bank accounts. There are two types of accounts: Current Account and Saving Account. Each account has a unique ID and specific attributes based on its type. Current Accounts have an Overdraft attribute, while Saving Accounts have an Interest Rate attribute.

In addition to the account details, each bank account maintains a list of operations performed on it. An operation includes an ID, operation date, amount, description, and type (debit, credit, or transfer). The account history keeps track of the account balance after each operation.

Customers are registered in the system and have the following attributes: ID, name, and email address. Customers can have multiple bank accounts associated with their profile.

## Backend

The backend of the Digital Banking Application is built with Spring Boot. It provides RESTful APIs to perform various operations on bank accounts and customers. The backend architecture follows a layered approach, consisting of the following components:

### Controllers

The controllers handle incoming requests and delegate the processing to the appropriate services. They are responsible for mapping API endpoints and validating request parameters.

### Services

The services contain the business logic of the application. They handle the core functionality, such as creating bank accounts, performing operations, retrieving account details, and managing customer information.

### Repositories

The repositories interact with the database to perform CRUD (Create, Read, Update, Delete) operations. They provide an abstraction layer between the application and the underlying data storage.

### Entities

The entities represent the domain objects of the application. They are mapped to database tables and define the structure of the data.

### Data Transfer Objects (DTOs)

DTOs are used to transfer data between the backend and frontend. They encapsulate the necessary information and provide a structured representation of the data.

## Frontend

The frontend of the Digital Banking Application is developed using Angular. It provides a user-friendly interface for interacting with the application.

The frontend architecture follows a component-based approach, consisting of the following components:

### Components

Components are responsible for rendering the user interface and handling user interactions. They encapsulate specific functionalities and can be reused across different pages.

### Services

Services in the frontend handle communication with the backend APIs. They make HTTP requests to fetch data and update the user interface accordingly.

### Models

Models represent the data structures used in the frontend. They mirror the backend DTOs and provide a consistent data format for the application.

## Getting Started

To run the Digital Banking Application locally, follow these steps:

1. Clone the repository from [GitHub](https://github.com/oussama-tahri/Digital-Banking.git).
2. Configure the backend by updating the necessary configuration files, such as database settings and API endpoints.
3. Build and run the backend application using your preferred IDE or by running the appropriate Maven commands.
4. Configure the frontend by updating the API endpoint URLs to match your backend setup.
5. Install the required dependencies for the frontend using `npm install`.
6. Build and run the frontend application using `ng serve`.
7. Access the application in your browser at `http://localhost:4200`.

## Conclusion

The Digital Banking Application provides a comprehensive solution for managing bank accounts and performing banking operations. With its Spring Boot backend and Angular frontend, it offers a robust and user-friendly interface for both customers and bank administrators. The application supports various operations such as creating customer profiles, opening different types of bank accounts, performing debit and credit transactions, transferring funds between accounts, and viewing transaction history.

By leveraging the power of Spring Boot and Angular, the application ensures scalability, security, and a seamless user experience. The modular architecture allows for easy extension and customization, making it suitable for future enhancements and integration with other systems.

To get started with the Digital Banking Application, follow the instructions provided in the "Getting Started" section above. Feel free to explore the backend and frontend repositories to understand the implementation details and contribute to the project.

For any questions or assistance, please refer to the respective repository's documentation and issue tracker. We appreciate your interest and contribution to the Digital Banking Application.

Thank you for choosing our application. Happy banking!
