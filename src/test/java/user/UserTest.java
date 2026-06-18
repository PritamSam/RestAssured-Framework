package user;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import client.UserClient;
import dataProvider.TestDataProvider;
import io.restassured.response.Response;
import models.request.User;
import models.tesdata.TestData;
import utils.SchemaValidator;

public class UserTest extends BaseTest{
	UserClient userClient = new UserClient();

    // =========================
    // CREATE USER
    // =========================
    @Test(priority = 1,dataProvider = "apiData",dataProviderClass = TestDataProvider.class)
    public void createUserTest(TestData data) {

        logger.info("Starting Create User Test");

        User user = new User();

        user.setId(data.id);
        user.setUsername(data.username);
        user.setFirstName(data.firstName);
        user.setLastName(data.lastName);
        user.setEmail(data.email);
        user.setPassword(data.password);
        user.setPhone(data.phone);
        user.setUserStatus(data.userStatus);

        Response response = userClient.createUser(user);

        logger.info("Status Code: {}", response.getStatusCode());

        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);

        logger.info("Create User Test Completed");
    }

    // =========================
    // GET USER
    // =========================
    @Test(priority = 2,dataProvider = "apiData",dataProviderClass = TestDataProvider.class)
    public void getUserTest(TestData data) {

        logger.info("Starting Get User Test");

        Response response = userClient.getUser(data.username);

        logger.info("Status Code: {}", response.getStatusCode());

        response.then().log().all();

        SchemaValidator.validate(response, "get-user-schema.json");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(
                response.jsonPath().getString("username"),
                data.username
        );

        logger.info("Get User Test Completed");
    }

    // =========================
    // UPDATE USER
    // =========================
    @Test(priority = 3,dataProvider = "apiData",dataProviderClass = TestDataProvider.class)
    public void updateUserTest(TestData data) {

        logger.info("Starting Update User Test");

        User user = new User();

        user.setFirstName("Johnny");
        user.setLastName(data.lastName);

        Response response = userClient.updateUser(data.username, user);

        logger.info("Status Code: {}", response.getStatusCode());

        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);

        logger.info("Update User Test Completed");
    }

    // =========================
    // DELETE USER
    // =========================
    @Test(priority = 4,dataProvider = "apiData",dataProviderClass = TestDataProvider.class)
    public void deleteUserTest(TestData data) {

        logger.info("Starting Delete User Test");

        Response response = userClient.deleteUser(data.username);

        logger.info("Status Code: {}", response.getStatusCode());

        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);

        logger.info("Delete User Test Completed");
    }
}
