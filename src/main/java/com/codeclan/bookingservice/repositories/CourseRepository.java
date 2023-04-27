package com.codeclan.bookingservice.repositories;

import com.codeclan.bookingservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCoursesByRating(int num);

    List<Course> findCoursesByBookingsCustomerNameIgnoreCase(String name);
}
