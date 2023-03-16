package com.example.kinozippy.controller;

import com.example.kinozippy.model.user.Customer;
import com.example.kinozippy.model.user.Employee;
import com.example.kinozippy.repository.CustomerRepository;
import com.example.kinozippy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // handles GET requests to /customers and returns a list of all customer entities in the repository.
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // handles POST requests to /customer and adds a new customer entity to the repository.
    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        return customerService.postCustomer(customer);
    }
    // handles GET requests to /customer/{id} and returns the customer entity with the specified ID.
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(null);
    }

    // handles GET requests to /customer/search and returns the customer entity with the specified
    @GetMapping("/customer/search")
    public Customer getCustomerByUsernameAndPassword(@RequestParam(value = "username") String username,
                                                     @RequestParam(value = "password") String password) {
        return customerRepository.findByUsernameAndPassword(username, password);
    }

    // handles PUT requests to /customer/{id} and updates the customer entity with the specified ID.
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") long customerId,
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
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElse(null);

        customerRepository.delete(customer);

        return ResponseEntity.ok().build();
    }
}
