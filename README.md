## Spring Boot Unit Testing with JUnit & Mockito

This project demonstrates robust unit testing in a Spring Boot application using **JUnit**, **Mockito**, and **Spring Boot Starter Test**. It focuses on creating and verifying tests for the **Controller**, **Service**, and **Repository** layers of a RESTful API that manages `Teacher` entities.

## 📚 Project Overview

Built with Spring Boot, this RESTful application handles `Teacher` entity data — including `ID`, `name`, `email`, `phone`, and `course taught`. The following controller methods are fully tested:

- `save()` – Save a new teacher
- `fetchDataById()` – Retrieve a teacher by ID
- `fetchDataByName()` – Retrieve a teacher by name
- `fetchDataByCourse()` – Retrieve teachers by course

Each layer of the application is rigorously tested to ensure **data persistence**, **business logic correctness**, and **API reliability**.

## 🧰 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **H2 / MySQL (optional for testing)**
- **JUnit 5**
- **Mockito**
- **MockBean**
- **Builder pattern for test objects**

## ✅ Key Testing Tools

### 🔹 Mockito
Used to create mock objects, allowing you to test components in isolation by simulating dependencies.

### 🔹 MockBean
Spring Boot annotation that allows mocking of Spring-managed beans for injection during testing.

### 🔹 Builder Pattern
Used to create flexible and readable test data with custom attributes for comprehensive test coverage.

## 🧪 Test Coverage Highlights

- ✅ Controller Layer Unit Tests  
  Validates all API endpoints using mocked service logic.

- ✅ Service Layer Unit Tests  
  Ensures business logic runs as expected with mocked repository behavior.

- ✅ Repository Layer Tests  
  Optionally uses H2 or real DB for integration-like testing of JPA queries.