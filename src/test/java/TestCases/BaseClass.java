package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
//implement common functionality for every testcase
public class BaseClass {
	
	public static WebDriver driver;
	

	@BeforeClass
	@Parameters({"browser","url"})
	public void openapplication(String br,String url) {
		
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.get(url);
		
		
	}
	
	@AfterClass
	public void closeApplication() {
		driver.close();
	}

}
