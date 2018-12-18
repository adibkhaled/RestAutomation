package elsavier.test.TestUtils;

import elsavier.config.Configuration;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;


public class TestUtils {

    //Instantiate a Helper Test Methods (conf) Object
    Configuration conf = new Configuration();

    //Verify the http response status returned. Check Status Code is 200?
    public void checkStatusIs200(Response res) {
        Assert.assertEquals(res.getStatusCode(), 200);
    }

    //Verify the http response status returned. Check Status Code is 200?
    public void checkStatusIs404(Response res) {
        Assert.assertEquals(res.getStatusCode(), 404);
    }

    //Get user name from login
    public String getLogin(JsonPath jp) {
        String userList = jp.getString("data.login");
        return userList;
    }

    // Check the name of login
    public void checkLoginIsAdib(JsonPath jp) {
        Assert.assertEquals(jp.getString("data.login"), "adibkhaled");
    }

    // Check the user history count
    public String getUserHistoryResult(JsonPath jp) {
        String getResult = jp.getString("data.result_count");
        return " Total User History: " + getResult;
    }


    // Check the Status of Shorten
    public void checkStatusOK(JsonPath jp) {
        Assert.assertEquals(jp.getString("status_txt"), "OK");
    }

    // Check the Long URL
    public void checkShortenLongURL(JsonPath jp) {
        Assert.assertEquals(jp.getString("data.long_url"), conf.googleLongURL);
    }


}
