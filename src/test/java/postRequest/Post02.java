package postRequest;

import baseURL.DummyRestApiBaseURL;
import baseURL.GoRestApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.DummyExpectedDataPojo;
import pojoDatas.DummyRestApiPojo;
import testData.GoRestApiTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends DummyRestApiBaseURL {

/*

   Given

        //http://dummy.restapiexample.com/api/v1/create
    And
        Request Body olarak aşağıdaki pattern de body gönderiniz
      {
  "name": "Kemal Sunal",
  "salary": "40000",
  "age": "27"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
           {
    "status": "success",
    "data": {
  "name": "Kemal Sunal",
  "salary": "40000",
  "age": "27",

    },
    "message": "Successfully! Record has been added."
}
*/
@Test
    public void post02(){
    //Set the URL
    specification.pathParams("createPath","create");
//Set the expected data
    DummyRestApiPojo dummyRestApiPojo = new DummyRestApiPojo("Kemal Sunal","40000","27");

    DummyExpectedDataPojo dummyExpectedDataPojo = new DummyExpectedDataPojo("success",dummyRestApiPojo,"Successfully! Record has been added.");
//Normalde Api Doc.  da bizden Basic Authorization istenmiyor ama syntax öğrenmek için biz yine de kullanacağız.
//Send the request
  Response response= given(specification)
           .contentType(ContentType.JSON)
           .auth().basic("admin","password1234")
           .when()
           .body(dummyRestApiPojo)
          .post("/{createPath}");
  response.prettyPrint();

  //Do the assertion
    DummyExpectedDataPojo actualData= response.as(DummyExpectedDataPojo.class);
    System.out.println("actualData = " + actualData);

    assertEquals(dummyExpectedDataPojo.getStatus(),actualData.getStatus());
    assertEquals(dummyExpectedDataPojo.getMessage(),actualData.getMessage());
    assertEquals(dummyExpectedDataPojo.getData().getAge(),actualData.getData().getAge());
    assertEquals(dummyExpectedDataPojo.getData().getName(),actualData.getData().getName());
    assertEquals(dummyExpectedDataPojo.getData().getSalary(),actualData.getData().getSalary());


}


}
