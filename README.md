# Vet Clinic API - Spring Boot + Testing

This project is a backend application for a veterinary clinic built with **Java and Spring Boot**.  
It implements a basic CRUD system for managing **pets and their owners**, with a strong focus on **unit and integration testing**.

---

## Features

- CRUD operations for:
  - Pets
  - Owners
- Layered architecture:
  - Controller
  - Service
  - Repository
  - DTO
  - Model
- Input validation for entities
- RESTful API design

---

## 🧪 Testing (Main Focus)

This project was designed to validate knowledge in backend testing using Spring Boot.

### ✅ Unit Tests
- Service layer testing using:
  - JUnit
  - Mockito
- Examples:
  - Save pet
  - Get pet by ID

### ✅ Controller Tests
- Using:
  - MockMvc / WebMvcTest
- Examples:
  - Get list of pet owners
  - Get owners filtered by species ("caniches")

### ✅ Integration Tests
- Using:
  - SpringBootTest
- Full flow validation:
  - Controller → Service → Repository → Database
- Examples:
  - Save pet and verify persistence
  - Get owner by pet ID

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- JUnit 5
- Mockito
- MockMvc
- SpringBootTest
- H2 / Relational Database

---
