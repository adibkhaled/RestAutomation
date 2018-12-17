package elsavier.test.TestUtils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;

public class TestUtils {

    //Verify the http response status returned. Check Status Code is 200?
    public void checkStatusIs200 (Response res) {
        Assert.assertEquals(res.getStatusCode(), 200);
    }

    //Get user name from login
    public String getUser (JsonPath jp) {
        String userList = jp.getString("data.login");
        return userList;
    }

    public void checkUserIsAdib (JsonPath jp){
        Assert.assertEquals(jp.getString("data.login"), "adibkhaled");
    }


}
