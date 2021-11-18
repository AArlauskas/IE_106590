package com.lab3.employeerestlab.controllers;

import com.lab3.employeerestlab.models.Employee;
import com.lab3.employeerestlab.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id)
    {
        var employee = employeeRepository.findById(id);
        if(employee.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee.get());
    }

    @GetMapping(params = {"email"})
    public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam(value = "email", required = true)String email)
    {
        var employee = employeeRepository.findEmployeeByEmailAddress(email);
        if(employee == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping()
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee)
    {
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id,
                                                   @Valid @RequestBody Employee employee)
    {
        var result = employeeRepository.findById(id);
        if(result.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        var dbEmployee = result.get();

        dbEmployee.setFirstName(employee.getFirstName());
        dbEmployee.setLastName(employee.getLastName());
        dbEmployee.setEmailAddress(employee.getEmailAddress());

        final Employee updatedEmployee = employeeRepository.save(dbEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
