package TestNGExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Sample003 {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void openApplication() {
		
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
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
	public void Result() {
		String exp_result="Adactin.com - Search Hotel11";
		String Act_result=driver.getTitle();
		
		if(Act_result.equals(exp_result)) {
			System.out.println("testcase is passed");
		}else
		{
			System.out.println("testcase is failed");
		}
	}
	
	
	@Test (priority=3,dependsOnMethods= {"ClickLoginButton"})
	public void clickLogout() {
		
		driver.findElement(By.linkText("Logout")).click();
	}
	@AfterTest
	public void clickLoginpagelink() {
		driver.findElement(By.linkText("Click here to login again")).click();
	}
	
	@AfterSuite()
	public void clickLink() {
		driver.findElement(By.linkText("New User Register Here")).click();
	}

}
