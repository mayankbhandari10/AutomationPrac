package com.automation.prac.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.prac.qa.base.Base;
import com.automation.prac.qa.genrics.GenricClass;



public class Tshirt extends Base{

	private @FindBy(xpath="//div[@class='product-image-container']//a//img")
	WebElement link_product;

	private @FindBy(xpath="//button[@class='exclusive']")
	WebElement button_addtocart;

	private @FindBy(xpath="//a[@class='btn btn-default button button-medium']")
	WebElement button_checkout;

	private @FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement button_proceedt;

	private @FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement button_proceed1;

	private @FindBy(xpath="//button[@class='button btn btn-default standard-checkout button-medium']")
	WebElement button_courier;

	private @FindBy(id="cgv")
	WebElement terms;

	private @FindBy(xpath="//button[@class='button btn btn-default standard-checkout button-medium']")
	WebElement button_cour;

	private @FindBy(xpath="//p[@class='payment_module']//a")
	WebElement link_paymode;

	private @FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement btn_last;




	public Tshirt() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	public void fn_add_product() throws Exception
	{
		try
		{

			link_product.click();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//p[@id='add_to_cart']//button")).click();
			Thread.sleep(2000);
			button_checkout.click();
			Thread.sleep(2000);
			String myWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(myWindowHandle );
			button_proceedt.click();
			Thread.sleep(2000);
			button_proceed1.click();
			Thread.sleep(2000);
			terms.click();
			button_courier.click();
			Thread.sleep(2000);
			link_paymode.click();
			Thread.sleep(2000);
			btn_last.click();
		}
		catch(Exception e)
		{

			throw e;
		}
	}		

}
