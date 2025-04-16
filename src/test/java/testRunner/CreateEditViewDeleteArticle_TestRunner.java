package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {""},glue= {""},monochrome=true,
plugin={"pretty","html:target/Reports/htmlReport.html","usage:target/Reports/usagereport","json:target/Reports/JsonReport.json",
"rerun:target/Failed/failedfile.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CreateEditViewDeleteArticle_TestRunner extends AbstractTestNGCucumberTests{
	
	

}
