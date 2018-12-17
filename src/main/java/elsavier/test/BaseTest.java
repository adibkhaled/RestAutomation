package elsavier.test;

import elsavier.test.TestUtils.*;

import org.junit.After;
import org.junit.Before;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import elsavier.main.Utils.*;



public class BaseTest {

    public Response res = null; //Response
    public JsonPath jp = null; //JsonPath

    //Instantiate a Helper Test Methods (testUtils) Object
    TestUtils testUtils = new TestUtils();

    @Before
    public void setup (){
        //Test Setup
        AppUtils.setBaseURI("https://api-ssl.bitly.com"); //Setup Base URI
        AppUtils.setBasePath("v3"); //Setup Base Path
        AppUtils.setContentType(ContentType.JSON); //Setup Content Type
    }

    @After
    public void afterTest (){
        //Reset Values
        AppUtils.resetBaseURI();
        AppUtils.resetBasePath();
    }

}
