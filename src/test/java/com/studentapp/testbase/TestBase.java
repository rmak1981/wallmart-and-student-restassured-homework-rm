package com.studentapp.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/*
 * Ravi's Creation
 * Date of Creation
 */
public class TestBase {
    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/student";
    }
}
