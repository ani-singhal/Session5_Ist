package session5concepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestNG {

	WebDriver driver;

	@BeforeTest
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	@Test
	public void Itest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com ");
		driver.findElement(By.name("password")).sendKeys("abc123");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("login"))));
		driver.findElement(By.name("login")).click();
		WebElement homepage =driver.findElement(By.xpath("//h2[text()=' Dashboard ']"));
	
		Assert.assertEquals("HomePage not Found ", "Dasboard", homepage);
}
	
	@Test
	public void Itest2() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com ");
		driver.findElement(By.name("password")).sendKeys("abc1234");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("login"))));
		driver.findElement(By.name("login")).click();
		WebElement homepage =driver.findElement(By.xpath("//h2[text()=' Dashboard ']"));
	
		Assert.assertEquals("HomePage not Found ", "Dasboard", homepage);
}
	
	@AfterTest
	public void Itear() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	
}	
}