package files;

public class payload {

    public static String AddPlace()
    {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -79.725487,\n" +
                "    \"lng\": 43.684170\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Test Location 1\",\n" +
                "  \"phone_number\": \"+1-123-456-7890\",\n" +
                "  \"address\": \"Brampton, Ontario\",\n" +
                "  \"types\": [\n" +
                "    \"City\",\n" +
                "    \"Peel Region\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"ENGLISH\"\n" +
                "}\n";

    }

    public static String CoursePrice()
    {
        return "{\n" +
                "\"dashboard\": {\n" +
                "\"purchaseAmount\": 1160,\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "},\n" +
                "\"courses\": [\n" +
                "{\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 6\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Cypress\",\n" +
                "\"price\": 40,\n" +
                "\"copies\": 4\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"RPA\",\n" +
                "\"price\": 45,\n" +
                "\"copies\": 10\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"API\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 5\n" +
                "}\n" +
                "]\n" +
                "}";
    }
    public static String AddBook(String isbn, String aisle)
    {
       String payloadAddBook =  "{\n" +
               "\"name\":\"API Automation\",\n" +
               "\"isbn\":\""+isbn+"\",\n" +
               "\"aisle\":\""+aisle+"\",\n" +
               "\"author\":\"Kaushik\"\n" +
               "}";
       return payloadAddBook;
    }
}
