package com.horizonhr.service;

import com.horizonhr.model.Holiday;
import com.horizonhr.repository.HolidayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HolidayServiceTest {

    private HolidayService holidayService;

    @BeforeEach
    void setUp() {
        HolidayRepository repository = new HolidayRepository();
        holidayService = new HolidayService(repository);
    }

    @Test
    void shouldAddAndRetrieveHoliday() {
        Holiday holiday = new Holiday(
                "H001", "Pongal",
                LocalDate.of(2027, 1, 14), "Festival holiday"
        );

        holidayService.addHoliday(holiday);

        assertEquals(1, holidayService.getAllHolidays().size());
        assertEquals("Pongal",
                holidayService.getHolidayById("H001").orElseThrow().getHolidayName());
    }

    @Test
    void shouldRejectDuplicateHolidayId() {
        Holiday holiday = new Holiday(
                "H001", "Pongal",
                LocalDate.of(2027, 1, 14), "Festival holiday"
        );

        holidayService.addHoliday(holiday);

        assertThrows(IllegalArgumentException.class,
                () -> holidayService.addHoliday(holiday));
    }

    @Test
    void shouldUpdateHoliday() {
        Holiday original = new Holiday(
                "H001", "Pongal",
                LocalDate.of(2027, 1, 14), "Festival holiday"
        );

        holidayService.addHoliday(original);

        Holiday updated = new Holiday(
                "H001", "Pongal Festival",
                LocalDate.of(2027, 1, 15), "Updated date"
        );

        holidayService.updateHoliday("H001", updated);

        assertEquals("Pongal Festival",
                holidayService.getHolidayById("H001").orElseThrow().getHolidayName());
    }

    @Test
    void shouldDeleteHoliday() {
        Holiday holiday = new Holiday(
                "H001", "Pongal",
                LocalDate.of(2027, 1, 14), "Festival holiday"
        );

        holidayService.addHoliday(holiday);

        assertTrue(holidayService.deleteHoliday("H001"));
        assertFalse(holidayService.getHolidayById("H001").isPresent());
    }
}