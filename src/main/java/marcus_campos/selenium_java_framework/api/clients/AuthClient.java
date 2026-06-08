package marcus_campos.selenium_java_framework.api.clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import marcus_campos.selenium_java_framework.api.config.ApiConfig;
import marcus_campos.selenium_java_framework.api.models.AuthRequest;

public class AuthClient extends BaseApiClient  {

    public Response createToken(AuthRequest authRequest) {

        return getRequestSpec()
                .body(authRequest)
                .when()
                .post(ApiConfig.BASE_URL  + "/auth");
    }
}