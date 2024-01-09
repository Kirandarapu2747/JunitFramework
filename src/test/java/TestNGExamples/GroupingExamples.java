package TestNGExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupingExamples {
	
	public static WebDriver driver;
	@Test(priority=1,groups= {"regression"})
	public void openApplication() {
		
		driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
	}
	
	@Test(priority=2,groups= {"sanity"})
	public void LoginFunctionality() {
		
		driver.findElement(By.id("username")).sendKeys("mahesh23456");
		driver.findElement(By.id("password")).sendKeys("India@123");
		
	}
	@Test(priority=3,groups= {"smoke"})
	public void ClickLoginBtn() {
		driver.findElement(By.id("login")).click();
	}

}
