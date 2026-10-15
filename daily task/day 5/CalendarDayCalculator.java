
package com.horizonhr.strategy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalendarDayCalculator implements LeaveDayCalculator {
    @Override
    public long calculateDays(LocalDate startDate, LocalDate endDate) {
        validateDates(startDate, endDate);
        return ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    private void validateDates(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null || endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Invalid leave dates");
        }
    }
}
