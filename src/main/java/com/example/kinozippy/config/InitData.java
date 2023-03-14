package com.example.kinozippy.config;

import com.example.kinozippy.model.Theater;
import com.example.kinozippy.model.enums.Role;
import com.example.kinozippy.model.user.Customer;
import com.example.kinozippy.model.user.Employee;
import com.example.kinozippy.repository.CustomerRepository;
import com.example.kinozippy.repository.EmployeeRepository;
import com.example.kinozippy.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final boolean runTests = true;

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!runTests) return;

        theater();
        employee();
        customer();
    }

    public void theater() {
        theaterRepository.save(new Theater(1, "small theater", 20, 12));
        theaterRepository.save(new Theater(2, "big theater", 25, 16));
    }

    public void employee() {
        employeeRepository.save(new Employee(1, "manager", "123", Role.MANAGER));
        employeeRepository.save(new Employee(2, "operator", "123", Role.OPERATOR));
        employeeRepository.save(new Employee(3, "shop", "123", Role.SHOP_ASSISTANT));
        employeeRepository.save(new Employee(4, "ticket", "123", Role.TICKET_INSPECTOR));
    }

    public void customer() {
        customerRepository.save(new Customer(1, "c1", "123"));
        customerRepository.save(new Customer(2, "c2", "123"));
        customerRepository.save(new Customer(3, "c3", "123"));
    }

}
