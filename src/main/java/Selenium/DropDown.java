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

public class DropDown {
	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		WebDriver driver;
		WebDriverWait wait;
		
		System.setProperty("webdriver.gecko.driver", projectLocation+ "\\lib\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		
		driver.get("https://id-id.facebook.com/r.php");
		
		
		driver.findElement(By.id("u_0_n")).sendKeys("Shoyo");
		driver.findElement(By.id("u_0_p")).sendKeys("Hinata");
		
		driver.findElement(By.id("u_0_s")).sendKeys("shoyo.hinata@email.com");
		
		driver.findElement(By.id("password_step_input")).sendKeys("112233");
		
		WebElement dateDropDown = driver.findElement(By.id("day"));
		WebElement monthDropDown = driver.findElement(By.id("month"));
		WebElement yearDropDown = driver.findElement(By.id("year"));
		
		Select date = new Select(dateDropDown);
		Select month = new Select(monthDropDown);
		Select year = new Select(yearDropDown);
		
		date.selectByIndex(19);
		month.selectByValue("6");
		year.selectByVisibleText("1988");
		
		WebElement female = driver.findElement(By.id("u_0_4"));
		WebElement male = driver.findElement(By.id("u_0_5"));
		WebElement special = driver.findElement(By.id("u_0_6"));
		
		female.click();
		male.click();
		special.click();
		
		WebElement otherDropDown = driver.findElement(By.name("preferred_pronoun"));
		
		Select otherGender = new Select(otherDropDown);
		
		otherGender.selectByValue("6");
		
//		driver.close();
	}
}
