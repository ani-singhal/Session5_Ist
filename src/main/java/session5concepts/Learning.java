package session5concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Learning {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void LHandles() {
		
		String handle1= driver.getWindowHandle();
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
		driver.findElement(By.xpath("//input[@id='ybar-search']")).click();
		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
	//Select sel = new Select(driver.getWindowHandles());
		
		Set<String> mywindows =driver.getWindowHandles();
		//System.out.println(mywindows);
		
		
		for(String i : mywindows){
			System.out.println("My Ist  " + i);
			
		}

		driver.switchTo().window(driver.getWindowHandle());
		System.out.println("After switching   "+driver.getWindowHandle() );
	}

}
