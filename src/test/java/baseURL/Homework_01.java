package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Homework_01 {

protected RequestSpecification specification;

@Before
    public void setUpBaseURL(){

    specification= new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();



}

}
