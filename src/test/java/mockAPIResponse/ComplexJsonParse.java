package mockAPIResponse;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args) {
        /*1. Print No of courses returned by API
        2.Print Purchase Amount
        3. Print Title of the first course
        4. Print All course titles and their respective Prices
        5. Print no of copies sold by RPA Course
        6. Verify if Sum of all Course prices matches with Purchase Amount*/

        JsonPath js = new JsonPath(payload.CoursePrice());

        //1. Print No of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println(count);

        //2.Print Purchase Amount
        int totalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalPurchaseAmount);

        //3. Print Title of the first course
        String firstCourseTitle = js.get("courses[0].title");
        System.out.println(firstCourseTitle);

        //4. Print All course titles and their respective Prices
        for(int i=0;i<count;i++)
        {

            String courseTitles = js.get("courses["+i+"].title");
            String coursePrice = js.get("courses["+i+"].price").toString();
            System.out.println(courseTitles);
            System.out.println(coursePrice);
        }

        //5. Print no of copies sold by RPA Course
        System.out.println("Print number of copies sold by RA Course");
        for(int i=0;i<count;i++)
        {
            String courseTitles = js.get("courses["+i+"].title");
            if (courseTitles.equalsIgnoreCase("RPA"))
            {
                int copiesCount = js.get("courses["+i+"].copies");
                System.out.println(copiesCount);
                break;
            }
        }

    }
}
