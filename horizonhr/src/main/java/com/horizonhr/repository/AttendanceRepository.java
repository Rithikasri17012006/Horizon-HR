package com.horizonhr.repository;

import com.horizonhr.model.Attendance;

public class AttendanceRepository
        extends InMemoryRepository<Attendance, String> {

    public AttendanceRepository() {
        super(Attendance::getAttendanceId);
    }
}