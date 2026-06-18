package client;

import constants.APIEndpoints;
import core.RestAssuredFactory;
import io.restassured.response.Response;
import models.request.User;

import static io.restassured.RestAssured.given;

import auth.AuthType;

public class UserClient {
	public Response createUser(User user) {
        return given()
        		.spec(RestAssuredFactory.getRequestSpec(AuthType.API_KEY))
                .body(user)
                .when()
                .post(APIEndpoints.USER_CREATE);
    }

    public Response getUser(String username) {
        return given()
        		.spec(RestAssuredFactory.getRequestSpec(AuthType.API_KEY))
                .pathParam("username", username)
                .when()
                .get(APIEndpoints.USER_GET);
    }

    public Response updateUser(String username, User user) {
        return given()
        		.spec(RestAssuredFactory.getRequestSpec(AuthType.API_KEY))
                .pathParam("username", username)
                .body(user)
                .when()
                .put(APIEndpoints.USER_UPDATE);
    }

    public Response deleteUser(String username) {
        return given()
        		.spec(RestAssuredFactory.getRequestSpec(AuthType.API_KEY))
                .pathParam("username", username)
                .when()
                .delete(APIEndpoints.USER_DELETE);
    }

    public Response login(String user, String pass) {
        return given()
        		.spec(RestAssuredFactory.getRequestSpec(AuthType.API_KEY))
                .queryParam("username", user)
                .queryParam("password", pass)
                .when()
                .get(APIEndpoints.USER_LOGIN);
    }

    public Response logout() {
        return given()
        		.spec(RestAssuredFactory.getRequestSpec(AuthType.API_KEY))
                .when()
                .get(APIEndpoints.USER_LOGOUT);
    }
}
