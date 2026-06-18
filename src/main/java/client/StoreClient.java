package client;

import constants.APIEndpoints;
import core.RestAssuredFactory;
import io.restassured.response.Response;
import models.request.StoreOrder;

import static io.restassured.RestAssured.given;

import auth.AuthType;

public class StoreClient {
    public Response getInventory() {
    	 return given()
                 .spec(RestAssuredFactory.getRequestSpec(AuthType.API_KEY))
                 .when()
                 .get(APIEndpoints.STORE_INVENTORY);
    }

    public Response placeOrder(StoreOrder order) {
        return given()
        		.spec(RestAssuredFactory.getRequestSpec(AuthType.API_KEY))
                .body(order)
                .when()
                .post(APIEndpoints.STORE_ORDER);
    }

    public Response getOrderById(int orderId) {
        return given()
                .pathParam("orderId", orderId)
                .when()
                .get(APIEndpoints.STORE_ORDER_BY_ID);
    }

    public Response deleteOrder(int orderId) {
        return given()
        		.spec(RestAssuredFactory.getRequestSpec(AuthType.API_KEY))
                .pathParam("orderId", orderId)
                .when()
                .delete(APIEndpoints.STORE_ORDER_BY_ID);
    }
}
