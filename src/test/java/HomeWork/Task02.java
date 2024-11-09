package HomeWork;

import baseURL.Homework_02;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Task02 extends Homework_02 {
    /*

    Given
	   	    https://dummy.restapiexample.com/api/v1/employee/1
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
    {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}
     */

    @Test
    public void test() {

        specification.pathParams("firstPath", "employee", "secondPath", "1");

        Response response = given().spec(specification).when().get("/{firstPath}/{secondPath}");
        response.prettyPrint();

         response.then().assertThat().statusCode(200)
                .body("status", equalTo("success"),
                "data.id", equalTo(1),
                "data.employee_name", equalTo("Tiger Nixon"),
                "data.employee_salary", equalTo(320800),
                "data.employee_age", equalTo(61),
                "data.profile_image", equalTo(""),
                "message", equalTo("Successfully! Record has been fetched."));


    }
}
