package com.example.kinozippy.controller;

import com.example.kinozippy.model.user.Employee;
import com.example.kinozippy.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // handles GET requests to /employees and returns a list of all Employee entities in the repository.
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // handles POST requests to /employees and adds a new Employee entity to the repository.
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // handles GET requests to /employees/{id} and returns the Employee entity with the specified ID.
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") int employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(null);
    }

    // handles GET requests to /employees/search and returns the Employee entity with the specified
    @GetMapping("/employee/search")
    public Employee getEmployeeByUsernameAndPassword(@RequestParam(value = "username") String username,
                                                     @RequestParam(value = "password") String password) {
        return employeeRepository.findByUsernameAndPassword(username, password);
    }

    // handles PUT requests to /employees/{id} and updates the Employee entity with the specified ID.
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") int employeeId,
                                   @RequestBody Employee employeeDetails) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElse(null);

        employee.setUsername(employeeDetails.getUsername());
        employee.setPassword(employeeDetails.getPassword());
        employee.setRole(employeeDetails.getRole());

        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    // handles DELETE requests to /employees/{id} and deletes the Employee entity with the specified ID.
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") int employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElse(null);

        employeeRepository.delete(employee);

        return ResponseEntity.ok().build();
    }
}

