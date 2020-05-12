package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Created by Jay
 */
public class StudentPutTest extends TestBase {

    @Test
    public void updateStudentRecord(){

        List<String> courses = new ArrayList<>();
        courses.add("QA");
        courses.add("API Framework");


        StudentPojo studentPojo = new StudentPojo();

        studentPojo.setFirstName("lucky");
        studentPojo.setLastName("mak");
        studentPojo.setEamil("lucky@yahoo.com");
        studentPojo.setProgramme("QA");
        studentPojo.setCourses(courses);

        Response response = given()

                .header("Content-Type","application/json")
                .log()
                .body()
                .when()
                .body(studentPojo)
                .put("/2");
        response.then().statusCode(200);

    }
}
