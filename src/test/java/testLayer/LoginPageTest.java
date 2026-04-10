package testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseTest;
import pageLayer.LoginPage;
import utilityLayer.DriverManager;

public class LoginPageTest extends BaseTest {
	@Test
	public void validateLoginFunctionality() {

		LoginPage loginpage = new LoginPage();
		loginpage.loginFunctionality("prafulp1010@gmail.com", "Pr@ful0812");
		Assert.assertEquals(DriverManager.getDriver().getTitle(), "Free CRM");
	}


}
