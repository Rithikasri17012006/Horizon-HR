package com.horizonhr.config;

import com.horizonhr.data.CsvSeedDataLoader;
import com.horizonhr.repository.*;
import com.horizonhr.service.*;
import com.horizonhr.Stratergy.LeaveDayCalculator;
import com.horizonhr.Stratergy.WeekdayLeaveDayCalculator;

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
        return new WeekdayLeaveDayCalculator();
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