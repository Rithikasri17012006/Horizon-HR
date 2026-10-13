
package com.horizonhr.strategy;

import java.time.LocalDate;

public interface LeaveDayCalculator {
    long calculateDays(LocalDate startDate, LocalDate endDate);
}

