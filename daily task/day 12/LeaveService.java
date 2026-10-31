package com.horizonhr.service;

import com.horizonhr.model.Employee;
import com.horizonhr.model.LeaveRequest;
import com.horizonhr.repository.EmployeeRepository;
import com.horizonhr.repository.LeaveRequestRepository;
import com.horizonhr.Stratergy.LeaveDayCalculator;

import java.util.List;

public class LeaveService {

    private final EmployeeRepository employeeRepository;
    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveDayCalculator leaveDayCalculator;

    public LeaveService(EmployeeRepository employeeRepository,
                        LeaveRequestRepository leaveRequestRepository,
                        LeaveDayCalculator leaveDayCalculator) {
        this.employeeRepository = employeeRepository;
        this.leaveRequestRepository = leaveRequestRepository;
        this.leaveDayCalculator = leaveDayCalculator;
    }

    public LeaveRequest applyForLeave(LeaveRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Leave request cannot be null");
        }

        Employee employee = employeeRepository
                .findById(request.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Employee not found: " + request.getEmployeeId()));

        if (leaveRequestRepository.existsById(request.getRequestId())) {
            throw new IllegalArgumentException("Duplicate leave request ID");
        }

        leaveDayCalculator.calculateDays(
                request.getStartDate(), request.getEndDate());

        return leaveRequestRepository.save(request);
    }

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public long calculateLeaveDays(LeaveRequest request) {
        return leaveDayCalculator.calculateDays(
                request.getStartDate(), request.getEndDate());
    }
}