package com.automation.prac.qa.test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.prac.qa.base.Base;
import com.automation.prac.qa.pages.HomePage;
import com.automation.prac.qa.pages.LoginPage;
import com.automation.prac.qa.pages.MyAccount;
import com.automation.prac.qa.pages.Tshirt;


public class LoginPageTest extends Base {

	HomePage HP= new HomePage();

	public LoginPageTest() throws Exception {
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

	@Test(priority=1,  description = "verify login")
    public void fn_AUT_L001() throws Exception
	{
		try 
		{
			LoginPage LP=HP.fn_Click_to_Sign_in();
			MyAccount MA=LP.fn_Do_login(prep.getProperty("username"), prep.getProperty("password"));
			String title=driver.getTitle();
			System.out.println(title);
			String expected="My account - My Store";
			Assert.assertEquals(title, expected);
		}

		catch(Exception e)
		{
			throw e;
		}
	}

    @Test(priority=2, description = "verify invalid login")
	public void fn_AUT_L002() throws Exception
	{
		try 
		{
			LoginPage LP=HP.fn_Click_to_Sign_in();
			LP.fn_Do_login(prep.getProperty("username"), prep.getProperty("invalid"));
			String error=LP.fn_verify_invalid_login_Error();
			System.out.println(error);
			String expected="Authentication failed.";
			Assert.assertEquals(error, expected);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
    
	@Test(priority=3,  description = "end to end flow of add product to chekout")
    public void fn_AUT_L003() throws Exception
	{
		try 
		{
			LoginPage LP=HP.fn_Click_to_Sign_in();
			MyAccount MA=LP.fn_Do_login(prep.getProperty("username"), prep.getProperty("password"));
			Thread.sleep(3000);
			Tshirt TS =MA.fn_mouse_hover_woman();
			TS.fn_add_product();
			
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
