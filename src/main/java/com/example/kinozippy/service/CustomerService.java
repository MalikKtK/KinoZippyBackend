package com.example.kinozippy.service;

import com.example.kinozippy.model.user.Customer;
import com.example.kinozippy.model.user.Employee;
import com.example.kinozippy.model.user.User;
import com.example.kinozippy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public ResponseEntity<Customer> postCustomer(Customer customer) {
        if (doesCustomerExist(customer)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Customer postedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(postedCustomer, HttpStatus.OK);
    }
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public ResponseEntity<Customer> putCustomer(Customer customer) {
        if (doesCustomerExist(customer)) {
            Customer updatedCustomer = customerRepository.save(customer);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Customer> deleteEmployee(long customerID) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerID);
        if (doesCustomerExist(customerID)) {
            Customer deletedEmployee = optionalCustomer.get();
            customerRepository.deleteById(customerID);
            return new ResponseEntity<>(deletedEmployee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public User savedCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    private boolean doesCustomerExist(Customer customer) {
        Long customerID = customer.getId();
        return doesCustomerExist(customerID);
    }
    private boolean doesCustomerExist(Long id) {
        boolean isIdSet = id != null;
        return isIdSet && customerRepository.existsById(id);
    }

}

