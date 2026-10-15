
package com.horizonhr;

import com.horizonhr.data.SampleData;
import java.time.LocalDate;
import java.util.*;

public class ConsoleMenu {

    // List stores employee records
    private static final List<String> employees = new ArrayList<>();

    // Set prevents duplicate check-in/check-out actions
    private static final Set<String> attendanceActions = new HashSet<>();

    // Queue holds leave requests waiting for processing
    private static final Queue<String> leaveRequests = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < SampleData.EMPLOYEE_IDS.length; i++) {
            employees.add(
                SampleData.EMPLOYEE_IDS[i] + " - "
                + SampleData.EMPLOYEE_NAMES[i] + " - "
                + SampleData.DEPARTMENTS[i]
            );
        }

        while (true) {
            System.out.println("\n===== HorizonHR =====");
            System.out.println("1. Employee Management (FR1)");
            System.out.println("2. Check In / Check Out (FR2)");
            System.out.println("3. Apply for Leave (FR3)");
            System.out.println("4. Process Next Leave Request");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.println("\nEmployees:");
                        employees.forEach(System.out::println);

                        System.out.print("Add employee? (y/n): ");
                        if (scanner.nextLine().equalsIgnoreCase("y")) {
                            System.out.print("Employee ID: ");
                            String id = scanner.nextLine().trim();

                            boolean exists = employees.stream()
                                .anyMatch(e -> e.startsWith(id + " -"));

                            if (id.isEmpty() || exists) {
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

                            employees.add(id + " - " + name
                                + " - " + department);
                            System.out.println("Employee added.");
                        }
                        break;

                    case "2":
                        System.out.print("Employee ID: ");
                        String id = scanner.nextLine().trim();

                        boolean employeeExists = employees.stream()
                            .anyMatch(e -> e.startsWith(id + " -"));

                        if (!employeeExists) {
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
                            System.out.println(
                                action.equals("1")
                                    ? "Check-in recorded."
                                    : "Check-out recorded.");
                        }
                        break;

                    case "3":
                        System.out.print("Employee ID: ");
                        String employeeId = scanner.nextLine().trim();

                        boolean found = employees.stream()
                            .anyMatch(e -> e.startsWith(employeeId + " -"));

                        if (!found) {
                            System.out.println("Employee not found.");
                            break;
                        }

                        System.out.print("Leave type: ");
                        String leaveType = scanner.nextLine().trim();
                        System.out.print("Start date (YYYY-MM-DD): ");
                        String start = scanner.nextLine().trim();
                        System.out.print("End date (YYYY-MM-DD): ");
                        String end = scanner.nextLine().trim();

                        LocalDate startDate = LocalDate.parse(start);
                        LocalDate endDate = LocalDate.parse(end);

                        if (endDate.isBefore(startDate)
                                || leaveType.isEmpty()) {
                            System.out.println("Invalid leave request.");
                            break;
                        }

                        leaveRequests.offer(employeeId + " | "
                            + leaveType + " | " + startDate + " to " + endDate);

                        System.out.println("Leave request added to queue.");
                        break;

                    case "4":
                        String request = leaveRequests.poll();
                        System.out.println(request == null
                            ? "No pending leave requests."
                            : "Processing leave request: " + request);
                        break;

                    case "0":
                        System.out.println("Exiting HorizonHR...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (RuntimeException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
    }
}
