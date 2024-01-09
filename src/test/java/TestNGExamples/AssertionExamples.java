package TestNGExamples;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class AssertionExamples {

	public static WebDriver driver;
	public SoftAssert asserts;
	
	@BeforeClass
	public void openapplication() {
		
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
	}
	
	@Test(priority=1)
	public void LoginFunctionality() {
		driver.findElement(By.id("username")).sendKeys("mahesh23456");
		driver.findElement(By.id("password")).sendKeys("India@123");
	}
	
	@Test(priority=2)
	public void ClickLoginButton() {
		driver.findElement(By.id("login")).click();
	}
	
	@Test(priority=3)
	public void Validations() {
		String exp_result="Adactin.com - Search Hotel11";
		String Act_result=driver.getTitle();
		
		asserts=new SoftAssert();
		
		if(Act_result.equals(exp_result)) {
			
			asserts.assertTrue(true);
			System.out.println("testcase is passed");
		}else
		{
			asserts.assertTrue(false);
			System.out.println("testcase is failed");
			System.out.println("assertions");
		}
	}
	
	@AfterClass
	public void closeapplication() {
		driver.close();
	}

}
