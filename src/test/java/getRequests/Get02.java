package getRequests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Get02 {

      /*
    Given
        https://restful-booker.herokuapp.com/booking/78100

    When
        User Sends Request with GET Method
    Then
        Assert that Status Code is "404"
    And
        Assert that Response Body is "Not Found"
    And
        Assert that in the Headers, Via is "1.1 vegur".
    And
        Assert that the response body does not have "Clarusway"
    oath
        Assert that the Status Line is "HTTP/1.1 404 Not Found".

     */

    /*
    1-Set the URL
    2-Set the expected data
    3-Send the request
    4-Do the Assertion
     */

    @Test
    public void get02() {
//1-Set the URL
        String URL = "https://restful-booker.herokuapp.com/booking/78100";
//2-Set the expected data (ignored)

        // 3-Send the request
        Response response = given().when().get(URL);

        response.prettyPrint();

        // Then
        //        Assert that Status Code is "404"
        response.then().assertThat().statusCode(404);

        //    And
        //        Assert that Response Body is "Not Found"

        //Response body mutlaka javanın anlayacağı formata çeivrmeli ve daha sonra assertion yapımalı.
        String responseBodyStr = response.asString();
        System.out.println("responseBodyStr= " + responseBodyStr);
        assertTrue(responseBodyStr.contains("Not Found"));

        //    And
        //        Assert that in the Headers, Via is "1.1 vegur".
        System.out.println(response.getHeaders());
        System.out.println(response.getHeader("Via"));

        assertEquals("1.1 vegur", response.getHeader("Via"));

        //    And
        //        Assert that the response body does not have "Clarusway"
        assertFalse(responseBodyStr.contains("Clarusway"));

        //    oath
        //        Assert that the Status Line is "HTTP/1.1 404 Not Found".
        response.then().assertThat().statusLine("HTTP/1.1 404 Not Found");

    }

}
