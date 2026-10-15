
package com.horizonhr.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {
    private String attendanceId;
    private String employeeId;
    private LocalDate date;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private String status;

    public Attendance(String attendanceId, String employeeId,
                      LocalDate date, LocalTime checkInTime,
                      LocalTime checkOutTime, String status) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.status = status;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public LocalTime getCheckOutTime() {
        return checkOutTime;
    }

    public String getStatus() {
        return status;
    }
}
