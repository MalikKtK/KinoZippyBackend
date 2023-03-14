package com.example.kinozippy.controller;

import com.example.kinozippy.model.user.Customer;
import com.example.kinozippy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // handles GET requests to /customers and returns a list of all customer entities in the repository.
    @GetMapping("/customers")
    public List<Customer> getAllcustomers() {
        return customerRepository.findAll();
    }

    // handles POST requests to /customer and adds a new customer entity to the repository.
    @PostMapping("/customer")
    public Customer addcustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // handles GET requests to /customer/{id} and returns the customer entity with the specified ID.
    @GetMapping("/customer/{id}")
    public Customer getcustomerById(@PathVariable(value = "id") long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(null);
    }

//    // handles GET requests to /customer/search and returns the customer entity with the specified
//    @GetMapping("/customer/search")
//    public Customer getcustomerByUsernameAndPassword(@RequestParam(value = "username") String username,
//                                                     @RequestParam(value = "password") String password) {
//        return customerRepository.findByUsernameAndPassword(username, password);
//    }

    // handles PUT requests to /customer/{id} and updates the customer entity with the specified ID.
    @PutMapping("/customer/{id}")
    public Customer updatecustomer(@PathVariable(value = "id") long customerId,
                                   @RequestBody Customer customerDetails) {

        Customer customer = customerRepository.findById(customerId)
                .orElse(null);

        customer.setUsername(customerDetails.getUsername());
        customer.setPassword(customerDetails.getPassword());

        Customer updatedcustomer = customerRepository.save(customer);
        return updatedcustomer;
    }

    // handles DELETE requests to /customer/{id} and deletes the customer entity with the specified ID.
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deletecustomer(@PathVariable(value = "id") long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElse(null);

        customerRepository.delete(customer);

        return ResponseEntity.ok().build();
    }
}
