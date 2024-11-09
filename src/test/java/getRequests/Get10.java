package getRequests;

import baseURL.ZippopotamBaseURL;
import org.junit.Test;

public class Get10 extends ZippopotamBaseURL {
    /*
     Given
            http://api.zippopotam.us/TR/34010
        When
            User Sends Request with GET Method
        Then
            Assert that Status Code is "200"
        And
            Verify that the response body is like this


    {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
              {
                "place name": "Maltepe Mah.",
                "longitude": "32.3609",
                "state": "İstanbul",
                "state abbreviation": "34",
                "latitude": "40.1589"
              }
              ]
    }
     */

    @Test
    public void get10(){

        specification.pathParams("countryPath","TR", "postalCode","34010");

        //Set the expected date



    }


}
