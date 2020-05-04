package dynamicJsonAndParameterization;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class StaticJson {
    //Static Json is being used when the data from API method body stays same for all the scenarios.
    @Test
    public void addBook() throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        String addBookResponse = given().log().all().header("Content-Type","application/json").
                body(GenerateStringFromResource("C:\\Users\\kaushik\\Documents\\Kaushik\\Selenium Projects\\RestAPIAutomationRestAssured\\src\\test\\java\\dynamicJsonAndParameterization\\AddBookDetails.json")).
                when().post("/Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(addBookResponse);
        String addBookID = js.get("ID");
        System.out.println(addBookID);
    }
    public static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
