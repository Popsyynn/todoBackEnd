# todoBackEnd

This is the backend implementation of a ToDo List application built with Spring Boot. The backend provides RESTful APIs for managing tasks.

## Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Getting Started
To get started with the ToDo List backend, follow these steps:
### Prerequisites
- Java Development Kit (JDK) 8 or later
- MySQL database

### Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/Popsyynn/todoBackEnd.git

2.Navigate to project     cd todoBackEnd

3. Configure database connection  Open src/main/resources/application.properties and configure the MySQL database connection:
4. Build the project using Maven:

mvn clean install
5. Run the application:

mvn spring-boot:run

The backend server will start running at http://localhost:8080.

API Documentation
The backend provides the following APIs:

GET http://localhost:8080/api/get - Retrieve all tasks.
POST http://localhost:8080/api/save - Create a new task.
GET http://localhost:8080/api/get/{id} - Retrieve a specific task by ID.
PUT http://localhost:8080/update/{id} - Update a task.
DELETE http://localhost:8080/api/delete/{id} - Delete a task.

   
