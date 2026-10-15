package com.horizonhr;

import java.util.Scanner;

public class ConsoleMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n===== HorizonHR =====");
                System.out.println("1. Employee & Department Management");
                System.out.println("2. Check In / Check Out");
                System.out.println("3. Apply for Leave");
                System.out.println("4. Validate Leave Request");
                System.out.println("5. Approve / Reject Leave");
                System.out.println("6. Manage Leave Balance");
                System.out.println("7. Manage Holidays & Leave Policies");
                System.out.println("8. View Team Attendance Report");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                if (!scanner.hasNextInt()) {
                    String invalidInput = scanner.next();
                    System.out.println("Invalid input: '" + invalidInput
                            + "'. Please enter a number.");
                    continue;
                }

                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Exiting HorizonHR...");
                    break;
                }

                if (choice >= 1 && choice <= 8) {
                    System.out.println("Selected option: " + choice);
                } else {
                    System.out.println(
                            "Invalid option. Please enter a number from 0 to 8.");
                }

            } catch (RuntimeException exception) {
                System.out.println("Error: " + exception.getMessage());
                System.out.println("Returning to the main menu...");
            }
        }

        scanner.close();
    }
}
