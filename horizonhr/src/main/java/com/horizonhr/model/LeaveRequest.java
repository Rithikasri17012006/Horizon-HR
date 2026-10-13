
package com.horizonhr.model;

import java.time.LocalDate;

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
