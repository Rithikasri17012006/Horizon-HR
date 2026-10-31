package com.horizonhr.controller;

import com.horizonhr.model.Holiday;
import com.horizonhr.service.HolidayService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/holidays")
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    public record HolidayRequest(
            String holidayId,
            String holidayName,
            LocalDate holidayDate,
            String description) {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Holiday addHoliday(@RequestBody HolidayRequest request) {
        return holidayService.addHoliday(new Holiday(
                request.holidayId(),
                request.holidayName(),
                request.holidayDate(),
                request.description()
        ));
    }

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidayService.getAllHolidays();
    }

    @GetMapping("/{id}")
    public Holiday getHoliday(@PathVariable String id) {
        return holidayService.getHolidayById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Holiday not found"));
    }

    @DeleteMapping("/{id}")
    public boolean deleteHoliday(@PathVariable String id) {
        return holidayService.deleteHoliday(id);
    }
}