package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Created by Jay
 */
public class StudentPostTest {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/student";

    }

    @Test
    public void createStudent(){

        List<String> course = new ArrayList<>();
        course.add("selenium");
        course.add("java");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("lucky");
        studentPojo.setLastName("mak");
        studentPojo.setEamil("ram@gmail.com");
        studentPojo.setProgramme("Selenium Java");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

}
