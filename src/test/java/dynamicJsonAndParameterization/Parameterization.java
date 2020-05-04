package dynamicJsonAndParameterization;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Parameterization {
    @DataProvider(name="BooksData")
    public Object[][] getData()
    {
        return new Object[][] {{"k3","123"},{"k4","234"},{"k5","345"}}; //return multi-dimension array to represent elements for each data set.
    }
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle)
    {
        RestAssured.baseURI = "http://216.10.245.166";
        String addBookResponse = given().log().all().header("Content-Type","application/json").
                body(payload.AddBook(isbn,aisle)).
                when().post("/Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(addBookResponse);
        String addBookID = js.get("ID");
        System.out.println(addBookID);
    }
}
