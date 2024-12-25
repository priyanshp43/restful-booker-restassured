package com.herokuapp.booker.restful.bookinginfo;

import com.herokuapp.booker.restful.model.BookingPojo;
import com.herokuapp.booker.restful.testbase.TestBase;
import com.herokuapp.booker.restful.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutUpdateTest extends TestBase {

    static String id;

    @Test
    public void verifyUpdateUsers() {
        String firstName = TestUtils.getRandomValue() + "Pri";
        String lastName = TestUtils.getRandomValue() + "Patel";
        int totalPrice = 111;
        boolean depositPaid = true;
        HashMap<String, String> bookingDates = new HashMap<>();
        String checkIn = "2022-07-05";
        String checkOut = "2022-07-15";
        bookingDates.put("checkin", checkIn);
        bookingDates.put("checkout", checkOut);
        String additionalNeeds = "midnight snack";

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstName);
        bookingPojo.setLastname(lastName);
        bookingPojo.setTotalprice(totalPrice);
        bookingPojo.setDepositpaid(depositPaid);
        bookingPojo.setBookingdates(bookingDates);
        bookingPojo.setAdditionalneeds(additionalNeeds);

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(bookingPojo)
                .put("/booking");

        id = response.jsonPath().getString("bookingid");

        response.prettyPrint();
        response.then().log().ifValidationFails().statusCode(200);
    }
}
