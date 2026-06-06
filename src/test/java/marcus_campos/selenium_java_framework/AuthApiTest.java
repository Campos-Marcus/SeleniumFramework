package marcus_campos.selenium_java_framework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

import marcus_campos.selenium_java_framework.api.clients.AuthClient;
import marcus_campos.selenium_java_framework.api.models.AuthRequest;
import marcus_campos.selenium_java_framework.api.models.AuthResponse;

public class AuthApiTest {
    @Test
    void shouldCreateToken() {

        AuthRequest authRequest = new AuthRequest();

        authRequest.setUsername("admin");
        authRequest.setPassword("password123");

        AuthClient authClient = new AuthClient();

        Response response = authClient.createToken(authRequest);

        response.prettyPrint();

        AuthResponse authResponse = response.as(AuthResponse.class);

        System.out.println(authResponse.getToken());
        assertEquals(200, response.getStatusCode());
    }

    
}
