package OAuth2;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class OAuth2 {
    public static void main(String[] args) {
        //This URL needs to be generated every time and it can be only done with the instructor account
        // code keeps on changing and can be generated everytime using
        //https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php

        String url ="https://rahulshettyacademy.com/getCourse.php?code=4%2FywFUUXHadB3K9hMdZb858YUBIJI_EAgVC-vO0q7aUR6P_PG5JEwQt8SRZXx476LJl2dk-dfLdJOA4oVes7Sq6zg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#";

        String partialcode=url.split("code=")[1];

        String code=partialcode.split("&scope")[0];

        System.out.println(code);

        String accessTokenResponse =
                given()
                        .urlEncodingEnabled(false)
                        .queryParams("code",code)
                        .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                        .queryParams("grant_type", "authorization_code")
                        .queryParams("state", "verifyfjdss")
                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                        .queryParams("scope","https://www.googleapis.com/auth/userinfo.email")
                        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                        .when().log().all()
                        .post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath jsonPath = new JsonPath(accessTokenResponse);
        String accessToken = jsonPath.getString("access_token");
        System.out.println(accessToken);

        String r2=
                given().contentType("application/json").
                queryParam("access_token", accessToken)
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php")
                .asString();

        System.out.println(r2);




    }
}
