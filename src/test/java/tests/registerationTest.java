package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


import pages.landingPage;
import pages.loginPage;
import pages.registerationPage;
import testBase.Base;

public class registerationTest extends Base {

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
		loginPageObject.navigateToRegisterationPage();
	}

	@Test(priority = 3)
	public void fillRegisterationForm() throws IOException, ParseException {

		registerationPageObject = new registerationPage(Base.driver);
		registerationPageObject.registerationPageDisplay();
		registerationPageObject.enterUserName("First_User");
		registerationPageObject.enterLastName("First_User");
		registerationPageObject.enterEmail("First_User");
		registerationPageObject.enterConfirmedEmail("First_User");
		registerationPageObject.enterPassword("First_User");
		registerationPageObject.selectBirthDay("First_User");
		registerationPageObject.selectBirthMonth("First_User");
		registerationPageObject.selectBirthYear("First_User");
		registerationPageObject.selectFemaleGender("First_User");
	}

	@Test(priority = 4)
	public void submitData() {

		registerationPageObject.signUpCreatingAccount();
	}
	

}
