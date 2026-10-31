package com.horizonhr.service;

import com.horizonhr.model.Attendance;
import com.horizonhr.model.Employee;
import com.horizonhr.repository.AttendanceRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AttendanceReportService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceReportService(
            AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getTeamAttendance(
            String managerId,
            List<Employee> employees) {

        if (managerId == null || managerId.isBlank()) {
            throw new IllegalArgumentException("Manager ID is required");
        }

        if (employees == null) {
            throw new IllegalArgumentException("Employee list cannot be null");
        }

        Set<String> teamEmployeeIds = employees.stream()
                .filter(employee ->
                        managerId.equals(employee.getReportingManager()))
                .map(Employee::getEmployeeId)
                .collect(Collectors.toSet());

        return attendanceRepository.findAll().stream()
                .filter(attendance ->
                        teamEmployeeIds.contains(attendance.getEmployeeId()))
                .collect(Collectors.toList());
    }
}