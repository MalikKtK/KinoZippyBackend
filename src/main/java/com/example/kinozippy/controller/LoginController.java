package com.example.kinozippy.controller;

import com.example.kinozippy.model.user.Employee;
import com.example.kinozippy.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/login")
    public String login() {
        return "login"; // returns the login page HTML template
    }

    @PostMapping("/login")
    public String loginEmployee(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Employee employee = employeeService.login(username, password);
        session.setAttribute("employee", employee);
        switch (employee.getRole()) {
            case MANAGER:
                return "redirect:http://localhost:63342/KinoZippyFrontend/html/manager.html";
            case SHOP_ASSISTANT:
                return "redirect:http://localhost:63342/KinoZippyFrontend/html/shopManager.html";
            case TICKET_INSPECTOR:
                return "redirect:http://localhost:63342/KinoZippyFrontend/html/ticket.html";
            case OPERATOR:
                return "redirect:http://localhost:63342/KinoZippyFrontend/html/operator.html";
            default:
                throw new RuntimeException("Invalid role");
        }
    }
}
