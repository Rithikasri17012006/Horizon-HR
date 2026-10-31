
package com.horizonhr.Stratergy;

import java.time.LocalDate;

public interface LeaveDayCalculator {
    long calculateDays(LocalDate startDate, LocalDate endDate);
}

