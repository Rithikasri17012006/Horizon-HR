package com.horizonhr.model;

import java.time.LocalDate;
import com.horizonhr.exception.InvalidLeaveRequestException;

public class LeaveRequest {
    private final String requestId;
    private final String employeeId;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String leaveType;
    private String status;
    private final String reason;

    public LeaveRequest(String requestId, String employeeId,
                        LocalDate startDate, LocalDate endDate,
                        String leaveType, String status, String reason) {

        if (startDate == null || endDate == null
                || endDate.isBefore(startDate)) {
            throw new InvalidLeaveRequestException("Invalid leave dates");
        }

        if (employeeId == null || employeeId.isBlank()) {
            throw new InvalidLeaveRequestException("Employee ID is required");
        }

        this.requestId = requestId;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.status = status;
        this.reason = reason;
    }

    public String getRequestId() { return requestId; }
    public String getEmployeeId() { return employeeId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getLeaveType() { return leaveType; }
    public String getStatus() { return status; }
    public String getReason() { return reason; }

    public void setStatus(String status) {
        this.status = status;
    }
}
