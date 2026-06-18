package store;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import client.StoreClient;
import dataProvider.TestDataProvider;
import io.restassured.response.Response;
import models.request.StoreOrder;
import models.tesdata.TestData;

public class StoreTest extends BaseTest{
	StoreClient storeClient = new StoreClient();

    // =========================
    // CREATE ORDER
    // =========================
    @Test(priority = 1,dataProvider = "apiData",dataProviderClass = TestDataProvider.class)
    public void placeOrderTest(TestData data) {

        logger.info("Starting Place Order Test");

        StoreOrder order = new StoreOrder();

        order.setId(data.orderId);
        order.setPetId(data.petId);
        order.setQuantity(data.quantity);
        order.setStatus(data.status);
        order.setComplete(data.complete);

        Response response = storeClient.placeOrder(order);

        logger.info("Status Code: {}", response.getStatusCode());

        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), data.orderId);

        logger.info("Place Order Test Completed");
    }

    // =========================
    // GET ORDER
    // =========================
    @Test(priority = 2,dataProvider = "apiData",dataProviderClass = TestDataProvider.class)
    public void getOrderByIdTest(TestData data) {

        logger.info("Starting Get Order By Id Test");

        Response response = storeClient.getOrderById(data.orderId);

        logger.info("Status Code: {}", response.getStatusCode());

        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), data.orderId);

        logger.info("Get Order By Id Test Completed");
    }

    // =========================
    // DELETE ORDER
    // =========================
    @Test(priority = 3,dataProvider = "apiData",dataProviderClass = TestDataProvider.class)
    public void deleteOrderTest(TestData data) {

        logger.info("Starting Delete Order Test");

        Response response = storeClient.deleteOrder(data.orderId);

        logger.info("Status Code: {}", response.getStatusCode());

        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);

        logger.info("Delete Order Test Completed");
    }
}
