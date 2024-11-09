package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Homework_03 {

protected RequestSpecification specification;

@Before
    public void setUpBaseURL(){

    specification= new RequestSpecBuilder().setBaseUri("https://swapi.dev/api").build();



}

}
