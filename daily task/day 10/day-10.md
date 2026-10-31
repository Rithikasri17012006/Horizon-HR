Day 10 --- Memory Review and Stack/Heap Analysis
Objective
Review the existing HorizonHR code for memory-related pitfalls and
explain how Java uses the Stack and Heap while a business method
executes.
Business Method Selected
CsvSeedDataLoader.loadEmployees(EmployeeRepository repository)

This method reads employee records from
src/main/resources/data/employees.csv, creates Employee objects, and
saves them in the repository.
Code Review: Memory Considerations
  Component               Memory consideration                  Review / recommendation
  InMemoryRepository    The storage map retains references  Remove records that are
to saved entities.                    no longer required;
avoid keeping
unnecessary
repositories alive.

  findAll()             new ArrayList<>(storage.values())   This is a shallow copy.
creates a new list but reuses the     Callers can still refer
same entity references.               to the same employee
objects.

  save()                Saving an existing ID replaces the    Define and test the
value associated with that key.       intended duplicate-ID
behavior.

  Employee              Its fields are private, but the class Consider final fields
is not immutable.                     and no setters if
employees should not be
modified after
construction.

  CsvSeedDataLoader     Each CSV row creates strings, an      Temporary parsing
array, and an employee object.        objects can become
eligible for garbage
collection when no
longer referenced.
LinkedHashMap         Stores map entries and references in  Suitable for this small
addition to the employee objects.     exercise; an in-memory
map is not intended for
unlimited production
data.
Stack vs Heap
- Stack: Holds method-call frames and local variables. A local
  variable that refers to an object stores the reference, not the
  entire object.
- Heap: Holds objects created at runtime, including the
  repository, map, employee instances, reader, strings, and arrays.
- Garbage collection: An object becomes eligible for garbage
  collection when it is no longer reachable. Eligibility does not mean
  it is collected immediately.
Execution Flow
1. loadEmployees(repository) is called and its stack frame is
   created.
2. The method obtains the CSV input stream and creates reader objects
   on the heap.
3. readLine() obtains a CSV row as a String.
4. split() creates a String[] containing the row's fields.
5. The method creates an Employee object.
6. repository.save(employee) is called, creating a save() stack
   frame.
7. save() extracts the employee ID and stores the employee reference
   in the LinkedHashMap.
8. The loader repeats this process for each CSV row.
9. When save() returns, its stack frame is removed. When
   loadEmployees() returns, its stack frame is also removed.
10. The employee objects remain reachable through the repository's map,
    so they are not eligible for garbage collection while that reference
    remains.
Stack/Heap Diagram
See [`stack-heap-diagram.png`](stack-heap-diagram.png) for a simplified
view of the method frames, local references, heap objects, and reference
relationships.
Key Learning Outcomes
- Distinguish local references from the objects they point to.
- Understand why objects can remain in the heap after a method
  returns.
- Recognize shallow-copy behavior in findAll().
- Identify how long-lived collections can retain objects.
- Understand that Java garbage collection depends on object
  reachability.
Completion
Day 10 completed --- reviewed memory considerations in the existing
repository and CSV-loading code and documented the Stack/Heap behavior
of loadEmployees().