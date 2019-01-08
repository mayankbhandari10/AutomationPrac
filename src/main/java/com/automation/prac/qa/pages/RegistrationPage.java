package com.automation.prac.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.prac.qa.base.Base;
import com.automation.prac.qa.genrics.GenricClass;


public class RegistrationPage extends Base {

	private	@FindBy(id="uniform-id_gender1")
	WebElement  RadioBtn_male;

	private	@FindBy(id="uniform-id_gender2")
	WebElement  RadioBtn_female;

	private	@FindBy(id="customer_firstname")
	WebElement  textfield_Fnmae;

	private	@FindBy(id="customer_lastname")
	WebElement  textfield_Lnmae;

	private	@FindBy(id="passwd")
	WebElement  textfield_Password;

	private	@FindBy(id="firstname")
	WebElement  textfield_UserFnmae;

	private	@FindBy(id="lastname")
	WebElement  textfield_UserLnmae;

	private	@FindBy(id="address1")
	WebElement  textfield_UserAddress;

	private	@FindBy(id="city")
	WebElement  textfield_UserCity;

	private	@FindBy(id="postcode")
	WebElement  textfield_Pincode;

	private	@FindBy(id="phone_mobile")
	WebElement  textfield_mobile;

	private	@FindBy(id="submitAccount")
	WebElement  Btn_Submit;

	private	@FindBy(id="id_country")
	WebElement  drop_down_Country;

	private	@FindBy(id="id_state")
	WebElement  drop_down_state;

	private	@FindBy(id="days")
	WebElement  drop_down_days;

	private	@FindBy(id="months")
	WebElement  drop_down_month;

	private	@FindBy(id="years")
	WebElement  drop_down_years;

	private @FindBy(xpath="//div[@class='alert alert-danger']//p")
	WebElement text_Error_msg;
	
	
	
	

	public RegistrationPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);

	}
	public void fn_userRegistration( String gender, String firstname,String lastname,String password,int day,int mon,int year,String Uname,String Ulname,String Add,String city,int state,int country,String pin,String mob ) throws Exception
	{
		try
		{
			fn_choose_gender(gender);
			Thread.sleep(1000);
			textfield_Fnmae.sendKeys(firstname);
			Thread.sleep(1000);
			textfield_Lnmae.sendKeys(lastname);
			Thread.sleep(2000);
			textfield_Password.sendKeys(password);
			Thread.sleep(2000);
			GenricClass.fn_selectElementByValue(drop_down_days, day);
			GenricClass.fn_selectElementByValue(drop_down_month, mon);
			GenricClass.fn_selectElementByValue(drop_down_years, year);
			textfield_UserFnmae.sendKeys(Uname);
			Thread.sleep(1000);
			textfield_UserFnmae.sendKeys(Ulname);
			Thread.sleep(1000);
			textfield_UserAddress.sendKeys(Add);
			textfield_UserCity.sendKeys(city);
			GenricClass.fn_selectElementByValue(drop_down_state, day);
			textfield_Pincode.sendKeys(pin);
			Thread.sleep(1000);
			//GenricClass.fn_selectElementByValue(drop_down_Country, day);
			Thread.sleep(1000);
			textfield_mobile.sendKeys(mob);
			Thread.sleep(2000);
			fn_click_on_submit();
			
        }
		catch(Exception e)
		{
			throw e;
		}
	}

	public void fn_choose_gender(String gender) throws Exception
	{
		try
		{
			if(gender=="male")
			{
				RadioBtn_male.click();
			}
			else if(gender=="female")
			{
				RadioBtn_female.click();
			}
			else
			{
				System.out.println("invalid option");
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void fn_click_on_submit() throws Exception
	{
		try
		{
			Btn_Submit.click();
		}
		  catch(Exception e)
		{
			  throw e;
		}
	}
public String fn_verify_errors() throws Exception
{
	String text;
	try
	{
	     text=text_Error_msg.getText();
		System.out.println(text);
	}
	catch(Exception e)
	{
		throw e;
	}
	return text;
}


}