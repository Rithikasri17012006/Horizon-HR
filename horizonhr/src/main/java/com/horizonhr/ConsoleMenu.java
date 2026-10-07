package com.horizonhr;

import java.util.Scanner;

public class ConsoleMenu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
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

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting HorizonHR...");
                break;
            }

            if (choice >= 1 && choice <= 8) {
                System.out.println("Selected option: " + choice);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}