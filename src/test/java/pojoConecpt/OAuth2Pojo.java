package pojoConecpt;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OAuth2Pojo {
    public static void main(String[] args) {
        //This URL needs to be generated every time and it can be only done with the instructor account
        // code keeps on changing and can be generated everytime using
        //https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php

        String url ="https://rahulshettyacademy.com/getCourse.php?code=4%2FywGTp0lInx_IkUUxejze4_hNJ0UdPduNUDHGB1QKJNs27TDP7cGwXUySbSkkuQ-O4kLo_KD1JtgVfCxX1av3Fuk&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
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
                        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                        .when().log().all()
                        .post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath jsonPath = new JsonPath(accessTokenResponse);
        String accessToken = jsonPath.getString("access_token");
        System.out.println(accessToken);

        GetCourse getCourseObj=
                given().contentType("application/json").
                queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php")
                .as(GetCourse.class);

        System.out.println(getCourseObj.getLinkedIn());
        /*System.out.println(getCourseObj.getInstructor());

        System.out.println(getCourseObj.getCourses().getApi().get(1).getCourseTitle());

        List<Api> apiCourses = getCourseObj.getCourses().getApi();

        for(int i=0;i<apiCourses.size();i++)
        {
            if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
            {
                System.out.println(apiCourses.get(i).getPrice());
            }
        }*/


    }
}
