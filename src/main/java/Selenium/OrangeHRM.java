package Selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM {
	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		WebDriver driver;
		WebDriverWait wait;
		
		System.setProperty("webdriver.gecko.driver", projectLocation+ "\\lib\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		
		String URL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(URL);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
//		String actualVerifyLogin = driver.findElement(By.id("welcome")).getText();
//		String expectedVerifyLogin = "Welcome Linda";
//		Assert.assertEquals(expectedVerifyLogin, actualVerifyLogin);
		
//		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
//		driver.findElement(By.id("menu_admin_UserManagement")).click();
//		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
		Actions action = new Actions(driver);
		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		action.moveToElement(admin).perform();
		
		WebElement user = driver.findElement(By.id("menu_admin_UserManagement"));
		action.moveToElement(user).perform();
		
		WebElement userSearch = driver.findElement(By.id("menu_admin_viewSystemUsers"));
		action.moveToElement(userSearch).click();
		
		WebElement userRole = driver.findElement(By.id("searchSystemUser_userType"));
		Select role = new Select(userRole);
		role.selectByVisibleText("ESS");
		
		driver.findElement(By.id("searchBtn")).click();
		
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("john.s");
		
		driver.findElement(By.id("searchBtn")).click();
		
		String actualVerifyUsername1 = driver.findElement(By.linkText("john.s")).getText();
		String expectedVerifyUsername1 = "john.s";
		Assert.assertEquals(expectedVerifyUsername1, actualVerifyUsername1);
		
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("linda_anderson");
		
		driver.findElement(By.id("searchBtn")).click();
		
		String actualVerifyUsername2 = driver.findElement(By.linkText("linda_anderson")).getText();
		String unexpectedVerifyUsername2 = "john.s";
		Assert.assertNotEquals(unexpectedVerifyUsername2, actualVerifyUsername2);
		
		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		driver.findElement(By.id("menu_leave_applyLeave")).click();
		
		WebElement leaveTypeDropDown = driver.findElement(By.id("applyleave_txtLeaveType"));
		Select leaveType = new Select(leaveTypeDropDown);
		leaveType.selectByValue("1");
		
		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2020-10-01");
		driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2020-10-02");
		
		WebElement partialDaysDropDown = driver.findElement(By.id("applyleave_partialDays"));
		Select partialDays = new Select(partialDaysDropDown);
		partialDays.selectByIndex(1);
		
		driver.findElement(By.id("applyBtn")).click();
		
//		driver.findElement(By.id("welcome")).click();
//		driver.findElement(By.linkText("Logout")).click();
//		
//		String actualVerifyLogout = driver.findElement(By.id("logInPanelHeading")).getText();
//		String expectedVerifyLogout = "LOGIN Panel";
//		Assert.assertEquals(expectedVerifyLogout, actualVerifyLogout);
		
//		driver.close();
	}
}
