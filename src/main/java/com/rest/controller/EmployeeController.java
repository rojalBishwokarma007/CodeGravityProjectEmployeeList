package com.rest.controller;


import com.rest.error.UserAlreadyExistsException;
import com.rest.model.Employee;
import com.rest.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;


    
        @GetMapping("/employees")
        public ResponseEntity<List<Employee>> getAllEmployees() {
            return ResponseEntity.ok(employeeService.getAll());
        }

 @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        try {
            employeeService.createEmployee(employee);
            return new ResponseEntity<>("Employee created successfully.", HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value="id") Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));

    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
         
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }



    
}
