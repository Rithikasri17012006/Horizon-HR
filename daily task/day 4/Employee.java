
package com.horizonhr.model;

public class Employee {
    private String employeeId;
    private String name;
    private String email;
    private String department;
    private String reportingManager;
    private String role;

    public Employee(String employeeId, String name, String email,
                    String department, String reportingManager, String role) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.reportingManager = reportingManager;
        this.role = role;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getReportingManager() {
        return reportingManager;
    }

    public String getRole() {
        return role;
    }
}
