package com.horizonhr.service;

import com.horizonhr.model.Attendance;
import com.horizonhr.model.Employee;
import com.horizonhr.repository.AttendanceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceReportServiceTest {

    private AttendanceReportService reportService;
    private AttendanceRepository attendanceRepository;
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        attendanceRepository = new AttendanceRepository();
        reportService = new AttendanceReportService(attendanceRepository);

        employees = List.of(
                new Employee("E001", "Arun", "arun@example.com",
                        "Engineering", "M001", "EMPLOYEE"),
                new Employee("E002", "Priya", "priya@example.com",
                        "Engineering", "M001", "EMPLOYEE"),
                new Employee("E003", "Kavin", "kavin@example.com",
                        "Finance", "M002", "EMPLOYEE")
        );

        attendanceRepository.save(new Attendance(
                "A001", "E001", LocalDate.of(2026, 10, 31),
                LocalTime.of(9, 0), LocalTime.of(17, 0), "PRESENT"
        ));

        attendanceRepository.save(new Attendance(
                "A002", "E002", LocalDate.of(2026, 10, 31),
                LocalTime.of(9, 15), LocalTime.of(17, 10), "PRESENT"
        ));

        attendanceRepository.save(new Attendance(
                "A003", "E003", LocalDate.of(2026, 10, 31),
                LocalTime.of(9, 5), LocalTime.of(17, 5), "PRESENT"
        ));
    }

    @Test
    void shouldReturnOnlyManagersTeamAttendance() {
        List<Attendance> result =
                reportService.getTeamAttendance("M001", employees);

        assertEquals(2, result.size());

        assertTrue(result.stream()
                .allMatch(a -> a.getEmployeeId().equals("E001")
                        || a.getEmployeeId().equals("E002")));
    }

    @Test
    void shouldReturnEmptyListWhenManagerHasNoTeam() {
        List<Attendance> result =
                reportService.getTeamAttendance("M999", employees);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldRejectBlankManagerId() {
        assertThrows(IllegalArgumentException.class,
                () -> reportService.getTeamAttendance(" ", employees));
    }
}