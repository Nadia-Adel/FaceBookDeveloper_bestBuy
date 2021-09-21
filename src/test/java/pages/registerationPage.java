package pages;

import static org.testng.Assert.assertTrue;
import java.io.IOException;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.Base;
import testBase.GetUserFromJson;

public class registerationPage {


	@FindBy(xpath = "//*[@id='content']/div[2]/div/div[1]/div[1]")
	public WebElement createNewAccountTitle ;

	@FindBy(xpath = "//input[@name='firstname']")
	public WebElement firstNameTextField ;

	@FindBy(xpath = "//input[@name='lastname']")
	public WebElement lastNameTextField ;

	@FindBy(xpath = "//input[@name='reg_email__']")
	public WebElement phoneEmailTextField ;

	@FindBy(xpath = "//input[@name='reg_email_confirmation__']")
	public WebElement phoneEmailConfirmationTextField ;
	
	@FindBy(xpath = "//input[@type='password']")
	public WebElement passwordTextField ;
	
	@FindBy(id = "day")
	public WebElement dayOfBirthDropDown ;

	@FindBy(id = "month")
	public WebElement monthOfBirthDropDown ;

	@FindBy(id = "year")
	public WebElement yearOfBirthDropDown ;

	@FindBy(xpath = "//input[@value='1']")
	public WebElement femaleGenderRadioButton ;

	@FindBy(xpath = "//button[@name='websubmit']")
	public WebElement signUpButton ;


	public registerationPage(WebDriver driver) {

		driver = Base.driver;
		PageFactory.initElements(driver, this);
	}


	public void registerationPageDisplay() {

		assertTrue(createNewAccountTitle.isDisplayed());
		assertTrue(signUpButton.isDisplayed());
	}

	public void enterUserName (String user) throws IOException, ParseException {

		firstNameTextField.isDisplayed();
		firstNameTextField.sendKeys(GetUserFromJson.getUsername(user));
	}

	public void enterLastName (String user) throws IOException, ParseException {

		lastNameTextField.isDisplayed();
		lastNameTextField.sendKeys(GetUserFromJson.getLastname(user));
	}
	
	public void enterEmail (String user) throws IOException, ParseException {

		phoneEmailTextField.isDisplayed();
		phoneEmailTextField.sendKeys(GetUserFromJson.getEmail(user));
	}
	
	public void enterConfirmedEmail (String user) throws IOException, ParseException {

		phoneEmailConfirmationTextField.isDisplayed();
		phoneEmailConfirmationTextField.sendKeys(GetUserFromJson.getEmail(user));
	}
	
	public void enterPassword (String user) throws IOException, ParseException {

		passwordTextField.isDisplayed();
		passwordTextField.sendKeys(GetUserFromJson.getpassword(user));
	}
	
	public void selectBirthDay (String user) throws IOException, ParseException {

		dayOfBirthDropDown.isDisplayed();
		dayOfBirthDropDown.sendKeys(GetUserFromJson.getDay(user));
	}
	
	
	public Select getMonthSelect() {
		  return new Select(monthOfBirthDropDown);
		}
	
	public void selectBirthMonth (String user) throws IOException, ParseException {

		monthOfBirthDropDown.isDisplayed();
		getMonthSelect().selectByValue(GetUserFromJson.getMonth(user));
	}
	
	public void selectBirthYear (String user) throws IOException, ParseException {

		yearOfBirthDropDown.isDisplayed();
		yearOfBirthDropDown.sendKeys(GetUserFromJson.getYear(user));
	}
	
	public void selectFemaleGender (String user) throws IOException, ParseException {

		femaleGenderRadioButton.isDisplayed();
		femaleGenderRadioButton.click();
	}
	
	public void signUpCreatingAccount() {

		assertTrue(signUpButton.isDisplayed());
		signUpButton.click();
	}
}
