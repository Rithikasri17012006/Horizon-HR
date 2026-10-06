package com.horizonhr.data;

public final class SampleData {

    private SampleData() {
        // Prevent object creation
    }

    // Employee sample data
    public static final String[] EMPLOYEE_IDS = {
            "EMP001",
            "EMP002",
            "EMP003"
    };

    public static final String[] EMPLOYEE_NAMES = {
            "Ananya",
            "Rahul",
            "Priya"
    };

    // Department sample data
    public static final String[] DEPARTMENTS = {
            "Engineering",
            "Human Resources",
            "Finance"
    };

    // One-week attendance sample data
    public static final String[] WEEK_DAYS = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
    };

    public static final String[] ATTENDANCE_STATUS = {
            "PRESENT",
            "PRESENT",
            "PRESENT",
            "LEAVE",
            "PRESENT",
            "WEEKEND",
            "WEEKEND"
    };
}