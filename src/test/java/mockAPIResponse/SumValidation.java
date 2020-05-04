package mockAPIResponse;

import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    //6. Verify if Sum of all Course prices matches with Purchase Amount
    @Test
    public void sumOfCourses()
    {
        JsonPath js = new JsonPath(payload.CoursePrice());
        int count = js.getInt("courses.size()");
        int sum = 0;
        for(int i=0;i<count;i++)
        {
            String courseTitles = js.get("courses["+i+"].title");
            int coursePrice = js.getInt("courses["+i+"].price");
            int copiesCount = js.getInt("courses["+i+"].copies");
            int amount = coursePrice * copiesCount;
            System.out.println(amount);
            sum = sum + amount;
        }
        System.out.println(sum);
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum,purchaseAmount);
    }
}
