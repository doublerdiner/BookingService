package com.codeclan.bookingservice.components;

import com.codeclan.bookingservice.models.Booking;
import com.codeclan.bookingservice.models.Course;
import com.codeclan.bookingservice.models.Customer;
import com.codeclan.bookingservice.repositories.BookingRepository;
import com.codeclan.bookingservice.repositories.CourseRepository;
import com.codeclan.bookingservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Chris", "Monifieth", 34);
        Customer customer2 = new Customer("Aimi", "Monifieth", 36);
        Customer customer3 = new Customer("Kim", "Dundee", 61);
        Customer customer4 = new Customer("Nick", "Perth", 63);
        Customer customer5 = new Customer("Jim", "Nottingham", 3);
        Customer customer6 = new Customer("Dan", "Nottingham", 34);
        Customer customer7 = new Customer("Sabrina", "Nottingham", 33);
        Course course1 = new Course("CodeClan", "Edinburgh", 5);
        Course course2 = new Course("Screen Printing", "Dundee", 5);
        Course course3 = new Course("Microsoft Office Packages", "Glasgow", 2);
        Course course4 = new Course("HTML & CSS", "Edinburgh", 1);
        Course course5 = new Course("Adobe Photoshop", "Edinburgh", 5);
        Booking booking1 = new Booking("01/01/23", customer1, course1);
        Booking booking2 = new Booking("01/02/23", customer2, course2);
        Booking booking3 = new Booking("03/03/23", customer3, course3);
        Booking booking4 = new Booking("03/03/23", customer4, course3);
        Booking booking5 = new Booking("01/02/23", customer1, course2);
        Booking booking6 = new Booking("16/02/23", customer6, course4);
        Booking booking7 = new Booking("16/02/23", customer7, course4);
        Booking booking8 = new Booking("10/03/23", customer2, course5);
        Booking booking9 = new Booking("01/01/23", customer3, course1);
        Booking booking10 = new Booking("01/01/23", customer4, course1);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
        customerRepository.save(customer6);
        customerRepository.save(customer7);
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);
        courseRepository.save(course5);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
        bookingRepository.save(booking6);
        bookingRepository.save(booking7);
        bookingRepository.save(booking8);
        bookingRepository.save(booking9);
        bookingRepository.save(booking10);
    }
}
