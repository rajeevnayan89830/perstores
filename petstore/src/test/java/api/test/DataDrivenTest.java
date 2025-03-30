package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviderUtil;
import io.restassured.response.Response;

public class DataDrivenTest {
@Test(priority=1,dataProvider="data",dataProviderClass=api.utilities.DataProviderUtil.class)
public void dduserpost(String userid,String fName,String lName,String uEmail,String uPwd,String phone) {
	User userpayload=new User();
	userpayload.setId(Integer.parseInt(userid));
	userpayload.setFirstname(fName);
	userpayload.setLastname(lName);
	userpayload.setEmail(uEmail);
	userpayload.setPassword(uPwd);
	userpayload.setPhone(phone);
	Response response=UserEndPoints.createUser(userpayload);
	Assert.assertEquals(response.getStatusCode(),200);
}
@Test(priority=2,dataProvider="User",dataProviderClass=api.utilities.DataProviderUtil.class)
public void deleteuserbyusername(String UserName) {
	Response response=UserEndPoints.deleteUser(UserName);
	Assert.assertEquals(response.getStatusCode(),200);
}
}