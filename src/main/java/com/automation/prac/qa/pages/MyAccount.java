package com.automation.prac.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.prac.qa.base.Base;
import com.automation.prac.qa.genrics.GenricClass;

public class MyAccount extends Base {

	private @FindBy(xpath="//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a")
	WebElement mouse_women;
	public MyAccount() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	public Tshirt fn_mouse_hover_woman() throws Exception 
	{
		try
		{
			GenricClass.fn_mouse_hover(mouse_women);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//ul//a")).click();
		}
		catch(Exception e)
		{
			throw e;
		}
            return new Tshirt();
	}
}
