package dynamicJsonAndParameterization;

import files.ReUsableMethods;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import files.payload;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test
    public void addBook()
    {
        RestAssured.baseURI = "http://216.10.245.166";
        String addBookResponse = given().log().all().header("Content-Type","application/json").
                body(payload.AddBook("k2","1234")).
                when().post("/Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(addBookResponse);
        String addBookID = js.get("ID");
        System.out.println(addBookID);
    }


}
