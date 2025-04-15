package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@BeforeAll
	
	public static void setupDriver()
	{
		TestBase.initDriver();
		
	}
	
	@After
	public void tearDown(Scenario scenarios)
	{
		if(scenarios.isFailed())
		{
			TakesScreenshot ss=(TakesScreenshot)TestBase.getDriver();
			byte ab[]=ss.getScreenshotAs(OutputType.BYTES);
			scenarios.attach(ab, "img/png", "FaileScreenshot");
		}
	}
	
	@AfterAll
	public static void tearDown()
	{
		TestBase.tearDown();
	}
	

}
