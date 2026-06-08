package marcus_campos.selenium_java_framework;

import io.restassured.response.Response;
import marcus_campos.selenium_java_framework.api.clients.AuthClient;
import marcus_campos.selenium_java_framework.api.clients.BookingClient;
import marcus_campos.selenium_java_framework.api.models.AuthRequest;
import marcus_campos.selenium_java_framework.api.models.AuthResponse;
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

                AuthRequest authRequest = new AuthRequest();

                authRequest.setUsername("admin");
                authRequest.setPassword("password123");

                AuthClient authClient = new AuthClient();

                Response authResponse = authClient.createToken(authRequest);

                AuthResponse tokenResponse = authResponse.as(AuthResponse.class);

                String token = tokenResponse.getToken();

                Booking updatedBooking = BookingFactory.createBooking();

                updatedBooking.setFirstname("MarcusUpdated");
                Response updateResponse = bookingClient.updateBooking(
                                bookingId,
                                updatedBooking,
                                token);

                updateResponse.prettyPrint();

                Booking updatedResponse = updateResponse.as(Booking.class);

                assertEquals(
                                "MarcusUpdated",
                                updatedResponse.getFirstname());

                Response getUpdatedResponse = bookingClient.getBooking(bookingId);

                Booking retrievedBooking = getUpdatedResponse.as(Booking.class);

                assertEquals(
                                "MarcusUpdated",
                                retrievedBooking.getFirstname());

                Response deleteResponse = bookingClient.deleteBooking(
                                bookingId,
                                token);
                deleteResponse.prettyPrint();

                assertEquals(
                                201,
                                deleteResponse.getStatusCode());

                Response deletedBookingResponse = bookingClient.getBooking(bookingId);

                assertEquals(
                                404,
                                deletedBookingResponse.getStatusCode());
                deletedBookingResponse.prettyPrint();
        }

}