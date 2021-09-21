package testBase;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pages.landingPage;
import pages.loginPage;
import pages.registerationPage;


public class Base {

	public static WebDriver driver;
	public landingPage landingPageObject = null;
	public loginPage loginPageObject = null;
	public registerationPage registerationPageObject = null;

	@BeforeClass
	public void webDriver() throws InterruptedException  
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Resources/chromedriver");
		System.out.println("Entering the desired capabilities");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("platform", "Mac OSX 11.1");
		caps.setCapability("resolution", "1024x768");
		Thread.sleep(5000);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://developers.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterClass
	public static void stopDriver() {
		
		driver.quit();
	}

}
