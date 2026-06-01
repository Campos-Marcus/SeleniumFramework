package marcus_campos.selenium_java_framework;

import io.restassured.response.Response;
import marcus_campos.selenium_java_framework.api.clients.BookingClient;
import marcus_campos.selenium_java_framework.api.models.Booking;
import marcus_campos.selenium_java_framework.api.models.BookingResponse;
import marcus_campos.selenium_java_framework.data.BookingFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingApiTest {

    @Test
    void shouldCreateBooking() {

        Booking booking = BookingFactory.createBooking();

        BookingClient bookingClient = new BookingClient();

        Response response = bookingClient.createBooking(booking);

        response.prettyPrint();

        BookingResponse bookingResponse = response.as(BookingResponse.class);

        Integer bookingId = bookingResponse.getBookingid();

        System.out.println("Booking ID: " + bookingId);

        assertEquals(
                booking.getFirstname(),
                bookingResponse.getBooking().getFirstname());

        assertEquals(
                booking.getLastname(),
                bookingResponse.getBooking().getLastname());

        Response getResponse = bookingClient.getBooking(bookingId);

        assertEquals(
                200,
                getResponse.getStatusCode());
    }

}