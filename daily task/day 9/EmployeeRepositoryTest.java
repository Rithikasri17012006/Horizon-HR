
package com.horizonhr.repository;

import com.horizonhr.data.CsvSeedDataLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    @Test
    void shouldLoadEmployeesFromCsv() {
        EmployeeRepository repository = new EmployeeRepository();

        CsvSeedDataLoader.loadEmployees(repository);

        assertEquals(4, repository.findAll().size());
        assertTrue(repository.existsById("E001"));
        assertEquals(
                "Arun",
                repository.findById("E001").orElseThrow().getName()
        );
    }
}
