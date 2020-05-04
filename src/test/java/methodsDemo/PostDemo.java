package methodsDemo;

import io.restassured.RestAssured;
import files.payload;

import static io.restassured.RestAssured.*;

public class PostDemo {
    public static void main(String[] args) {
        // Validate add place API is working as expected.
        //Given - All input details
        //When - Submit the API - Resource and HTTP Method
        //Then - Validate the response

        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payload.AddPlace())
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200);



    }
}
