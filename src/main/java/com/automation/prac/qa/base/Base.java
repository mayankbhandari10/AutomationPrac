package com.automation.prac.qa.base;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	private  String path="C:\\Users\\Mayank\\Desktop\\Automation framework hybrid\\AutomationPrac\\src\\main\\java\\com\\automation\\prac\\qa\\config\\config.properties";
	public static  WebDriver driver;
	public static Properties prep;

	//constructur
	public Base() throws Exception
	{
		try
		{
			prep= new Properties();
			FileInputStream ip= new FileInputStream(path);
			prep.load(ip);
		}

		catch(Exception e)
		{
			throw e;
		}

	}

	public static void initilization()throws Exception 
	{
		String url=prep.getProperty("url");
		System.out.println(url);
		try
		{
			String browsername=prep.getProperty("browser");

			if(browsername.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mayank\\Downloads\\chromedriver.exe");
				driver=new ChromeDriver(); 
			}

			else if(browsername.equals("ff"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mayank\\Downloads\\geckodriver.exe");

			}
			else
			{
				System.out.println("No browser found");
			}
		}
		catch(Exception e)
		{
			throw e;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);

	}
}
