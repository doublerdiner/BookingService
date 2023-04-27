import com.codeclan.bookingservice.models.Booking;
import com.codeclan.bookingservice.models.Course;
import com.codeclan.bookingservice.models.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassTest {
    private Booking booking;
    private Course course;
    private Customer customer;


    @Test
    public void customerHasDetails(){
        customer = new Customer("Chris", "Monifieth", 34);
        assertEquals("Chris", customer.getName());
        assertEquals("Monifieth", customer.getTown());
        assertEquals(34, customer.getAge());
        assertEquals(0, customer.getBookings().size());
    }
    @Test
    public void courseHasDetails(){
        course = new Course("CodeClan", "Online", 5);
        assertEquals("CodeClan", course.getName());
        assertEquals("Online", course.getLocation());
        assertEquals(5, course.getRating());
        assertEquals(0, course.getBookings().size());
    }
    @Test
    public void bookingHasDetails(){
        customer = new Customer("Chris", "Monifieth", 34);
        course = new Course("CodeClan", "Online", 5);
        booking = new Booking("01/01/23", customer, course);
        assertEquals("01/01/23", booking.getDate());
        assertEquals("Chris", booking.getCustomer().getName());
        assertEquals("CodeClan", booking.getCourse().getName());
    }

}
