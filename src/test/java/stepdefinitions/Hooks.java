package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@BeforeAll
	
	public static void setupDriver()
	{
		TestBase.initDriver();
		
	}
	
	@AfterStep(order=1)
	public void tearDown(Scenario scenarios)
	{
		if(scenarios.isFailed())
		{
			TakesScreenshot ss=(TakesScreenshot)TestBase.getDriver();
			byte ab[]=ss.getScreenshotAs(OutputType.BYTES);
			scenarios.attach(ab, "image/png", "FaileScreenshot");
		}
	}
	
	@AfterAll
	public static void tearDown()
	{
		TestBase.tearDown();
	}
	

}
