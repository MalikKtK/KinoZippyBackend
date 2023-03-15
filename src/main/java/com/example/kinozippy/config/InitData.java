package com.example.kinozippy.config;

import com.example.kinozippy.model.*;
import com.example.kinozippy.model.enums.*;
import com.example.kinozippy.model.user.*;
import com.example.kinozippy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
public class InitData implements CommandLineRunner {
    // ### run tests ###
    private final boolean runTests = true;
    // ### repositories ###
    private final TheaterRepository theaterRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final MovieRepository movieRepository;
    private final ShowTimeRepository showTimeRepository;

    @Autowired
    public InitData(TheaterRepository theaterRepository,
                    EmployeeRepository employeeRepository,
                    CustomerRepository customerRepository,
                    MovieRepository movieRepository,
                    ShowTimeRepository showTimeRepository) {
        this.theaterRepository = theaterRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.movieRepository = movieRepository;
        this.showTimeRepository = showTimeRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (!runTests) return;

        theater();
        employee();
        customer();
        movie();
        showTime();
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

    public void movie() {
        movieRepository.save(new Movie("snask til du plasker", AgeLimit.ADULTS_ONLY, Category.ACTION, 120));
        movieRepository.save(new Movie("the one eyed monster", AgeLimit.PARENTAL_GUIDANCE_SUGGESTED, Category.COMEDY, 110));
        movieRepository.save(new Movie("the boring movie", AgeLimit.RESTRICTED, Category.DRAMA, 130));
    }

    public void showTime() {
        ShowTime showTime = new ShowTime(1, 1, 1, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);

        // tickets
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1, showTime, 1, 1, 120, false));
        tickets.add(new Ticket(2, showTime, 2, 1, 120, false));
        tickets.add(new Ticket(3, showTime, 3, 1, 120, false));

        showTime.setTickets(tickets);

        showTimeRepository.save(showTime);
        System.out.println("showTime: " + showTime);
    }

}
