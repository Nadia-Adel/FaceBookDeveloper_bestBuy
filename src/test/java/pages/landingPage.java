package pages;

import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;


public class landingPage {
	
	@FindBy(className  = "_8_3v")
	public WebElement landingPageTitle ;
	
	@FindBy(linkText = "Log In")
	public WebElement signInButton ;

	public landingPage(WebDriver driver) {

		driver = Base.driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validateLandingPage() {
		
		assertTrue(landingPageTitle.isDisplayed());
		assertTrue(signInButton.isDisplayed());
	}
	
	public void navigateToSignInPage() {
		
		signInButton.click();
	}
	
}
