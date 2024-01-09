package TestNGExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupingTestcases {
	
	public static WebDriver driver;
	
	@Test(priority=1,groups= {"smoke"})
	public void OpenApplication() {
		
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
	}
	
	@Test(priority=2,groups= {"regression"})
	public void LoginFunctionality() {
		driver.findElement(By.id("username")).sendKeys("mahesh23456");
		driver.findElement(By.id("password")).sendKeys("India@123");
		
	}
	
	@Test(priority=3,groups= {"smoke","regression"})
	public void ClickLoginButton() {
		driver.findElement(By.id("login")).click();
	}

}
