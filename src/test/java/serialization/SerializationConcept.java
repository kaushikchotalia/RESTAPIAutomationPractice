package serialization;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class SerializationConcept {
    public static void main(String[] args) {
        AddPlace p = new AddPlace();
        p.setAccuracy(60);
        p.setAddress("29, side layout");
        p.setLanguage("French-IN");
        p.setPhoneNumber("+983 893 3937");
        p.setWebsite("http://google.com");
        p.setName("Frontline Test");

        List<String> typeList = new ArrayList<String>();
        typeList.add("shoe");
        typeList.add("shop");
        p.setType(typeList);

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        Response res = given().log().all().queryParam("key","qaclick123")
                .body(p)
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();

        String responseString = res.asString();
        System.out.println(responseString);

    }
}
