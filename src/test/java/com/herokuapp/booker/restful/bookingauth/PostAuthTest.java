package com.herokuapp.booker.restful.bookingauth;

import com.herokuapp.booker.restful.model.AuthPojo;
import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostAuthTest extends TestBase {

    @Test
    public void createAuthToken() {
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername("admin");
        authPojo.setPassword("password1234");
        Response response = given().log().all()
                .header("Content-Type","application/json")
                .when()
                .body(authPojo)
                .post();
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
