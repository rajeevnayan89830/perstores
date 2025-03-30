package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class UserTest {
    Faker faker;
    User userpayload;
    //public Logger logger;

    @BeforeTest
    public void setupUser() {
        faker = new Faker();
        userpayload = new User();

        // Generate a fixed username
        String fixedUsername = faker.name().username();
        userpayload.setId(faker.idNumber().hashCode());
        userpayload.setUsername(fixedUsername);
        userpayload.setFirstname(faker.name().firstName());
        userpayload.setLastname(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        userpayload.setPassword(faker.internet().password(5, 10));
        userpayload.setPhone(faker.phoneNumber().cellPhone());

        //logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPostUser() {
        //logger.info("******** Creating user *******");
        Response response = UserEndPoints.createUser(userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        //logger.info("***** User is created *******");
    }

    @Test(priority = 2)
    public void testGetUser() {
        //logger.info("****** Reading user *******");
        Response response = UserEndPoints.readUser(this.userpayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void testUpdateUser() {
        //logger.info("***** Updating user *********");
        userpayload.setFirstname(faker.name().firstName());
        userpayload.setLastname(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());

        Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        // Checking data after update
        Response responseAfterUpdate = UserEndPoints.readUser(this.userpayload.getUsername());
        responseAfterUpdate.then().log().all();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);

        //logger.info("******** User is updated ********");
    }

    @Test(priority = 4)
    public void testDeleteUser() {
        //logger.info("********* Deleting user *********");
        Response response = UserEndPoints.deleteUser(this.userpayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        //logger.info("******* User deleted *******");
    }
}
