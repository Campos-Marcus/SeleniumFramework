package marcus_campos.selenium_java_framework.api.clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import marcus_campos.selenium_java_framework.api.models.Booking;
import marcus_campos.selenium_java_framework.api.config.ApiConfig;

public class BookingClient extends BaseApiClient {

    public Response createBooking(Booking booking) {

        return getRequestSpec()
                .body(booking)
                .when()
                .post(ApiConfig.BASE_URL + "/booking");
    }

    public Response getBooking(Integer bookingId) {

        return RestAssured
                .given()
                .when()
                .get(ApiConfig.BASE_URL + "/booking/" + bookingId);
    }

    public Response updateBooking(
            Integer bookingId,
            Booking booking,
            String token) {

        return getRequestSpec()
                .cookie("token", token)
                .body(booking)
                .when()
                .put(ApiConfig.BASE_URL + "/booking/" + bookingId);
    }

    public Response deleteBooking(
            Integer bookingId,
            String token) {

        return RestAssured
                .given()
                .cookie("token", token)
                .when()
                .delete(ApiConfig.BASE_URL + "/booking/" + bookingId);
    }

}