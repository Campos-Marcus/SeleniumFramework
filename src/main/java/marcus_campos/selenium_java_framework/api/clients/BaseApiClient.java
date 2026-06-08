package marcus_campos.selenium_java_framework.api.clients;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApiClient {

    protected RequestSpecification getRequestSpec() {

        return RestAssured
                .given()
                .contentType("application/json")
                .log().all();
    }
}