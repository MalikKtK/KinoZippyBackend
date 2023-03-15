package com.example.kinozippy.controller;

import com.example.kinozippy.model.user.Employee;
import com.example.kinozippy.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // handles GET requests to /employees and returns a list of all Employee entities in the repository.
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // handles POST requests to /employee and adds a new Employee entity to the repository.
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // handles GET requests to /employee/{id} and returns the Employee entity with the specified ID.
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(null);
    }

    // todo maybe make password hidden
    // handles GET requests to /employee/search and returns the Employee entity with the specified
    @GetMapping("/employee/search")
    public Employee getEmployeeByUsernameAndPassword(@RequestParam(value = "username") String username,
                                                     @RequestParam(value = "password") String password) {
        return employeeRepository.findByUsernameAndPassword(username, password);
    }

    // handles PUT requests to /employee/{id} and updates the Employee entity with the specified ID.
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") long employeeId,
                                   @RequestBody Employee employeeDetails) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElse(null);

        employee.setUsername(employeeDetails.getUsername());
        employee.setPassword(employeeDetails.getPassword());
        employee.setRole(employeeDetails.getRole());

        Employee updatedemployee = employeeRepository.save(employee);
        return updatedemployee;
    }

    // handles DELETE requests to /employee/{id} and deletes the Employee entity with the specified ID.
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElse(null);

        employeeRepository.delete(employee);

        return ResponseEntity.ok().build();
    }
}

