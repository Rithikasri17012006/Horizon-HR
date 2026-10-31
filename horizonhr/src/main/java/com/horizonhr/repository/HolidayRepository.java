package com.horizonhr.repository;

import com.horizonhr.model.Holiday;

public class HolidayRepository
        extends InMemoryRepository<Holiday, String> {

    public HolidayRepository() {
        super(Holiday::getHolidayId);
    }
}
