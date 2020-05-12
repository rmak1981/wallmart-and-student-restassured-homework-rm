package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Jay
 */
public class StudentDeleteTest extends TestBase {

    @Test

    public void deleteRecordByID() {

        given()
                .when()
                .delete("/6")
                .then().statusCode(204);
    }
}