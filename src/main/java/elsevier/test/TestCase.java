package elsevier.test;

import org.junit.Test;
import elsevier.main.Utils.*;


public class TestCase extends BaseTest {

    @Test
    public void TestCase_UserInfoResponseStatus() {
        //Verify the User Info response status returned. Check Status Code is 200.
        res = AppUtils.getResponseByPath(conf.userInfo + "?" + conf.parameterAccessToken);
        jp = AppUtils.getJSonPath(res);
        testUtils.checkStatusIs200(res);
    }

    @Test
    public void TestCase_UsersInfoAndCheckAssertion() {
        // Verify that the User Info is correct.
        res = AppUtils.getResponseByPath(conf.userInfo + "?" + conf.parameterAccessToken);
        jp = AppUtils.getJSonPath(res);
        //System.out.println(jp.getString("data.login"));
        System.out.println(testUtils.getLogin(jp));
        testUtils.checkLoginIsAdib(jp);
    }

    @Test
    public void TestCase_UserHistoryResponseStatus() {
        //Verify the User History response status returned. Check Status Code is 200.
        res = AppUtils.getResponseByPath(conf.userHistory + "?" + conf.parameterAccessToken);
        jp = AppUtils.getJSonPath(res);
        testUtils.checkStatusIs200(res);
    }

    @Test
    public void TestCase_ShortenResponseStatus() {
        //Verify the  Shorten response status returned. Check Status Code is 200.
        res = AppUtils.getResponseByPath(conf.shorten + "?" + conf.parameterAccessToken + "&" + conf.longURL + conf.googleLongURL);
        jp = AppUtils.getJSonPath(res);
        testUtils.checkStatusIs200(res);

    }

    @Test
    public void TestCase_GetUserHistory() {
        // Print the User History results. Test
        res = AppUtils.getResponseByPath(conf.userHistory + "?" + conf.parameterAccessToken);
        jp = AppUtils.getJSonPath(res);
        System.out.println(testUtils.getUserHistoryResult(jp));
    }

    @Test
    public void TestCase_404ResponseStatus() {
        //Verify the  Shorten response status not returned. Check Status Code is 404.
        res = AppUtils.getResponseByPath(conf.wrongShorten + "?" + conf.parameterAccessToken + "&" + conf.longURL + conf.googleLongURL);
        jp = AppUtils.getJSonPath(res);
        testUtils.checkStatusIs404(res);

    }

    @Test
    public void TestCase_CheckShortenStatus() {
        //Verify the Shorten response status returned. Check Status Code is 200.
        res = AppUtils.getResponseByPath(conf.shorten + "?" + conf.parameterAccessToken + "&" + conf.longURL + conf.googleLongURL);
        jp = AppUtils.getJSonPath(res);
        testUtils.checkStatusOK(jp);
    }

    @Test
    public void TestCase_CheckShortenLongURL() {
        //Verify the Shorten  Long URL.
        res = AppUtils.getResponseByPath(conf.shorten + "?" + conf.parameterAccessToken + "&" + conf.longURL + conf.googleLongURL);
        jp = AppUtils.getJSonPath(res);
        System.out.println(conf.googleLongURL);
        testUtils.checkShortenLongURL(jp);
    }


}
