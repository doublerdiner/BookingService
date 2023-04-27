package com.codeclan.bookingservice.repositories;

import com.codeclan.bookingservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomersByBookingsCourseNameIgnoreCase(String name);

    List<Customer> findCustomersByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String townName, String courseName);

    List<Customer> findCustomersByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(int age, String townName, String courseName);
}
