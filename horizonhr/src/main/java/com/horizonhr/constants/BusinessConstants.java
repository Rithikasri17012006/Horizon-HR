package com.horizonhr.constants;

public final class BusinessConstants {

    private BusinessConstants() {
        // Prevent object creation
    }

    // Attendance rules
    public static final int MAX_CHECK_INS_PER_DAY = 1;
    public static final int MAX_CHECK_OUTS_PER_DAY = 1;

    // Leave rules
    public static final int DEFAULT_ANNUAL_LEAVE_QUOTA = 20;
    public static final int MAX_CARRY_FORWARD_DAYS = 5;

    // Working days
    public static final int WORKING_DAYS_PER_WEEK = 5;

    // Approval rules
    public static final int DEFAULT_APPROVAL_LEVELS = 2;
}