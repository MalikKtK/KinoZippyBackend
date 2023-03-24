package com.example.kinozippy.config;

import com.example.kinozippy.model.*;
import com.example.kinozippy.model.enums.*;
import com.example.kinozippy.model.user.*;
import com.example.kinozippy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {
    // ### run tests ###
    private final boolean runTests = false;
    // ### repositories ###
    private final TheaterRepository theaterRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final MovieRepository movieRepository;
    private final ShowTimeRepository showTimeRepository;
    private final TicketRepository ticketRepository;
    private final ShopRepository shopRepository;

    @Autowired
    public InitData(TheaterRepository theaterRepository,
                    EmployeeRepository employeeRepository,
                    CustomerRepository customerRepository,
                    MovieRepository movieRepository,
                    ShowTimeRepository showTimeRepository,
                    TicketRepository ticketRepository,
                    ShopRepository shopRepository) {
        this.theaterRepository = theaterRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
        this.showTimeRepository = showTimeRepository;
        this.shopRepository = shopRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (!runTests) return;

        theater();
        employee();
        customer();
        movie();
        showTime();
        tickets();
        shop();
    }

    public void theater() {
        theaterRepository.save(new Theater(1, "small theater", 20, 12, null));
        theaterRepository.save(new Theater(2, "big theater", 25, 16, null));
    }

    public void employee() {
        employeeRepository.save(new Employee(1, "manager", "123", Role.MANAGER));
        employeeRepository.save(new Employee(2, "operator", "123", Role.OPERATOR));
        employeeRepository.save(new Employee(3, "shop", "123", Role.SHOP_ASSISTANT));
        employeeRepository.save(new Employee(4, "ticket", "123", Role.TICKET_INSPECTOR));
    }

    public void customer() {
        customerRepository.save(new Customer(5, "malik", "123"));
        customerRepository.save(new Customer(6, "mark", "123"));
        customerRepository.save(new Customer(7, "ebus", "123"));
        customerRepository.save(new Customer(7, "daniel", "123"));
    }

    public void movie() {
        movieRepository.save(new Movie(1, "peter the can man", AgeLimit.ADULTS_ONLY, Category.ACTION, 120, null, 1));
        movieRepository.save(new Movie(2, "the big movie", AgeLimit.PARENTAL_GUIDANCE_SUGGESTED, Category.COMEDY, 110, null, 5));
        movieRepository.save(new Movie(3, "the boring movie", AgeLimit.RESTRICTED, Category.DRAMA, 130, null, 6));
    }

    public void showTime() {
        showTimeRepository.save(new ShowTime(1, 100, theaterRepository.getReferenceById(1L), movieRepository.getReferenceById(1L), LocalDateTime.now(), LocalDateTime.now().plusHours(2)));
        showTimeRepository.save(new ShowTime(2, 110, theaterRepository.getReferenceById(1L), movieRepository.getReferenceById(1L), LocalDateTime.now(), LocalDateTime.now().plusHours(2)));
        showTimeRepository.save(new ShowTime(3, 120, theaterRepository.getReferenceById(2L), movieRepository.getReferenceById(2L), LocalDateTime.now(), LocalDateTime.now().plusHours(2)));
        showTimeRepository.save(new ShowTime(4, 130, theaterRepository.getReferenceById(2L), movieRepository.getReferenceById(2L), LocalDateTime.now(), LocalDateTime.now().plusHours(2)));
    }

    public void tickets() {
        ticketRepository.save(new Ticket(1, showTimeRepository.getReferenceById(1L), customerRepository.getReferenceById(1L), 1, 1, 120, false, false));
        ticketRepository.save(new Ticket(2, showTimeRepository.getReferenceById(1L), customerRepository.getReferenceById(1L), 2, 1, 120, true, true));
        ticketRepository.save(new Ticket(3, showTimeRepository.getReferenceById(1L), customerRepository.getReferenceById(1L), 3, 1, 120, false, false));
    }

    private void shop() {
        shopRepository.save(new Shop(1L, "Popcorn Small", 25, 30));
        shopRepository.save(new Shop(2L, "Popcorn Medium", 25, 30));
        shopRepository.save(new Shop(3L, "Popcorn Huge", 25, 30));
        shopRepository.save(new Shop(4L, "chocolate", 25, 30));
        shopRepository.save(new Shop(5L, "Cola Small", 25, 30));
        shopRepository.save(new Shop(6L, "Cola Medium", 25, 30));
        shopRepository.save(new Shop(7L, "Cola Large", 25, 30));
                // Long id, String name, int price, int quantity
    }

}
