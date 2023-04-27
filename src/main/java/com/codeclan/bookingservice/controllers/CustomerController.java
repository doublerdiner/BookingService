package com.codeclan.bookingservice.controllers;

import com.codeclan.bookingservice.models.Customer;
import com.codeclan.bookingservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "course", required = false) String course,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age
    ) {
        if (age != null) {
            return new ResponseEntity<>(customerRepository.findCustomersByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, course), HttpStatus.OK);
        } else if (town != null) {
            return new ResponseEntity<>(customerRepository.findCustomersByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, course), HttpStatus.OK);
        } else if (course != null) {
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/customers")
    public ResponseEntity saveCustomer(
            @RequestBody Customer customer
    ){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer
    ){
        Customer updateCustomer = customerRepository.findById(id).get();
        updateCustomer.setName(customer.getName());
        updateCustomer.setTown(customer.getTown());
        updateCustomer.setAge(customer.getAge());
        customerRepository.save(updateCustomer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.ACCEPTED);
    }
//    Need cascade set up to work properly
    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<Long> deleteCustomer(
            @PathVariable Long id
    ){
        customerRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
