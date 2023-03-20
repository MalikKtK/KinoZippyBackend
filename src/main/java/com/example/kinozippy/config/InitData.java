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
        customerRepository.save(new Customer(1, "c1", "123"));
        customerRepository.save(new Customer(2, "c2", "123"));
        customerRepository.save(new Customer(3, "c3", "123"));
    }

    public void movie() {
        movieRepository.save(new Movie(1,"peter the can man", AgeLimit.ADULTS_ONLY, Category.ACTION, 120, null, 1));
        movieRepository.save(new Movie(2, "the big movie", AgeLimit.PARENTAL_GUIDANCE_SUGGESTED, Category.COMEDY, 110, null, 5));
        movieRepository.save(new Movie(3,"the boring movie", AgeLimit.RESTRICTED, Category.DRAMA, 130, null, 6));
    }

    public void showTime() {
        ShowTime showTime = new ShowTime(1, 100, theaterRepository.getReferenceById(1L), movieRepository.getReferenceById(1L), LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        ShowTime showTime2 = new ShowTime(2, 110, theaterRepository.getReferenceById(1L), movieRepository.getReferenceById(1L), LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        ShowTime showTime3 = new ShowTime(3, 120, theaterRepository.getReferenceById(2L), movieRepository.getReferenceById(2L), LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        ShowTime showTime4 = new ShowTime(4, 130, theaterRepository.getReferenceById(2L), movieRepository.getReferenceById(2L), LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);

        // tickets
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1, showTime, 1, 1, 120, false, false));
        tickets.add(new Ticket(2, showTime, 2, 1, 120, false, false));
        tickets.add(new Ticket(3, showTime, 3, 1, 120, false, false));

        showTime.setTickets(tickets);

        showTimeRepository.save(showTime);
        showTimeRepository.save(showTime2);
        showTimeRepository.save(showTime3);
        showTimeRepository.save(showTime4);
        System.out.println("showTime: " + showTime);
    }

}
