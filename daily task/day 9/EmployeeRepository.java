
package com.horizonhr.repository;

import com.horizonhr.model.Employee;

public class EmployeeRepository
        extends InMemoryRepository<Employee, String> {

    public EmployeeRepository() {
        super(Employee::getEmployeeId);
    }
}
