package com.horizonhr.config;

import com.horizonhr.data.CsvSeedDataLoader;
import com.horizonhr.repository.*;
import com.horizonhr.service.*;
import com.horizonhr.Stratergy.LeaveDayCalculator;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public EmployeeRepository employeeRepository() {
        EmployeeRepository repository = new EmployeeRepository();
        CsvSeedDataLoader.loadEmployees(repository);
        return repository;
    }

    @Bean
    public AttendanceRepository attendanceRepository() {
        return new AttendanceRepository();
    }

    @Bean
    public HolidayRepository holidayRepository() {
        return new HolidayRepository();
    }

    @Bean
    public LeaveRequestRepository leaveRequestRepository() {
        return new LeaveRequestRepository();
    }

    @Bean
public LeaveDayCalculator leaveDayCalculator() {
    return (startDate, endDate) -> {
        if (startDate == null || endDate == null || endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Invalid leave dates");
        }

        long days = 0;
        for (var date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (date.getDayOfWeek().getValue() < 6) {
                days++;
            }
        }
        return days;
    };
}

    @Bean
    public HolidayService holidayService(
            HolidayRepository repository) {
        return new HolidayService(repository);
    }

    @Bean
    public AttendanceReportService attendanceReportService(
            AttendanceRepository repository) {
        return new AttendanceReportService(repository);
    }

    @Bean
    public LeaveService leaveService(
            EmployeeRepository employees,
            LeaveRequestRepository requests,
            LeaveDayCalculator calculator) {
        return new LeaveService(employees, requests, calculator);
    }
}