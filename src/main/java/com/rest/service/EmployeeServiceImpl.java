package com.rest.service;

import com.rest.error.UserAlreadyExistsException;
import com.rest.model.Employee;
import com.rest.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void createEmployee(Employee employee) {

        boolean exists = employeeRepository.existsByEmployeeId(employee.getEmployeeId());

        if (exists) {
            // If user exists, throw a custom exception to handle this specific error
            // scenario
            throw new UserAlreadyExistsException("User with Id " + employee.getEmployeeId() + " already exists.");
        }

        employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee e = employeeRepository.getById(employee.getId());
        e.setEmployeeId(employee.getEmployeeId());
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setDateofBirth(employee.getDateofBirth());
        e.setEmailId(employee.getEmailId());
        e.setlast4Ssn(employee.getLast4Ssn());
        employeeRepository.save(e);

    }
}
