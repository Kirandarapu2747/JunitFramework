package TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void logintest() {
		
		LoginPage lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp.setUsername();
		System.out.println("username is entered");
		lp.setPassword();
		System.out.println("password is entered");
		lp.ClickLoginBtn();
		System.out.println("login button clickingn activity completed");
		
	}
}
