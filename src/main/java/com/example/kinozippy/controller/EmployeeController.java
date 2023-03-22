package com.example.kinozippy.controller;

import com.example.kinozippy.model.enums.Role;
import com.example.kinozippy.model.user.Employee;
import com.example.kinozippy.repository.EmployeeRepository;
import com.example.kinozippy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;

    // handles GET requests to /employees and returns a list of all Employee entities in the repository.
    @GetMapping("/employee/roles")
    public List<Role> getRoles() {
        return Role.getAllRoles();
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // handles POST requests to /employee and adds a new Employee entity to the repository.
    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
        return employeeService.postEmployee(employee);
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

