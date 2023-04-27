package com.codeclan.bookingservice;

import com.codeclan.bookingservice.models.Booking;
import com.codeclan.bookingservice.models.Course;
import com.codeclan.bookingservice.models.Customer;
import com.codeclan.bookingservice.repositories.BookingRepository;
import com.codeclan.bookingservice.repositories.CourseRepository;
import com.codeclan.bookingservice.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookingserviceApplicationTests {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void canAddCustomer(){
		Customer customer = new Customer("Chris", "Monifieth", 34);
		System.out.println(customerRepository.save(customer));
	}
	@Test
	public void canAddCourse(){
		Course course = new Course("CodeClan", "Online", 5);
		courseRepository.save(course);
	}
	@Test
	public void canAddBooking(){
		Customer customer = new Customer("Aimi", "Monifieth", 35);
		Course course = new Course("Screen Printing", "Online", 4);
		Booking booking = new Booking("01/01/23", customer, course);
		customerRepository.save(customer);
		courseRepository.save(course);
		bookingRepository.save(booking);

	}
	@Test
	public void canFindAllCoursesWithAGivenRating(){
		List<Course> courses = courseRepository.findCoursesByRating(5);
		System.out.println(courses);
	}
	@Test
	public void canFindAllCustomersForAGivenCourseName(){
		List<Customer> customers = customerRepository.findCustomersByBookingsCourseNameIgnoreCase("CodeClan");
		System.out.println(customers);
	}
	@Test
	public void canFindCoursesForGivenCustomer(){
		List<Course> courses = courseRepository.findCoursesByBookingsCustomerNameIgnoreCase("Chris");
		System.out.println(courses);
	}
	@Test
	public void canFindAllBookingsByDate(){
		List<Booking> bookings = bookingRepository.findBookingsByDate("01/01/23");
		System.out.println(bookings);
	}
	@Test
	public void canFindAllCustomersInAGivenTownForAGivenCourse(){
		List<Customer> customers = customerRepository.findCustomersByTownIgnoreCaseAndBookingsCourseNameIgnoreCase("Monifieth", "Screen Printing");
		System.out.println(customers);
	}
	@Test
	public void canFindAllCustomersOverACertainAgeInATownByACourse(){
		List<Customer> customers = customerRepository.findCustomersByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(34, "Monifieth", "Screen Printing");
		System.out.println(customers);
	}

}
