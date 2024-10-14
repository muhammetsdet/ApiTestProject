package getRequests;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get03 extends JsonPlaceHolderBaseURL {
        /*
        Given
            https://jsonplaceholder.typicode.com/todos/2
        When
             User Sends Request with GET Method
        Then
            Assert that Status Code is "200"
        And
            Assert that Content Type is "application/json"
        And
            Verify that the title is "quis ut nam facilis et officia qui".,
        And
            Verify that "completed" is false.
        And
            Verify that "userId" is 1

     */

    //1 Step: Set the URL
    //2 Step: Set the expected data(ignored)
    //3 Step: Send the Request
    //4 Step: Do the Assertion
    @Test
    public void get03() {
        //Given
        //            https://jsonplaceholder.typicode.com/todos/2

        specification.pathParams("todosPath", "todos", "IdPath", "2");

        //When
        //             User Sends Request with GET Method
        Response response = given().spec(specification).when().get("/{todosPath}/{IdPath}/");

        response.prettyPrint();

//    Then
//    Assert that Status Code is "200"
        response.then().assertThat().statusCode(200).contentType("application/json");

// And
//Verify that the title is "quis ut nam facilis et officia qui".,
        response
                .then()
                .assertThat()
                .body("title", Matchers.equalTo("quis ut nam facilis et officia qui"), "cmpleted", Matchers.equalTo(false), "userId", Matchers.equalTo(1));


    }


}
