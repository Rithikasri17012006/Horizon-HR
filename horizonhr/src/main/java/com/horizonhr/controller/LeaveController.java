package com.horizonhr.controller;

import com.horizonhr.model.LeaveRequest;
import com.horizonhr.service.LeaveService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/leaves")
public class LeaveController {

    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    public record LeaveApplication(
            String employeeId,
            LocalDate startDate,
            LocalDate endDate,
            String leaveType,
            String reason) {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LeaveRequest applyForLeave(
            @RequestBody LeaveApplication application) {

        LeaveRequest request = new LeaveRequest(
                UUID.randomUUID().toString(),
                application.employeeId(),
                application.startDate(),
                application.endDate(),
                application.leaveType(),
                "PENDING",
                application.reason()
        );

        return leaveService.applyForLeave(request);
    }

    @GetMapping
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveService.getAllLeaveRequests();
    }
}