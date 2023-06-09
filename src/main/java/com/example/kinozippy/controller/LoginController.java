package com.example.kinozippy.controller;

import com.example.kinozippy.model.user.Customer;
import com.example.kinozippy.model.user.Employee;
import com.example.kinozippy.service.CustomerService;
import com.example.kinozippy.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(value = "*")
public class LoginController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;

    @GetMapping("/login")
    public String login() {
        return "login"; // returns the login page HTML template
    }


    @PostMapping("/customerLogin")
    public ResponseEntity<Customer> customerLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Customer customer = customerService.login(username, password);
        if (customer != null) {
            session.setAttribute("customer", customer);
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/employeeLogin")
    public ResponseEntity<Employee> employeeLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Employee employee = employeeService.login(username, password);
        if (employee != null) {
            session.setAttribute("employee", employee);
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.badRequest().build();
    }

}
