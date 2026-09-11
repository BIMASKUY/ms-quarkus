# Basic API ms-quarkus

A REST service built with Quarkus for a technical test. Quarkus was chosen over Spring Boot due to its faster startup and lower resource usage, with GraalVM native compilation enabling near-instant boot times and a significantly faster hot reload cycle during development.

## Tech Stack

- Quarkus 3.27.5.2
- Java 21

## Project Structure

```
src/main/java/com/mpkmb
├── configuration
│   └── OpenApiConfig
├── controller
│   ├── OrderController
│   └── ProductController
├── dto
│   ├── request
│   │   ├── CreateOrderRequest
│   │   └── CreateProductRequest
│   └── response
│       ├── OrderResponse
│       └── ProductResponse
├── entity
│   ├── Order
│   └── Product
├── repository
│   ├── OrderRepository
│   └── ProductRepository
└── service
    ├── OrderService
    └── ProductService
```

## Domain Model

| Entity  | Field    | Constraint    | Relation                       | Table    |
|---------|----------|---------------|--------------------------------|----------|
| Product | id       | Primary key   |                                | products |
| Product | name     | Not null      |                                | products |
| Product | price    | Minimum 1     |                                | products |
| Order   | id       | Primary key   |                                | orders   |
| Order   | quantity | Minimum 1     |                                | orders   |
| Order   | product  | Not null      | Many to one, lazy fetch        | orders   |

Hibernate runs with schema strategy `update`, so tables are created or migrated at boot.

## API Endpoints

| Method | Path        | Description                       |
|--------|-------------|-----------------------------------|
| GET    | /products   | Retrieve the list of products     |
| POST   | /products   | Create a product                  |
| GET    | /orders     | Retrieve the list of orders       |
| POST   | /orders     | Create an order                   |

Swagger UI is served at `/docs`.

## Environment Variables

- `DB_URL` PostgreSQL JDBC URL
- `DB_USERNAME` Database username
- `DB_PASSWORD` Database password

## Running the Application

```bash
./mvnw quarkus:dev
```

Starts the application in development mode with live reload enabled.

```bash
./mvnw package
```

Builds a runnable jar in `target/quarkus-app`.

```bash
java -jar target/quarkus-app/quarkus-run.jar
```

Runs the packaged JVM application.

```bash
./mvnw package -Dnative
```

Builds a GraalVM native executable in `target/` for fast startup and low memory usage, a key reason for using Quarkus.

## Notes From a Spring Boot Background

The main shift is the ORM. Spring Data JPA uses `findAll()` to read every row and `save(...)` to persist an entity. With Panache, those become `listAll()` and `persist()`. Most standard queries are inherited from `PanacheRepository`, so repositories stay empty unless a custom query is needed.

DI in Quarkus is CDI. `@ApplicationScoped` on a repository or service plays the same role as a singleton bean in Spring, and constructor injection still works the same way, so the controllers read like a typical Spring controller.

A Spring Boot developer can contribute to this project on day one once those few naming conventions are internalised.
