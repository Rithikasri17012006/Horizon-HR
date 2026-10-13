# Day 04 – HorizonHR

## Objective
Create model classes for the three core entities of the HorizonHR employee management system.

## Tasks Completed

### 1. Employee Model
Created the `Employee` class to represent employee information.

**Attributes:**
- `employeeId`
- `name`
- `email`
- `department`
- `reportingManager`
- `role`

### 2. Attendance Model
Created the `Attendance` class to represent employee attendance records.

**Attributes:**
- `attendanceId`
- `employeeId`
- `date`
- `checkInTime`
- `checkOutTime`
- `status`

**Java Time API:** Used `LocalDate` for attendance dates and `LocalTime` for check-in and check-out times.

### 3. LeaveRequest Model
Created the `LeaveRequest` class to represent employee leave applications.

**Attributes:**
- `requestId`
- `employeeId`
- `startDate`
- `endDate`
- `leaveType`
- `status`
- `reason`

**Java Time API:** Used `LocalDate` to represent the leave start and end dates.

## Concepts Learned
- Java classes and objects
- Encapsulation using private fields
- Constructors for object initialization
- Getter methods for accessing private fields
- Using `java.time` classes for dates and times
- Modeling real-world HR entities in Java

## Build Verification
Compiled the project using Maven:

```bash
./mvnw clean compile
```

**Expected result:** `BUILD SUCCESS`

## Outcome
Established the initial domain model for employee management, attendance tracking, and leave requests. These models will serve as the foundation for future HorizonHR business logic and service development.
