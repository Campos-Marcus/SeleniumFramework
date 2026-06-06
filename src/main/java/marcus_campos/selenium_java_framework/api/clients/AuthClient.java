package marcus_campos.selenium_java_framework.api.clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import marcus_campos.selenium_java_framework.api.models.AuthRequest;

public class AuthClient {

    private static final String BASE_URL =
            "https://restful-booker.herokuapp.com";

    public Response createToken(AuthRequest authRequest) {

        return RestAssured
                .given()
                
                .contentType("application/json")
                .body(authRequest)
                .when()
                //.log().all()
                .post(BASE_URL + "/auth");
    }
}