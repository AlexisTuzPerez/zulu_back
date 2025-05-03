
## Overview

Zulu Back is a backend system designed to manage bookstore operations efficiently. It provides a complete solution for managing products, customers, sales, and inventory across multiple locations.

## Key Features

### Technical Highlights
- 💾 Complete Database Design according to business logic
- 🧩 Postgresql and Mongo DB Integration
- 📦 Implementing SQL Procedures

  ### API Endpoints
- 📚 Product management and inventory tracking
- 👥 Customer management
- 🛍️ Sales management
- 🏢 Warehouse management

## Technical Stack

### Backend
- **Framework**: Spring Boot
- **Language**: Java
- **Databases**: 
  - PostgreSQL 
  - MongoDB 
- **Security**: Spring Security
- **Validation**: Bean Validation
- **ORM**: Spring Data JPA
- **Dependency Injection**: Spring IoC

### Key Dependencies
```xml
- Spring Boot Web
- Spring Data JPA
- Spring Data MongoDB
- PostgreSQL Driver
- MongoDB Driver
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6.0 or higher
- PostgreSQL 15
- MongoDB

### Installation
1. Clone the repository
```bash
git clone https://github.com/AlexisTuzPerez/zulu_back
```

2. Configure application.yml
Edit the `src/main/resources/application.yml` file with your database configurations:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/zulu_bd
    username: your_username
    password: your_password
  data:
    mongodb:
      uri: mongodb://localhost:27017/zulu_bd

  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate.dialect: org.hibernate.dialect.PostgreSQLDialect
```

3. Build and run the application
```bash
./mvnw clean install
./mvnw spring-boot:run
```

## Project Structure

```
zulu_back/
├── src/main/java/com/zulu_bd/
│   ├── config/           # Application configuration
│   ├── controller/       # REST API controllers
│   ├── model/           # JPA entities
│   ├── repository/      # Data access repositories
│   ├── service/         # Business logic services
│   └── Main.java        # Application entry point
├── pom.xml
```


## API Documentation

### Base URL

http://localhost:8080

### Swagger UI

Access the interactive API documentation at:

http://localhost:8080/swagger-ui/index.html




## License

This project is proprietary and confidential. All rights reserved.

