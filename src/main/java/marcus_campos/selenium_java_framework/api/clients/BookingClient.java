package marcus_campos.selenium_java_framework.api.clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import marcus_campos.selenium_java_framework.api.models.Booking;

public class BookingClient {

    private static final String BASE_URL = "https://restful-booker.herokuapp.com";

    public Response createBooking(Booking booking) {

        return RestAssured
                .given()
                .contentType("application/json")
                .body(booking)
                .when()
                .post(BASE_URL + "/booking");
    }

    public Response getBooking(Integer bookingId) {

        return RestAssured
                .given()
                .when()
                .get(BASE_URL + "/booking/" + bookingId);
    }

    public Response updateBooking(
            Integer bookingId,
            Booking booking,
            String token) {

        return RestAssured
                .given()
                .contentType("application/json")
                .cookie("token", token)
                .body(booking)
                .when()
                .put(BASE_URL + "/booking/" + bookingId);
    }

}