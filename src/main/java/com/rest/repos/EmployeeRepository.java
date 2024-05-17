package com.rest.repos;

import com.rest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    boolean existsByEmployeeId(Long employeeId);




    
}
