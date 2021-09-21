package pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;
import testBase.GetUserFromJson;

public class loginPage {

	public static String secondLessonText ;

	@FindBy(xpath = "//*[@id='login_link']/div[3]/a")
	public WebElement createNewAccount ;

//	@FindBy(xpath = "//*[@id='email']")
	@FindBy(id = "email")
	public WebElement emailLoginTextField ;

//	@FindBy(xpath = "//*[@id='pass']")
	@FindBy(id = "pass")
	public WebElement passwordLoginTextField ;
	
	@FindBy(id = "loginbutton")
	public WebElement loginButton ;

	public loginPage(WebDriver driver) {

		driver = Base.driver;
		PageFactory.initElements(driver, this);
	}

	public void validateLoginPageDisplay() {

		assertTrue(loginButton.isDisplayed());
		assertTrue(createNewAccount.isDisplayed());
	}

	public void navigateToRegisterationPage() {

		createNewAccount.click();
	}

	public void enterUserName(String user) throws IOException, ParseException {

		assertTrue(emailLoginTextField.isDisplayed());
		emailLoginTextField.sendKeys(GetUserFromJson.getEmail(user));
	}
	
	public void enterPassword(String user) throws IOException, ParseException {

		assertTrue(passwordLoginTextField.isDisplayed());
		passwordLoginTextField.sendKeys(GetUserFromJson.getpassword(user));
	}
	
	public void clickLogin() {
		
		assertTrue(loginButton.isDisplayed());
		loginButton.click();
	}
	
	
}
