# Customer Service API

A RESTful CRUD API built with Spring Boot 3, MongoDB, and Java 21. Designed as a clean, production-ready foundation with Keycloak authentication integration planned.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3 |
| Database | MongoDB |
| Documentation | SpringDoc OpenAPI (Swagger UI) |
| Boilerplate reduction | Lombok |
| Containerization | Docker |

---

## Getting Started

### Prerequisites

- Java 21
- Maven 3.8+
- Docker (for MongoDB)

### 1. Start MongoDB

```bash
docker run -d \
  --name mongodb \
  -p 27017:27017 \
  mongo:latest
```

### 2. Clone and Run

```bash
git clone https://github.com/uddika/customer-service.git
cd customer-service
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

---

## API Endpoints

Base URL: `/api/v1/customers`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/` | Register a new customer |
| `GET` | `/` | Get all customers |
| `GET` | `/{id}` | Get customer by ID |
| `PUT` | `/{id}` | Update customer |
| `DELETE` | `/{id}` | Delete customer |
| `GET` | `/search?q=` | Search by name |

### Sample Request — Create Customer

```bash
curl -X POST http://localhost:8080/api/v1/customers \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "phone": "+94771234567",
    "address": "123 Main Street, Colombo 03"
  }'
```

### Sample Response — `201 Created`

```json
{
  "id": "665f1a2b3c4d5e6f7a8b9c0d",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phone": "+94771234567",
  "address": "123 Main Street, Colombo 03",
  "active": true,
  "createdAt": "2026-05-01T10:30:00",
  "updatedAt": "2026-05-01T10:30:00"
}
```

---

## API Documentation

Swagger UI is available once the app is running:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Project Structure

```
src/main/java/com/example/customerservice/
├── CustomerServiceApplication.java
├── config/
│   ├── MongoConfig.java
│   └── SwaggerConfig.java
├── controller/
│   └── CustomerController.java
├── dto/
│   ├── CustomerRequest.java
│   └── CustomerResponse.java
├── exception/
│   ├── CustomerNotFoundException.java
│   └── GlobalExceptionHandler.java
├── model/
│   └── Customer.java
├── repository/
│   └── CustomerRepository.java
└── service/
    └── CustomerService.java
```

---

## Configuration

`src/main/resources/application.properties`

```properties
spring.application.name=customer-service
server.port=8080
spring.data.mongodb.uri=mongodb://localhost:27017/customerdb
spring.data.mongodb.auto-index-creation=true
```

---

## Roadmap

- [x] Customer CRUD API
- [x] Bean Validation
- [x] Global Exception Handling (RFC 7807 Problem Details)
- [x] Swagger / OpenAPI documentation
- [ ] Keycloak integration (OAuth2 / JWT authentication)
- [ ] Role-based access control (RBAC)
- [ ] Pagination and sorting
- [ ] Unit and integration tests
- [ ] Docker Compose setup (app + MongoDB + Keycloak)

---

## Author

**Uddika**
- Website: [uddika.lk](https://uddika.lk)
- Email: uddika0296@gmail.com
