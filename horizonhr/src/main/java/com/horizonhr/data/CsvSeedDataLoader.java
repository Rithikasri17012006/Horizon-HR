
package com.horizonhr.data;

import com.horizonhr.model.Employee;
import com.horizonhr.repository.EmployeeRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CsvSeedDataLoader {

    public static void loadEmployees(EmployeeRepository repository) {
        InputStream input = CsvSeedDataLoader.class
                .getResourceAsStream("/data/employees.csv");

        if (input == null) {
            throw new IllegalStateException(
                    "employees.csv not found in resources/data");
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8))) {

            String line;
            boolean header = true;

            while ((line = reader.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }

                if (line.isBlank()) {
                    continue;
                }

                String[] fields = line.split(",", -1);

                if (fields.length != 6) {
                    throw new IllegalArgumentException(
                            "Expected 6 columns in employee CSV: " + line);
                }

                Employee employee = new Employee(
                        fields[0].trim(),
                        fields[1].trim(),
                        fields[2].trim(),
                        fields[3].trim(),
                        fields[4].trim(),
                        fields[5].trim()
                );

                repository.save(employee);
            }
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not load employee seed data", exception);
        }
    }
}

