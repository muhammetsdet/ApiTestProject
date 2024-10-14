package getRequests;

import baseURL.DummyRestApiBaseURL;
import org.junit.Test;

public class Get09 extends DummyRestApiBaseURL {

    /*

    Given
      https://dummy.restapiexample.com/api/v1/employees
 When
       User Sends Request with GET Method
    Then
       Assert that Status Code is "200"
    And
       User verifies that the last employee's name is "Doris Wilder"
    And
       User verifies that employee 6's salary is 372000
    And
       User verifies that the ages of employees includes 21, 23 and 59

 */


    @Test
    public void get09(){

       specification.pathParams("employeePath","employees");

//2- Set the expected data --> Başka bir classta expected dataları setleyelim




    }



}
