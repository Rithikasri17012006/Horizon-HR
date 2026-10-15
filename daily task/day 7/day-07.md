# Day 07 — Collections and Console Workflows

## Objective
Use Java Collections Framework classes to store and manage HorizonHR data and implement FR1–FR3 in the console application.

## Implementation

- **List:** Stores employee records and supports listing and adding employees.
- **Set:** Prevents duplicate check-in and check-out actions for the same employee on the same date.
- **Queue:** Stores pending leave requests and processes them in FIFO order.
- **FR1 — Employee Management:** View existing employees and add new employees.
- **FR2 — Attendance Management:** Record check-in and check-out actions.
- **FR3 — Leave Application:** Submit leave requests with an employee ID, leave type, and date range.
- Added input validation and error handling for invalid menu selections and leave request details.

## Testing

- Tested employee listing and employee creation.
- Tested attendance action recording and duplicate prevention.
- Submitted a leave request and processed it from the queue.
- Ran Maven tests to verify compilation and existing tests.

## Key Learning

Learned how `List`, `Set`, and `Queue` support different data-management requirements in a console application.

## Limitations

The collections store strings rather than domain entity objects, and the data is held in memory only. Attendance sequencing, leave-balance validation, and approval workflows require further implementation.

## Status

Basic FR1–FR3 console workflows implemented. Further refinement may be needed to satisfy strict entity-based collection requirements.