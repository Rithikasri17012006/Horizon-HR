# Day 6 — Custom Exceptions & Business Rule Validation

## Objective

Introduce custom exception handling and enforce business rules for leave requests in the HorizonHR application.

## Tasks Completed

### 1. Custom Exception Classes

Created a dedicated `exception` package containing:

- `InvalidLeaveRequestException` — handles invalid leave dates.
- `EmployeeNotFoundException` — handles leave requests for employees who do not exist.

Both exceptions extend Java's `RuntimeException`, allowing errors to be reported without requiring explicit exception declarations.

### 2. Business Rule Validation

Implemented two validation rules in the `LeaveRequest` model:

**Rule 1: Leave Date Validation**
- Start date and end date must not be null.
- End date cannot be earlier than the start date.
- Invalid dates trigger `InvalidLeaveRequestException`.

**Rule 2: Employee Validation**
- The employee ID must match an existing employee in the sample data.
- Invalid or unknown employee IDs trigger `EmployeeNotFoundException`.

### 3. Console Menu Error Handling

Updated `ConsoleMenu` to:

- Handle non-numeric menu input.
- Reject menu options outside the valid range.
- Catch runtime exceptions and display an error message.
- Return to the main menu after invalid input instead of terminating the loop.

### 4. Build and Verification

- Verified Java compilation.
- Executed `mvnw.cmd clean test` successfully.
- Ran the console menu and checked invalid input, invalid menu options, and normal exit.

## Files Created or Updated

- `src/main/java/com/horizonhr/exception/InvalidLeaveRequestException.java`
- `src/main/java/com/horizonhr/exception/EmployeeNotFoundException.java`
- `src/main/java/com/horizonhr/model/LeaveRequest.java`
- `src/main/java/com/horizonhr/ConsoleMenu.java`
- `pom.xml`

## Key Learning Outcomes

- Creating meaningful custom exceptions.
- Enforcing business rules at the model level.
- Validating dates using Java's `LocalDate` API.
- Handling invalid user input without terminating the application.
- Understanding the difference between compile-time verification and runtime testing.

## Current Limitation

The leave validation rules are implemented in the `LeaveRequest` constructor but are not yet connected to an interactive leave-request workflow in the console menu. Integrating and testing these validations through the actual workflow remains future work.

## Day 6 Status

**Completed:** Custom exception classes, two business validations, console input recovery, and successful build verification.
