package com.studentapp.loggingrequestresponse;

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
public class LoggingRequestDetails extends TestBase {

    /**
     * This test will print out all the request headers
     */
    @Test
    public void test001(){

        System.out.println("---------------Printing Request Headers------------------");
        given()
                .log()
                .headers()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }

    /**
     * This test will print out all the request Parameters
     */
    @Test
    public void test002(){

        System.out.println("---------------Printing Request Parameters------------------");
        given()
                .param("programme","Computer Science")
                .param("limit","2")
                .log()
                .parameters()
                .when()
                .get("/list")
                .then()
                .statusCode(200);

    }

    /**
     * This test will print out the Request body
     */
    @Test
    public void test003(){

        System.out.println("---------------Printing Request Body------------------");
        List<String> course = new ArrayList<>();
        course.add("selenium");
        course.add("java");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("lucky");
        studentPojo.setLastName("mak");
        studentPojo.setEamil("superman100@gmail.com");
        studentPojo.setProgramme("Selenium Java");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .body()
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    /**
     * This test will print out All the details
     */
    @Test
    public void getStudentById(){

        Response response = given()
                .log()
                .all()
                .when()
                .get("/5");
                response.then().statusCode(200);
                response.prettyPrint();

        System.out.println("---------------Printing All the Request Details------------------");
    }


    /**
     * This test will print Request details if validation fails
     */
    @Test
    public void getStudentByIdParameter(){

        Response response = given()
                .param("lastName","Harper")
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();

        System.out.println("---------------Printing All the Request Details if validation fails------------------");
    }
}
