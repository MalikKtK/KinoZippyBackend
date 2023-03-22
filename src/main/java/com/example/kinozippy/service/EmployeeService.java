package com.example.kinozippy.service;

import com.example.kinozippy.model.user.Employee;
import com.example.kinozippy.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee login(String username, String password) {
        Employee employee = employeeRepository.findByUsernameAndPassword(username, password);
        if (employee == null) {
            throw new RuntimeException("Invalid username or password");
        }
        return employee;
    }

    public ResponseEntity<Employee> postEmployee(Employee employee) {
        if (doesEmployeeExists(employee)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Employee postedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(postedEmployee, HttpStatus.OK);
    }
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    public ResponseEntity<Employee> putEmployee(Employee employee) {
        if (doesEmployeeExists(employee)) {
            Employee updatedEmployee = employeeRepository.save(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Employee> deleteEmployee(long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (doesEmployeeExists(employeeId)) {
            Employee deletedEmployee = optionalEmployee.get();
            employeeRepository.deleteById(employeeId);
            return new ResponseEntity<>(deletedEmployee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public Employee savedEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    private boolean doesEmployeeExists(Employee employee) {
        Long employeeID = employee.getId();
        return doesEmployeeExists(employeeID);
    }
    private boolean doesEmployeeExists(Long id) {
        boolean isIdSet = id != null;
        return isIdSet && employeeRepository.existsById(id);
    }

}
