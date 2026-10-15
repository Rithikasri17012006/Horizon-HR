package com.horizonhr.model;

import java.time.LocalDate;
import com.horizonhr.data.SampleData;
import com.horizonhr.exception.InvalidLeaveRequestException;
import com.horizonhr.exception.EmployeeNotFoundException;
public class LeaveRequest {
    private String requestId;
    private String employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveType;
    private String status;
    private String reason;

    public LeaveRequest(String requestId, String employeeId,
                        LocalDate startDate, LocalDate endDate,
                        String leaveType, String status, String reason) {
        if (startDate == null || endDate == null
                || endDate.isBefore(startDate)) {
            throw new InvalidLeaveRequestException(
                "Leave start date cannot be after end date, and dates cannot be null."
            );
        }
        boolean employeeExists = false;

if (employeeId != null) {
    for (String id : SampleData.EMPLOYEE_IDS) {
        if (id.equals(employeeId)) {
            employeeExists = true;
            break;
        }
    }
}

if (!employeeExists) {
    throw new EmployeeNotFoundException(
        "Employee not found: " + employeeId
    );
}
        this.requestId = requestId;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.status = status;
        this.reason = reason;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }
}
