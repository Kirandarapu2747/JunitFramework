package TestNGExamples;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class Examples002 {
	
	@BeforeSuite
	public void sum() {
		System.out.println("Before Suite...");
	}
	@Test(priority=2)
	public void sub() {
		System.out.println("Test1");
	}
    @Test(priority=1)
	public void mul() {
		System.out.println("Test2");
	}
	
	@AfterSuite
	public void div() {
		System.out.println("aftersuite...");
	}
	
	@BeforeTest
	public void ram() {
		System.out.println("before Test...");
	}
	
	@AfterTest
	public void rom() {
		System.out.println("Aftertest...");
	}
	
	@BeforeClass
	public void mul2() {
		System.out.println("beforeclass");
	}
	
	@AfterClass
	public void div2() {
		System.out.println("Afterclass");
	}
	
	@BeforeMethod
	public void sum2() {
		System.out.println("Before Method");
	}
	@AfterMethod
	public void sub2() {
		System.out.println("aftermethod");
	}
}
