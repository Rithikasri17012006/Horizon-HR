# Day 01 — User Stories, Story Points & Definition of Done

## Objective

Convert the HorizonHR functional requirements into user stories with story-point estimates and a common Definition of Done.

---

## User Stories

### US-01 — Employee, Department & Manager Management

**As an HR Admin,**  
I want to create and manage employees, departments, and reporting managers,  
so that the organization's employee structure is maintained accurately.

**Story Points:** 5

---

### US-02 — Daily Attendance

**As an Employee,**  
I want to check in and check out once per working day,  
so that my daily attendance and working hours are recorded.

**Story Points:** 5

---

### US-03 — Leave Application

**As an Employee,**  
I want to apply for leave by selecting a leave type and date range,  
so that I can request time off through the HR system.

**Story Points:** 5

---

### US-04 — Leave Validation

**As the HR system,**  
I want to validate leave balance and overlapping leave requests,  
so that employees cannot submit invalid leave requests.

**Story Points:** 8

---

### US-05 — Leave Approval & Rejection

**As a Manager,**  
I want to approve or reject employee leave requests with comments,  
so that leave requests can follow the organization's approval process.

**Story Points:** 5

---

### US-06 — Leave Balance & Cancellation

**As an Employee,**  
I want my leave balance to be automatically updated when leave is approved or cancelled,  
so that my available leave accurately reflects my usage.

**Story Points:** 8

---

### US-07 — Holiday & Leave Policy Configuration

**As an HR Admin,**  
I want to configure holidays and leave policies,  
so that leave calculations follow the organization's rules.

**Story Points:** 8

---

### US-08 — Team Attendance Reports

**As a Manager,**  
I want to view my team's monthly attendance report,  
so that I can monitor attendance and workforce availability.

**Story Points:** 8

---

# Definition of Done

A user story is considered complete when:

- The required functionality is implemented.
- Business rules are validated.
- Appropriate authorization is enforced.
- API responses and error handling are implemented.
- Database changes are completed where required.
- Unit/integration tests are added where applicable.
- The functionality is manually tested.
- No known critical defects remain.
- Code follows the project's coding standards.
- Changes are reviewed.
- Documentation is updated where necessary.
- Changes are committed and pushed to the Git repository.

---

# GitHub Project 

The user stories are added to the project board and can be tracked through stages such as:

**Backlog → To Do → In Progress → Review → Done**

Each story is assigned its corresponding story-point estimate.

---

# Key Learning

Through this task, the functional requirements were converted into user-focused, independently trackable work items. Story points were assigned based on the relative complexity of implementation, dependencies, validation, and testing.