package Selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise {
	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		WebDriver driver;
		WebDriverWait wait;
		
		System.setProperty("webdriver.gecko.driver", projectLocation+ "\\lib\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		
		String URL = "https://www.sekolahqa.com/";
		driver.get(URL);
		
		String title = driver.getTitle();
		int titleLength = title.length();
		
		System.out.println("Page Title : " +title);
		System.out.println("Title length : " +titleLength);
		
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(URL, actualURL);
		
		String pageSource = driver.getPageSource();
		int pageSourceLength = pageSource.length();
		
		System.out.println("Page Source length : " +pageSourceLength);
		
		driver.quit();
	}
}
