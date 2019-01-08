package com.automation.prac.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.prac.qa.base.Base;



public class LoginPage extends Base{

	private @FindBy(id="email")
	WebElement  user;

	private @FindBy(id="passwd")
	WebElement  password;

	private @FindBy(id="SubmitLogin")
	WebElement  Btn_login;

	private @FindBy(xpath="//div[@class='alert alert-danger']//li")
	WebElement text_Error_msg;

	private @FindBy(id="email_create")
	WebElement  Textbox_email;
	
	private @FindBy(id="SubmitCreate")
	WebElement  Btn_Submitlogin;
	


	public LoginPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);

}

	public MyAccount fn_Do_login(String email, String pass) throws Exception
	{
		try
		{
			user.sendKeys(email);
			password.sendKeys(pass);
			Btn_login.click();

		}
		catch(Exception e)
		{
			throw e;
		}
		return new MyAccount();
	}

	public void fn_Do_invalid_login(String email,String pass) throws Exception
	{
		try
		{
			user.sendKeys(email);
			password.sendKeys(pass);
			Btn_login.click();
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public String fn_verify_invalid_login_Error() throws Exception
	{
		String message;
		try
		{
			message=text_Error_msg.getText();
		}
		catch(Exception e)
		{
			throw e;
		}
		return message;
      }
	
	public RegistrationPage fn_enter_email_id(String mail) throws Exception
	{
		try
		{
			Textbox_email.sendKeys(mail);
			Btn_Submitlogin.click();
		}
		  catch(Exception e)
		{
			throw e;
		}
		return new RegistrationPage();
	}
}
