
package com.horizonhr;

import com.horizonhr.data.SampleData;
import java.time.LocalDate;
import java.util.*;

public class ConsoleMenu {

    // Map provides fast employee lookup by ID
    private static final Map<String, String> employees =
            new LinkedHashMap<>();

    // Set prevents duplicate attendance actions
    private static final Set<String> attendanceActions =
            new HashSet<>();

    // Queue stores pending leave requests
    private static final Queue<String> leaveRequests =
            new LinkedList<>();

    // Comparator 1: Sort employees by name
    private static final Comparator<String> BY_NAME =
            Comparator.comparing(
                    e -> e.split(" - ")[1],
                    String.CASE_INSENSITIVE_ORDER
            );

    // Comparator 2: Sort employees by department
    private static final Comparator<String> BY_DEPARTMENT =
            Comparator.comparing(
                    e -> e.split(" - ")[2],
                    String.CASE_INSENSITIVE_ORDER
            );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < SampleData.EMPLOYEE_IDS.length; i++) {
            String id = SampleData.EMPLOYEE_IDS[i];
            String record = id + " - "
                    + SampleData.EMPLOYEE_NAMES[i] + " - "
                    + SampleData.DEPARTMENTS[i];

            employees.put(id, record);
        }

        while (true) {
            System.out.println("\n===== HorizonHR =====");
            System.out.println("1. Employee Management (FR1)");
            System.out.println("2. Check In / Check Out (FR2)");
            System.out.println("3. Apply for Leave (FR3)");
            System.out.println("4. Process Next Leave Request");
            System.out.println("5. Employee Report Sorted by Name");
            System.out.println("6. Employee Report Sorted by Department");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        employees.values().forEach(System.out::println);

                        System.out.print("Add employee? (y/n): ");
                        if (scanner.nextLine().equalsIgnoreCase("y")) {
                            System.out.print("Employee ID: ");
                            String id = scanner.nextLine().trim();

                            if (id.isEmpty() || employees.containsKey(id)) {
                                System.out.println(
                                        "Invalid or duplicate employee ID.");
                                break;
                            }

                            System.out.print("Employee name: ");
                            String name = scanner.nextLine().trim();

                            System.out.print("Department: ");
                            String department = scanner.nextLine().trim();

                            if (name.isEmpty() || department.isEmpty()) {
                                System.out.println(
                                        "Name and department are required.");
                                break;
                            }

                            employees.put(id,
                                    id + " - " + name + " - " + department);

                            System.out.println("Employee added.");
                        }
                        break;

                    case "2":
                        System.out.print("Employee ID: ");
                        String id = scanner.nextLine().trim();

                        if (!employees.containsKey(id)) {
                            System.out.println("Employee not found.");
                            break;
                        }

                        System.out.print("1. Check in  2. Check out: ");
                        String action = scanner.nextLine();

                        if (!action.equals("1") && !action.equals("2")) {
                            System.out.println("Invalid action.");
                            break;
                        }

                        String key = id + "|" + LocalDate.now()
                                + "|" + action;

                        if (!attendanceActions.add(key)) {
                            System.out.println(
                                    "This attendance action was already recorded today.");
                        } else {
                            System.out.println(action.equals("1")
                                    ? "Check-in recorded."
                                    : "Check-out recorded.");
                        }
                        break;

                    case "3":
                        System.out.print("Employee ID: ");
                        String employeeId = scanner.nextLine().trim();

                        if (!employees.containsKey(employeeId)) {
                            System.out.println("Employee not found.");
                            break;
                        }

                        System.out.print("Leave type: ");
                        String leaveType = scanner.nextLine().trim();

                        System.out.print("Start date (YYYY-MM-DD): ");
                        LocalDate startDate =
                                LocalDate.parse(scanner.nextLine().trim());

                        System.out.print("End date (YYYY-MM-DD): ");
                        LocalDate endDate =
                                LocalDate.parse(scanner.nextLine().trim());

                        if (leaveType.isEmpty()
                                || endDate.isBefore(startDate)) {
                            System.out.println("Invalid leave request.");
                            break;
                        }

                        leaveRequests.offer(employeeId + " | "
                                + leaveType + " | " + startDate
                                + " to " + endDate);

                        System.out.println("Leave request added to queue.");
                        break;

                    case "4":
                        String request = leaveRequests.poll();

                        System.out.println(request == null
                                ? "No pending leave requests."
                                : "Processing leave request: " + request);
                        break;

                    case "5":
                        System.out.println("\nEmployees sorted by name:");
                        employees.values().stream()
                                .sorted(BY_NAME)
                                .forEach(System.out::println);
                        break;

                    case "6":
                        System.out.println("\nEmployees sorted by department:");
                        employees.values().stream()
                                .sorted(BY_DEPARTMENT)
                                .forEach(System.out::println);
                        break;

                    case "0":
                        System.out.println("Exiting HorizonHR...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (RuntimeException exception) {
                System.out.println("Error: Invalid input or operation. "
                        + exception.getMessage());
            }
        }
    }
}