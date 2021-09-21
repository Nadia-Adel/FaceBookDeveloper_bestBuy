package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class workSheetPage {
	
	@FindBy(xpath = "//*/main/div[2]/div")
	public List<WebElement> questionsSection ;
	
	@FindBy(xpath = "//*/main/div[1]/div/a")
	public WebElement startPracticeBtn ;
	
	public workSheetPage(WebDriver driver) {

		driver = Base.driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkTimeSheetPageDisplay() {
		
		startPracticeBtn.isDisplayed();
	}
	
	public void countQuestionsNo() {
		
		System.out.println("No. of questions displayed on the screen: " + questionsSection.size());
		
	}

}
