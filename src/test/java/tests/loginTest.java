package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


import pages.landingPage;
import pages.loginPage;
import pages.registerationPage;
import testBase.Base;

public class loginTest extends Base {

	@Test(priority = 1)
	public void moveToSignInPage () {

		landingPageObject = new landingPage(Base.driver);
		landingPageObject.validateLandingPage();
		landingPageObject.navigateToSignInPage();	
	}

	@Test(priority = 2)
	public void moveToRegisterationPage () {

		loginPageObject = new loginPage(Base.driver);
		loginPageObject.validateLoginPageDisplay();
	}

	@Test(priority = 3)
	public void fillRegisterationForm() throws IOException, ParseException {

		loginPageObject.enterUserName("Second_User");
		loginPageObject.enterPassword("Second_User");
		loginPageObject.clickLogin();
	}
	

}
