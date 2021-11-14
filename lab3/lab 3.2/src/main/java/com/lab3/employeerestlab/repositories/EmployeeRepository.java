package com.lab3.employeerestlab.repositories;

import com.lab3.employeerestlab.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByEmailAddress(String emailAdress);
}
