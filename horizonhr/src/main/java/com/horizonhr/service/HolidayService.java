package com.horizonhr.service;

import com.horizonhr.model.Holiday;
import com.horizonhr.repository.HolidayRepository;

import java.util.List;
import java.util.Optional;

public class HolidayService {

    private final HolidayRepository holidayRepository;

    public HolidayService(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    public Holiday addHoliday(Holiday holiday) {
        if (holiday == null) {
            throw new IllegalArgumentException("Holiday cannot be null");
        }

        if (holidayRepository.existsById(holiday.getHolidayId())) {
            throw new IllegalArgumentException("Holiday ID already exists");
        }

        return holidayRepository.save(holiday);
    }

    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public Optional<Holiday> getHolidayById(String holidayId) {
        return holidayRepository.findById(holidayId);
    }

    public Holiday updateHoliday(String holidayId, Holiday updatedHoliday) {
        if (!holidayRepository.existsById(holidayId)) {
            throw new IllegalArgumentException("Holiday not found");
        }

        if (updatedHoliday == null) {
            throw new IllegalArgumentException("Updated holiday cannot be null");
        }

        if (!holidayId.equals(updatedHoliday.getHolidayId())) {
            throw new IllegalArgumentException("Holiday ID cannot be changed");
        }

        return holidayRepository.save(updatedHoliday);
    }

    public boolean deleteHoliday(String holidayId) {
        return holidayRepository.deleteById(holidayId);
    }
}