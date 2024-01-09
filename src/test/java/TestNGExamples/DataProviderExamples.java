package TestNGExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderExamples {
	
	public static WebDriver driver;
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
	
	@Test(priority=1,dataProvider="dp")
	public void LoginFunctionality(String user,String pwd) {
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pwd);
	}
	
	@Test(priority=2)
	public void ClickLoginButton() {
		driver.findElement(By.id("login")).click();
	}
	
	@DataProvider(name="dp",indices= {0,2,3})
	String [][] logindata() {
			
			String data[][]={
			{"mahesh23456","India@123"},
			{"kiran23456","Kiran@123"},
			{"kiran12345","kiran@123"},
			{"abcd3456","abcd@345"}
	};
			return data;		
}

	

}
