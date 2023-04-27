package com.codeclan.bookingservice.controllers;

import com.codeclan.bookingservice.models.Course;
import com.codeclan.bookingservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name="rating", required = false)Integer rating,
            @RequestParam(name="name", required = false)String name
            ){
        if(rating != null){
            return new ResponseEntity<>(courseRepository.findCoursesByRating(rating), HttpStatus.OK);
        }
        else if(name != null){
            return new ResponseEntity<>(courseRepository.findCoursesByBookingsCustomerNameIgnoreCase(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
