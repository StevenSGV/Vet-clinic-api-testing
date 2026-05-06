# VetCare API Testing

Backend REST API for a veterinary clinic built with **Java** and **Spring Boot**.  
This project was developed to practice **CRUD operations**, **layered architecture**, environment-based configuration with **Spring Profiles**, and especially **backend testing** with **unit test and integration tests**.

## Overview

The application allows basic management of **pets** and **owners**, following a clean backend structure and RESTful principles.  
Its main purpose is to demonstrate practical knowledge of Spring Boot development, profile-based configuration, and software testing.

## Features

- Manage **pets** and **owners**
- Perform **CRUD operations**
- Apply **input validation**
- Implement **custom validation** for species values
- Use a **layered architecture**
- Expose a **RESTful API**
- Configure the application using **Spring Profiles**
- Include different types of automated tests

## Project Structure

The project is organized using a standard layered architecture:

- **Controller** → Handles HTTP requests and responses
- **Service** → Contains business logic
- **Repository** → Manages database access
- **DTO** → Transfers data between layers
- **Model** → Represents application entities
- **Validation** → Contains custom validation logic

## Profiles

The application uses **Spring Profiles** to manage different environments and configurations.

### Available profiles

- **`test`** → Main profile used during development of automated tests
- **`dev`** → Local development configuration
- **`prod`** → Production-oriented configuration

The project includes:

- `application-test.properties`
- `application-dev.properties`
- `application-prod.properties`

For **development** and **production** environments, the application is configured to work with a **MySQL** database.

This setup helped reinforce practical knowledge of:

- environment separation
- externalized configuration
- test-focused setup
- database configuration for different stages of the application

## Testing

One of the main goals of this project is to strengthen backend testing skills in Spring Boot.

### Unit Testing
Focused on validating service-layer logic in isolation.

**Tools used:**
- JUnit 5
- Mockito

**Examples:**
- Save a pet
- Retrieve a pet by ID

### Controller Testing
Focused on validating endpoint behavior without loading the full application context.

**Tools used:**
- MockMvc
- WebMvcTest

**Examples:**
- Retrieve the list of pet owners
- Filter owners by species

### Integration Testing
Focused on validating the complete flow from controller to database.

**Tools used:**
- SpringBootTest

**Examples:**
- Save a pet and verify persistence
- Retrieve an owner by pet ID

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- JUnit 5
- Mockito
- MockMvc
- Spring Boot Test
- MySQL
- H2 Database

## Purpose

This project is part of my backend developer portfolio and reflects hands-on practice with both **application development** and **testing in Spring Boot**.
