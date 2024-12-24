# Employee Management System Using Spring Boot 🚀

## Overview
The **Employee Management System** is a Spring Boot-based web application that simplifies employee record management. It provides a clean and user-friendly interface for performing CRUD operations (Create, Read, Update, Delete) on employee data. Built using the MVC (Model-View-Controller) architecture, this project ensures a modular structure for easy scalability and maintenance.

## Features 🌟
- 📝 **Add Employees**: Enter and save new employee details in the database.
- 📋 **View Employees**: Display a list of all employees or search for specific ones.
- ✏️ **Update Employee Details**: Modify existing employee information with ease.
- ❌ **Delete Employees**: Remove employee records when necessary.
- 🎨 **Responsive Interface**: The front-end is designed with Thymeleaf templates to ensure clarity and usability.

## How It Works ⚙️
1. **Home Page**: Displays an overview and navigation links for actions like adding, viewing, and updating employees.
2. **Add Employee Page**: A form to input employee details (name, email, position, etc.) and save them to the database.
3. **View Employees Page**: Lists all employee records fetched from the MySQL database.
4. **Edit Employee Page**: Allows updating of selected employee information.
5. **Delete Functionality**: Utilizes JavaScript for delete operations as HTML does not natively support DELETE requests.

## Technologies Used 💻
- **Backend**: Spring Boot, Java
- **Frontend**: Thymeleaf, HTML, CSS, JavaScript
- **Database**: MySQL
- **Build Tool**: Maven

## Project Structure 📂
```
EmployeeCRUD/
├── src/main/java
│   ├── com.empsCrud.EmployeeCRUD
│   │   ├── Controller
│   │   ├── Service
│   │   ├── Repo
│   │   └── Exception
├── src/main/resources
│   ├── static
│   ├── templates
│   │   ├── index.html
│   │   ├── add-employee.html
│   │   ├── update-employee.html
│   └── application.properties
└── pom.xml
```

## Prerequisites 📌
- **Java**: Version 17 or later.
- **Maven**: Build and dependency management tool.
- **MySQL**: For data storage.
- **IDE**: IntelliJ IDEA, Eclipse, or any preferred IDE.

## Setup and Installation ⚙️
Follow these steps to set up and run the project on your local machine:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Niketan2004/EmployeeCRUD.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd EmployeeCRUD
   ```

3. **Configure the Database**:
   Open `src/main/resources/application.properties` and set up your MySQL database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Build the Project**:
   ```bash
   mvn clean install
   ```

5. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

6. **Access the Application**:
   Open your browser and navigate to:
   ```
   http://localhost:8080
   ```

## Key Components 🔑
- **Main Class**: `EmployeeCrudApplication.java` initializes and runs the application.
- **Controllers**:
  - `EmployeeController.java`: Handles HTTP requests and responses for employee operations.
  - `GlobalExceptionHandler.java`: Manages exceptions gracefully.
- **Service**:
  - `EmployeeService.java`: Implements business logic for employee management.
- **Repository**:
  - `EmployeeRepo.java`: Provides database access using Spring Data JPA.

## Endpoints 📡
| HTTP Method | Endpoint          | Description                       |
|-------------|-------------------|-----------------------------------|
| GET         | `/employees`      | Retrieve all employee records     |
| GET         | `/employees/{id}` | Retrieve a specific employee      |
| POST        | `/employees`      | Add a new employee record         |
| PUT         | `/employees/{id}` | Update an existing employee record|
| DELETE      | `/employees/{id}` | Delete an employee record         |

## Known Issues ⚠️
- **Delete Functionality**: Requires JavaScript as HTML forms do not support DELETE requests natively.Currently done via GET Mapping.

## Future Enhancements 🔮
- **Authentication**: Add user login and role-based access using Spring Security.
- **Design**: Improve UI/UX with CSS frameworks like Bootstrap.
- **Advanced Exception Handling**: Implement detailed error pages and custom messages.
- **Bug Fixes**: Improve overall code and fixing unnecessary code.

## Contributing 🤝
 Welcome to contributions! If you'd like to contribute:
- Fork the repository.
- Create a feature branch.
- Submit a pull request.

## Acknowledgments 🙌
- **Spring Boot Documentation**: For providing comprehensive guides.
- **Thymeleaf Documentation**: For template engine references.
- **MySQL Documentation**: For database integration resources.

