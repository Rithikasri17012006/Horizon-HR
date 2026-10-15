
package com.horizonhr.strategy;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayLeaveDayCalculator implements LeaveDayCalculator {
    @Override
    public long calculateDays(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null || endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Invalid leave dates");
        }

        long days = 0;

        for (LocalDate date = startDate; !date.isAfter(endDate);
             date = date.plusDays(1)) {
            DayOfWeek day = date.getDayOfWeek();

            if (day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY) {
                days++;
            }
        }

        return days;
    }
}
