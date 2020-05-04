package methodsDemo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import files.payload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPlace {
    public static void main(String[] args) {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        String responseData =
                given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                        .body(payload.AddPlace())
                        .when().post("/maps/api/place/add/json")
                        .then().log().all().assertThat().statusCode(200)
                        .body("scope",equalTo("APP"))
                        .header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString();

        System.out.println(responseData);

        JsonPath js = new JsonPath(responseData); //For Parsing Json Data
        String placeId = js.getString("place_id");
        System.out.println(placeId);
    }
}
