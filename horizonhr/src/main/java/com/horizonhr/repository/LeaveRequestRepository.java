package com.horizonhr.repository;

import com.horizonhr.model.LeaveRequest;

public class LeaveRequestRepository
        extends InMemoryRepository<LeaveRequest, String> {

    public LeaveRequestRepository() {
        super(LeaveRequest::getRequestId);
    }
}