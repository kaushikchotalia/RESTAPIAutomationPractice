package specbuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import serialization.AddPlace;
import serialization.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SerializationConceptSpecBuilder {
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
        p.setTypes(typeList);

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);

        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON).build();

        RequestSpecification res = given().spec(req)
                .body(p);

           Response response = res.when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();

        String responseString = response.asString();
        System.out.println(responseString);

    }
}
