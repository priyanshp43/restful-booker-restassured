package com.herokuapp.booker.restful.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void inIt(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        //RestAssured.basePath = "/apidoc";
    }
}
