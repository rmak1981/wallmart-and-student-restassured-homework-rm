package com.studentapp.assertionexample;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by Jay
 */
public class SoftAssertionsExample extends TestBase {

    @Test
    public void hardAssert() {

        Response response = (Response) given()
                .when()
                .get("/list")
                .then()
                .body( "[0].id", equalTo("1"))
                .body("[0].firstName",equalTo("Vernon"))
                .body("[0].lastName",equalTo("Harper"))
                .body("[0].email",equalTo("egestas.rhoncus.Proin@massaQuisqueporttitor.org"));

    }

    @Test
    public void softAssert() {
        given()
                .when()
                .get("/list")
                .then()
                .body("[0].id", equalTo(2),
                        "[0].firstName", equalTo("Vernon"),
                        "[0].lastName", equalTo("Harper"),
                        "[0].email", equalTo("egestas.rhoncus.Proin@massaQuisqueporttitor.org"));

    }

    }

