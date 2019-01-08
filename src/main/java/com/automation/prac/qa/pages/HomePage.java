package com.automation.prac.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.prac.qa.base.Base;

public class HomePage extends Base {

	
	private @FindBy(xpath="//a[@class='login']")
	WebElement  Link_signin;
	
	public HomePage() throws Exception {
		super();
		
		}

	public LoginPage fn_Click_to_Sign_in() throws Exception
	{
		PageFactory.initElements(driver, this);
		try
		{
			Link_signin.click();
		}
		catch(Exception e)
		{
			throw e;
		}
		return new LoginPage();
	}
}
