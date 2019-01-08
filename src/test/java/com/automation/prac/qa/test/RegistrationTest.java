package com.automation.prac.qa.test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.prac.qa.base.Base;
import com.automation.prac.qa.pages.HomePage;
import com.automation.prac.qa.pages.LoginPage;
import com.automation.prac.qa.pages.RegistrationPage;

public class RegistrationTest extends Base {

	HomePage HP= new HomePage();
	public RegistrationTest() throws Exception {
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
	@Test(priority=1,  description = "verify the registration process")
	public void AUTP_001() throws Exception
	{
		try
		{
			LoginPage LP=HP.fn_Click_to_Sign_in();
			RegistrationPage RP=LP.fn_enter_email_id(prep.getProperty("emailId"));
			RP.fn_userRegistration("male", "firstname", "lastname", "password", 3, 3, 3, "Uname", "Ulname", "Add" ," punjab", 2, 0, "30305", "7830770170");
            String title=driver.getTitle();
            String expected="My account - My Store";
            Assert.assertEquals(title, expected);

		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@Test(priority=2, description = "verify failed registration message.")
	public void AUTP_003() throws Exception
	{
		try
		{
			LoginPage LP=HP.fn_Click_to_Sign_in();
			RegistrationPage RP=LP.fn_enter_email_id(prep.getProperty("emailId"));
			Thread.sleep(2000);
			RP.fn_click_on_submit();
			String actual=RP.fn_verify_errors();
			String expected="There are 8 errors";
		    Assert.assertEquals(actual, expected);
			
        }
		catch(Exception e)
		{
			throw e;
		}
	}
}
