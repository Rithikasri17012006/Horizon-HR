# Day 9 — Generic Repository and CSV Seed Data

## Objective
Implement a reusable generic CRUD repository and load initial employee data from a CSV file.

## Tasks Completed

- Created `CrudRepository<T, ID>` interface defining common CRUD operations.
- Implemented `InMemoryRepository<T, ID>` using `LinkedHashMap` for in-memory data storage.
- Created `EmployeeRepository` by extending the generic repository.
- Implemented `CsvSeedDataLoader` to read employee records from a CSV resource.
- Added sample employee data in `src/main/resources/data/employees.csv`.
- Created `EmployeeRepositoryTest` to verify CSV loading and employee lookup.

## Repository Operations

| Method | Purpose |
|---|---|
| `save()` | Saves or updates an entity |
| `findById()` | Retrieves an entity by ID |
| `findAll()` | Returns all stored entities |
| `deleteById()` | Deletes an entity by ID |
| `existsById()` | Checks whether an ID exists |

## Technologies Used

- Java
- Generics
- Java Collections (`Map`, `LinkedHashMap`, `List`)
- Functional interfaces (`Function`)
- CSV file handling
- JUnit 5
- Maven

## Testing

Executed the following command:

```powershell
.\mvnw.cmd clean test
```

**Result:** `BUILD SUCCESS`

The employee repository test verifies that employee records are loaded from the CSV file and that employee lookup works correctly.

## Key Learning Outcomes

- Understand how Java generics enable reusable repository implementations.
- Separate repository contracts from their implementations.
- Use `Function<T, ID>` to extract entity identifiers.
- Load seed data from classpath resources.
- Write automated unit tests using JUnit 5.

## Project Status

Day 9 completed — generic repository implementation, CSV seed data loading, and automated tests are passing.
