# Spring Security JWT Authentication

This repository contains a Spring Boot project with JWT (JSON Web Token) authentication for securing RESTful APIs. The project demonstrates how to create and validate JWT tokens, along with a basic setup for role-based authorization.

## Features
- JWT token generation and validation
- Role-based access control (ADMIN, USER)
- Stateless authentication using JWT
- Support for refresh tokens
- Custom UserDetailsService to load users from the database
- Basic token-based security for endpoints

## Project Structure

- **JwtTokenUtil.java**: Utility class for generating and validating JWT tokens.
- **JwtRequestFilter.java**: Filters incoming requests to check for valid JWT tokens.
- **SecurityConfig.java**: Spring Security configuration class, managing security policies and enabling stateless session management.
- **AuthController.java**: REST controller that exposes endpoints for user authentication and refresh tokens.
- **CustomUserDetailsService.java**: Custom implementation of UserDetailsService to load user details from the database.
- **User.java**: Entity class representing users in the database.
- **UserRepository.java**: Repository for accessing user data.

## Endpoints

- **/authenticate**: POST endpoint for user login, returns a JWT access token.
- **/refresh-token**: POST endpoint to refresh an expired access token.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 
- MySQL 

### Running the Application

1. Clone the repository:
    ```bash
    git clone https://github.com/breddy9948/spring-security-jwt-auth.git
    ```

2. Navigate to the project directory:
    ```bash
    cd spring-security-jwt-auth
    ```

3. Configure the application properties:
   Update `src/main/resources/application.properties` with your database credentials.

4. Build the project:
    ```bash
    mvn clean install
    ```

5. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### Testing the API

1. **Authenticate User**:
    ```bash
    POST /authenticate
    ```

    Body:
    ```json
    {
      "username": "your-username",
      "password": "your-password"
    }
    ```

    Response: A JWT token.

2. **Access Protected Endpoints**:
    Include the JWT token in the `Authorization` header as:
    ```bash
    Authorization: Bearer <your-token>
    ```

3. **Refresh Token**:
    ```bash
    POST /refresh-token
    ```

    Include the refresh token in the `Authorization` header as:
    ```bash
    Authorization: Bearer <your-refresh-token>
    ```


