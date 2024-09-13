# Retailer Rewards Program API

This project is a Spring Boot Web API for a Retailer Rewards Program that calculates reward points based on customer transactions. Customers can earn reward points for purchases, and the API provides endpoints for retrieving reward points per customer for each month and total reward points.

## Features

- **Customer Registration**: Register customers with basic details like name, email, and password.
- **Transaction Processing**: Store and process customer transactions.
- **Reward Points Calculation**: Calculates monthly and total reward points for each customer based on their transactions.
- **RESTful API**: Provides endpoints to retrieve reward points by customer.
- **Security**: Basic security implementation (no login functionality).
- **Exception Handling**: Custom exceptions and error messages for better user feedback.
- **Test Coverage**: Includes unit tests for core functionality.
- **SOLID Principles**: Code follows SOLID principles for maintainability and scalability.

## Reward Points Calculation

The rewards program works as follows:
- For every transaction amount over $50, the customer earns 1 point for each dollar spent over $50.
- For every transaction amount over $100, the customer earns 2 points for each dollar spent over $100, in addition to the points from the $50 to $100 range.

### Example
- A $120 purchase will give:
  - 1 point for every dollar spent between $50 and $100 ($50 = 50 points).
  - 2 points for every dollar spent over $100 ($20 * 2 = 40 points).
  - Total: 90 points.

## Endpoints

### 1. **Customer APIs**
- `POST /api/customers/register`: Register a new customer.
- `GET /api/customers/{id}/rewards/total`: Get total reward points for a customer.
- `GET /api/customers/{id}/rewards/monthly`: Get reward points for each month for a customer.

### 2. **Transaction APIs**
- `POST /api/transactions`: Record a new transaction for a customer.

### Swagger Documentation

API documentation is available through Swagger UI at:  
`http://localhost:8080/swagger-ui.html`

## Technologies Used

- **Java 17**
- **Spring Boot**: Backend framework.
- **Spring Data JPA**: For database access.
- **H2 Database**: In-memory database for development.
- **JUnit**: Unit testing.
- **GitHub**: Version control.

## Setup and Run

### Prerequisites

- Java 17+
- Maven

