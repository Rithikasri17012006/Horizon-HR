package com.horizonhr.model;

import java.time.LocalDate;

public class Holiday {
    private String holidayId;
    private String holidayName;
    private LocalDate holidayDate;
    private String description;

    public Holiday(String holidayId, String holidayName, LocalDate holidayDate, String description) {
        this.holidayId = holidayId;
        this.holidayName = holidayName;
        this.holidayDate = holidayDate;
        this.description = description;
    }

    public String getHolidayId() {
        return holidayId;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public LocalDate getHolidayDate() {
        return holidayDate;
    }

    public String getDescription() {
        return description;
    }
}
