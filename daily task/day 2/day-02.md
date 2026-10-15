# Day 02 — Project Setup, Constants & Sample Data

## Objective

Set up the initial HorizonHR project repository and establish the foundation for business rules and sample data.

## Tasks Completed

### 1. Project Repository

Created the HorizonHR Git repository with:

- `.gitignore`
- `README.md`
- `daily-task` directory
- Initial Java source structure

### 2. Git Configuration

Configured `.gitignore` to exclude:

- Java compiled files
- Maven/Gradle build output
- IDE configuration files
- Logs
- Environment files
- Operating-system generated files

### 3. Business Rule Constants

Created a constants class to centralize initial HorizonHR business rules instead of scattering hard-coded values throughout the application.

Examples include:

- Daily attendance limits
- Default leave quota
- Carry-forward limits
- Working-day rules
- Approval-related configuration

### 4. Sample Data

Created a week of sample HR data using Java arrays to represent initial domain information such as:

- Employees
- Departments
- Dates
- Attendance status

This sample data will be replaced/evolved into persistent database-backed data as the application architecture is developed.

## Outcome

The initial project repository and Java foundation are ready for further development into the HorizonHR microservices architecture.

## Key Learning

Business rules should be centralized rather than hard-coded throughout the application. Sample data also provides an early way to validate domain requirements before introducing database persistence.