package com.example.kinozippy.repository;

import com.example.kinozippy.model.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.username = :username AND c.password = :password")
    public Customer findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
