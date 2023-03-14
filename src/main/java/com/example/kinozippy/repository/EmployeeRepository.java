package com.example.kinozippy.repository;

import com.example.kinozippy.model.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.username = :username AND e.password = :password")
    public Employee findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
