# Day 05 — Base Entity, Role Hierarchy & Strategy Pattern

## Objective

Establish reusable model foundations, define the employee role hierarchy, and implement the Strategy design pattern for leave-day calculation.

## Tasks Completed

### 1. BaseEntity

Create an abstract `BaseEntity` class containing common fields:

- `id` — unique identifier
- `createdAt` — record creation timestamp
- `updatedAt` — last update timestamp

**Purpose:** Avoid repeating common fields across entity classes and improve maintainability.

### 2. Role Hierarchy

Define the roles used in HorizonHR:

- `ADMIN`
- `HR`
- `MANAGER`
- `EMPLOYEE`

**Purpose:** Establish the foundation for role-based access control. Actual permissions and role hierarchy enforcement will be implemented in a later stage.

### 3. Strategy Design Pattern

Create the `LeaveDayCalculator` interface with a `calculateDays()` method.

Implement two strategies:

- `CalendarDayCalculator` — counts all calendar days, including weekends.
- `WeekdayLeaveDayCalculator` — counts weekdays and excludes Saturdays and Sundays.

**Purpose:** Allow leave calculation rules to change without modifying the calling code.

## Technologies Used

- Java
- Java Time API (`LocalDate`, `LocalDateTime`, `ChronoUnit`)
- Object-oriented programming
- Strategy design pattern
- Maven

## Validation

Run the following command from the HorizonHR project directory:

```powershell
.\mvnw.cmd clean compile
```

Expected result: `BUILD SUCCESS`.

## Learning Outcomes

- Understand abstract classes and code reuse.
- Understand enums and role-based access concepts.
- Apply the Strategy design pattern.
- Use Java's date and time API.
- Separate business rules from their callers.

## Git Workflow

The original assignment requested a feature branch and pull request. This work is currently being continued on `main` as chosen for this project session, so the feature-branch and pull-request workflow is not fulfilled by that approach.

## Next Steps

- Add unit tests for both leave-day calculation strategies.
- Add explicit role hierarchy and permission checks.
- Integrate leave calculation with the leave request workflow.
- Extend leave calculation to account for company holidays.

