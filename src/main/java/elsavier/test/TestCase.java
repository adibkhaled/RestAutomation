package elsavier.test;

import org.junit.Test;
import elsavier.main.Utils.*;



public class TestCase extends BaseTest{

    @Test
    public void TestCase_UserInfoResponseStatus() {
        //Verify the http User Info response status returned. Check Status Code is 200?
        res = AppUtils.getResponseByPath("/user/info?access_token=8b6d8d4e8da17ffcade3e29e1c14df0eb84ff7ba");
        jp = AppUtils.getJSonPath(res);
        testUtils.checkStatusIs200(res);
    }

    @Test
    public void TestCase_GetUsersAndCheckAssertion() {
        res = AppUtils.getResponseByPath("/user/info?access_token=8b6d8d4e8da17ffcade3e29e1c14df0eb84ff7ba");
        jp = AppUtils.getJSonPath(res);
        //System.out.println(jp.getString("data.login"));
        System.out.println(testUtils.getUser(jp));
        testUtils.checkUserIsAdib(jp);
    }


    public void TestCase_UserHistoryResponseStatus() {
        //Verify the http User History response status returned. Check Status Code is 200?
        res = AppUtils.getResponseByPath("/user/link_hostory?access_token=8b6d8d4e8da17ffcade3e29e1c14df0eb84ff7ba");
        jp = AppUtils.getJSonPath(res);
        testUtils.checkStatusIs200(res);
    }

    public void TestCase03_GetLinkHistory() {
        res = AppUtils.getResponseByPath("/user/link_hostory?access_token=8b6d8d4e8da17ffcade3e29e1c14df0eb84ff7ba");
        jp = AppUtils.getJSonPath(res);
        System.out.println("Data: " + jp.get("data"));
    }


//    public void T03_GetAndroidModelPackageOptions() {
//       res = AppUtils.getResponseByPath("/gen/clients/android");
//       jp = AppUtils.getJSonPath(res);
//
//       System.out.println("Opt: " + jp.get("modelPackage.opt"));
//       System.out.println("Description: " + jp.get("modelPackage.description"));
//       System.out.println("Type: " + jp.get("modelPackage.type"));
//   }

}
