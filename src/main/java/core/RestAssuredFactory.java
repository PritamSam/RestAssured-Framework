package core;

import auth.AuthManager;
import auth.AuthType;
import config.ConfigReader;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestAssuredFactory {
    private RestAssuredFactory() {
    }

    public static RequestSpecification getRequestSpec(AuthType authType) {

        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("base.url"))
                .setContentType("application/json")
                .addHeader("accept", "application/json")
                .addFilter(new AllureRestAssured());

        switch (authType) {

            case API_KEY:
                builder.addHeader(
                        "api_key",
                        AuthManager.getApiKey()
                );
                break;

            case NONE:
            default:
                break;
        }

        return builder.build();
    }

    public static void init() {

        RestAssured.requestSpecification =
                getRequestSpec(AuthType.NONE);
    }
}
