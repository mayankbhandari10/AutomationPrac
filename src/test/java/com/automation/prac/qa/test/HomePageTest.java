package com.automation.prac.qa.test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.prac.qa.base.Base;
import com.automation.prac.qa.pages.HomePage;
import com.automation.prac.qa.pages.LoginPage;


public class HomePageTest extends Base {

	HomePage HP= new HomePage();
			
	public HomePageTest() throws Exception {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() throws Exception
	{
		try
		{
			initilization();
			
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	@Test(priority=1, description = "verify home page")
	public void fn_navigate_to_Login_page() throws Exception
	{
		try
		{
			LoginPage LP=HP.fn_Click_to_Sign_in();
			String title=driver.getTitle();
			System.out.println(title);
			String expected="Login - My Store";
			Assert.assertEquals(title, expected);
        }
		  catch(Exception e)
		{
			  throw e;
		}
	}
	
	
	
	@AfterMethod()
	public void TearDown() throws Exception
	{
		try
		{
           driver.quit();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
