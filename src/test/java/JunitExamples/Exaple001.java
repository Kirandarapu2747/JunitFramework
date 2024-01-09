package JunitExamples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exaple001 {
	
	public static WebDriver driver;
	
	@Before
	public void openapplication() {
		
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test()
	public void LoginFunctionality() {
		
		driver.findElement(By.id("username")).sendKeys("mahesh23456");
		driver.findElement(By.id("password")).sendKeys("India@123");
		driver.findElement(By.id("login")).click();
	}
	@Test
	public void print() {
		System.out.println("2nd testcases");
	}
	
	@After
	public void CloseApplication() {
		driver.close();
	}
	

}
