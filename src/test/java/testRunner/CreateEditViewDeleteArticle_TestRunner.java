package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src\\test\\resources\\features\\login_create_view_edit_delete_Article.feature"},glue= {"stepdefinitions"},monochrome=true,
plugin={"pretty","html:target/Reports/htmlReport.html","usage:target/Reports/usagereport","json:target/Reports/JsonReport.json",
"rerun:target/Failed/failedfile.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CreateEditViewDeleteArticle_TestRunner extends AbstractTestNGCucumberTests{
	
	@DataProvider
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	

}
