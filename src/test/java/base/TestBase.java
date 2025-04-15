package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	
	private static TestBase base;
	private static WebDriver driver;
	
	private TestBase()
	{
		String browser="chrome";
		if(browser.equalsIgnoreCase(browser))
		{
			driver=new ChromeDriver();
			
		}
		else
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		
	}
	public static void  initDriver()
	{
		if(base==null)
		{
			base=new TestBase();
		}
	}
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static void OpenURL(String url)
	{
		driver.get(url);
	}
	
	public static void tearDown()
	{
	  if(driver!=null)
	  {
		  driver.close();
		  driver.quit();
	  }
	  base=null;
	}
	

}
