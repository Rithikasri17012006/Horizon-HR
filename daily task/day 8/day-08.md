# Day 08 — Maps, Comparators & Sorted Reports

## Objective
Improve employee lookup efficiency using Maps and generate sorted employee reports using Comparators.

## Implementation

- **Map:** Used `LinkedHashMap` to store employee records by employee ID.
- **Fast Lookup:** Used `containsKey()` to check whether an employee exists.
- **Comparator 1:** Sorts employee records by employee name.
- **Comparator 2:** Sorts employee records by department.
- **Sorted Reports:** Added menu options to display employees sorted by name or department.
- **Existing Features:** Retained attendance tracking and leave request processing from Day 7.

## Testing

- Verified that the Maven build and tests completed successfully.
- Manually tested employee listing and the sorted report options.
- Retained the existing attendance and leave workflows.

## Key Learning

Learned how Maps support key-based lookups and how Comparators define custom sorting rules for Java collections.

## Limitations

Employee records and attendance actions are stored in memory and are lost when the application restarts. FR4–FR6 require verification against the original task specification.

## Status

Maps, two Comparators, and sorted employee reports implemented. Maven build successful.
