package Selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTestingModular {
	public static String browser;
	static WebDriver driver;
	
	public static void main(String[] args) {
		SeleniumTestingModular test = new SeleniumTestingModular();
		test.setBrowser("Firefox");
		test.setBrowserConfig();
		test.verifyTitle();
	}
	
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	public void setBrowserConfig() {
		String projectLocation = System.getProperty("user.dir");
		
		if(browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void verifyTitle() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String expectedTitle = "OrangeHRM";
		String actualTitle = "";
		
		actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Assert passed");
	}
}
