package com.rest.service;

import com.rest.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public void createEmployee(Employee employee);
    public List<Employee> getAll();
    public Optional<Employee> getEmployee(Long id);
    public void deleteEmployee(Long id);
    public void updateEmployee(Employee employee);
}
