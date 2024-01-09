package TestNGExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Parameterization {
	
	public static WebDriver driver;
	public SoftAssert asserts;
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void openApplication(String br,String url) {
		
		if(br.equals("chrome")) {
		driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(br.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.get(url);
	}
	
	@Test(priority=1,groups= {"Login"})
	public void LoginFunctionality() {
		driver.findElement(By.id("username")).sendKeys("mahesh23456");
		driver.findElement(By.id("password")).sendKeys("India@123");
	}
	
	@Test(priority=2,groups= {"Registration"})
	public void ClickLoginButton() {
		driver.findElement(By.id("login")).click();
	}
	
	@Test(priority=3,groups= {"ForgotPassword"})
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
	public void closeApplication() {
		
		driver.close();
	}

}
