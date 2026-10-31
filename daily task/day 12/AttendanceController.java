package com.horizonhr.controller;

import com.horizonhr.model.Attendance;
import com.horizonhr.model.Employee;
import com.horizonhr.repository.AttendanceRepository;
import com.horizonhr.repository.EmployeeRepository;
import com.horizonhr.service.AttendanceReportService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;
    private final AttendanceReportService reportService;

    public AttendanceController(
            AttendanceRepository attendanceRepository,
            EmployeeRepository employeeRepository,
            AttendanceReportService reportService) {
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
        this.reportService = reportService;
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @GetMapping("/team/{managerId}")
    public List<Attendance> getTeamAttendance(
            @PathVariable String managerId) {
        List<Employee> employees = employeeRepository.findAll();
        return reportService.getTeamAttendance(managerId, employees);
    }
}