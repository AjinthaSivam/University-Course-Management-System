# University Course Management System

### Overview
The University Course Management System (UCMS) is a backend application built with Spring Boot to manage university courses, students, and related operations. It provides a robust RESTful API for handling course registrations, student records, and administrative tasks. This repository contains the backend implementation, designed to be scalable and easy to integrate with a frontend application.

### Prerequisites
To run this project locally, ensure you have the following installed:
- Java: Version 17 or higher (JDK)
- Maven: Version 3.6 or higher
- Database: MySQL
- IDE: Optional (e.g., IntelliJ IDEA, Eclipse, or VS Code for easier development)

### Installation
Follow these steps to set up the project locally:
1. Clone the Repository:
```
git clone https://github.com/AjinthaSivam/University-Course-Management-System.git
cd University-Course-Management-System
```
2. Set Up the Database:
- Install and configure your preferred database (e.g., MySQL or PostgreSQL).
- Create a new database for the application (e.g., ucms_db).
- Update the database configuration in src/main/resources/application.properties or application.yml with your database credentials:
```
spring.datasource.url=jdbc:mysql://localhost:3306/ucms_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
3. Install Dependencies:
- Ensure Maven is installed.
- Run the following command to download dependencies:
```
mvn clean install
```

### Running the Application
1. Build and Run:
- Use Maven to build and start the Spring Boot application:
```
mvn spring-boot:run
```
- Alternatively, if you're using an IDE, import the project as a Maven project and run the main class (usually UcmsApplication.java).
2. Access the Application:
- The application will start on http://localhost:8080 by default.
- Use tools like Postman or cURL to test the REST APIs, or connect it to your frontend application.

### API Endpoints
Below are some example endpoints (adjust based on your actual implementation):
- GET /api/courses: Retrieve a list of all courses.
- POST /api/courses: Create a new course.
- GET /api/students: Retrieve a list of all students.
- POST /api/students: Register a new student.
For a complete list of endpoints, refer to the API documentation (if available) or check the controller classes in src/main/java/com/example/ucms/controller.

### Configuration
- Port: Modify the server port in application.properties if needed:
```
server.port=8080
```
- Logging: Adjust logging levels in application.properties:
```
logging.level.org.springframework=INFO
logging.level.com.example.ucms=DEBUG
```

### Troubleshooting
- Database Connection Issues: Ensure the database is running and credentials are correct in application.properties.
- Port Conflicts: If port 8080 is in use, change the server.port property or stop the conflicting process.
- Dependency Issues: Run mvn clean install to resolve missing dependencies.

### License
This project is licensed under the MIT License. See the LICENSE file for details.

