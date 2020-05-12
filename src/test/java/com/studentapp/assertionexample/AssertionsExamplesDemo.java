package com.studentapp.assertionexample;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AssertionsExamplesDemo {

    private static final String API_KEY = "75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init(){

        RestAssured.baseURI = "http://api.walmartlabs.com";
        RestAssured.basePath = "/v1";

    }


    // 1) Verify if the number of items is equal to 10
    @Test
    public void test001() {
        given()
                .queryParam("query","ipod")
                .queryParam("format","json")
                .queryParam("apiKey",API_KEY)
                .when()
                .get("/search")
                .then()
                .body("numItems",equalTo(10));

    }
    @Test //Home work
    public void test002() {
        given()
                .queryParam("query","ipod")
                .queryParam("format","json")
                .queryParam("apiKey",API_KEY)
                .when()
                .get("/search")
                .then()
                .body("query",equalTo("ipod"));



    }

    // 3) Check Single Name in ArrayList (Apple iPod Touch 6th Generation 32GB Refurbished)
    @Test
    public void test003() {
        given()
                .queryParam("query","ipod")
                .queryParam("format","json")
                .queryParam("apiKey",API_KEY)
                .when()
                .get("/search")
                .then()
                .body("item.name",hasItem("Apple iPod touch 7th Generation 32GB - Space Gray (New Model)"));

    }

    // 4) Check Multiple Names in ArrayList (Apple iPod touch 7th Generation 128GB - Gold (New Model)","Apple iPod touch 16GB)
    @Test  //Homework
    public void test004() {
        given()
                .queryParam("query","ipod")
                .queryParam("format","json")
                .queryParam("apiKey",API_KEY)
                .when()
                .get("/search")
                .then()
                .body("items.name",hasItems("Apple iPod touch 7th Generation 128GB - Gold (New Model)","Apple iPod touch 32GB  (Assorted Colors)"));

    }


    // 5) Verify the entityType inside imageEntities for the first product (Checking Values inside Map using hasKey(entityType))
    @Test
    public void test005() {
        given()
                .queryParam("query","ipod")
                .queryParam("format","json")
                .queryParam("apiKey",API_KEY)
                .when()
                .get("/search")
                .then()
                .body("item[0].imageEntities[0]",hasKey("entitiytype123"));


    }

    // 6) Check hash map values inside a list categoryPath=Home Page/Electronics/Portable Audio/Apple iPods/iPod Touch
    @Test // homework
    public void test006() {

        given()
                .queryParam("query","ipod")
                .queryParam("format","json")
                .queryParam("apiKey",API_KEY)
                .when()
                .get("/search")
                .then()
                .body("items[3,5].categoryPath",hasItem("Home Page/Electronics/Portable Audio/Apple iPods/iPod Touch"));

    }

    // 7) Checking multiple values in the same statement
    @Test
    public void test007() {

        given()
                .queryParam("query","ipod")
                .queryParam("format","json")
                .queryParam("apiKey",API_KEY)
                .when()
                .get("/search")
                .then()
                .body("items[0].imageEntities[0]",hasItem("entityType"))
                .body("numItems",equalTo(10))
                .body("item.name",hasItem("Apple iPod touch 7th Generation 32GB - Space Gray (New Model)"));


    }

    // 8) Logical Assertions
    @Test
    public void test008() {
        given()
                .queryParam("query","ipod")
                .queryParam("format","json")
                .queryParam("apiKey",API_KEY)
                .when()
                .get("/search")
                .then()
                .body("items.size()",equalTo(10))
                .body("item.size()",greaterThan(8))
                .body("item.size()",lessThan(12))
                .body("item.size()",lessThan(12));
    }
}
