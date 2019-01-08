package com.automation.prac.qa.genrics;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.automation.prac.qa.base.Base;

public class GenricClass extends Base {

	public GenricClass() throws Exception {
		super();

	}	
	public static void fn_selectElementByValue(WebElement Element,int index)throws Exception
	{
		try
		{
			Select selectobj = new Select(Element);
			selectobj.selectByIndex(index);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public static void fn_mouse_hover(WebElement element) throws Exception
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
