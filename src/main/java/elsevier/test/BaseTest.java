package elsevier.test;

import elsevier.test.TestUtils.*;
import elsevier.config.Configuration;

import org.junit.After;
import org.junit.Before;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import elsevier.main.Utils.*;


public class BaseTest {

    public Response res = null; //Response
    public JsonPath jp = null; //JsonPath

    //Instantiate a Helper Test Methods (testUtils) Object
    TestUtils testUtils = new TestUtils();
    //Instantiate a Helper Test Methods (conf) Object
    Configuration conf = new Configuration();


    @Before
    public void setup() {
        //Test Setup
        AppUtils.setBaseURI(conf.baseURL); //Setup Base URI
        AppUtils.setBasePath(conf.basePath); //Setup Base Path
        AppUtils.setContentType(ContentType.JSON); //Setup Content Type
    }

    @After
    public void afterTest() {
        //Reset Values
        AppUtils.resetBaseURI();
        AppUtils.resetBasePath();
    }

}
