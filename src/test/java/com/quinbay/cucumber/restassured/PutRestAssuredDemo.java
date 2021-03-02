package com.quinbay.cucumber.restassured;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
public class PutRestAssuredDemo {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/";
        //RestAssured.baseURI = "https://reqres.in/";
        String body = "{\n" + "    \"name\": \"morpheus\",\n" + "    \"job\": \"leader\"\n" + "}";
        given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                .when()
                .body(body)
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(201)
                .assertThat()
                .body("name", equalTo("morpheus"))
                .assertThat()
                .body("job", equalTo("leader"))
                .assertThat()
                .body(matchesJsonSchemaInClasspath("Test1.json"))
                .log()
                .all();
    }
}