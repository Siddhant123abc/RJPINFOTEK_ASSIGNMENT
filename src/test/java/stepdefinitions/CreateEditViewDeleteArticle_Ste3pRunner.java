package stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateNewArticlePage;
import pages.EditandDeleteArticlePage;
import pages.HomePage;
import pages.Loginpage;
import pages.UpdateArticlePage;

public class CreateEditViewDeleteArticle_Ste3pRunner {
	
	WebDriver driver=TestBase.getDriver();
	CreateNewArticlePage cp;
	EditandDeleteArticlePage ep;
	HomePage hp;
	Loginpage lp;
	UpdateArticlePage up;
	
	public CreateEditViewDeleteArticle_Ste3pRunner()
	{
		cp=new CreateNewArticlePage(driver);
		ep=new EditandDeleteArticlePage(driver);
		hp=new HomePage(driver);
		lp=new Loginpage(driver);
		up=new UpdateArticlePage(driver);
		
	}
	
	@Given("User is on Login page")
	public void user_is_on_login_page()
	{
		TestBase.OpenURL("https://conduit-realworld-example-app.fly.dev/");
	}
	@When("User provide {string} and {string}")
	public void user_provide_username_and_password(String username, String password)
	{
		hp.clickLogin_link();
		lp.submitLoginDetails(username, password);
	}
	@Then("User should be on Home Page")
	public void user_should_be_onHOme_Page()
	{
		Assert.assertTrue(hp.Homepage_Present());
	}
	
        @Given("User should be on New Article Page")
        public void user_should_be_on_NEW_Article_Page()
        {
        	Assert.assertTrue(hp.verifyNewarticlelink());
        	hp.clickNewArticle_link();
        }
        
        @When("User enters Article details")
        public void user_enter_Article_details(DataTable dt)
        {
        	List<Map<String,String>> lm=dt.asMaps();
        	String articletitle=lm.get(0).get("title");
        	String whatsthisarticleabout=lm.get(0).get("Desc");
        	String writeyourarticle=lm.get(0).get("Content");
        	String entertags=lm.get(0).get("tag");
        	cp.sendArticleTitle(articletitle);
        	cp.sendWhatsthisArticleAbout(whatsthisarticleabout);
        	cp.sendWriteyourArticle(writeyourarticle);
        	cp.sendEnterTags(entertags);
        	cp.clickPUblishArticle();
        }
        
        @Then("Article must be created")
        public void then_artice_must_be_created()
        {
        	Assert.assertTrue(hp.Homepage_Present());
        }
        
        
        @Given("User should be on Global Feed page")
        public void user_should_be_on_Global_FEEDPAGE()
        {
        	hp.click_HomepageLinkAfterarticle();
        	hp.click_GlobalFeedPage();
        }
        @When("User select an article {string}")
        public void user_select_an_article(String article)
        {
        	String pp=hp.getArticleTitle();
        	
           Assert.assertEquals(pp, article, "Article not present");
           {
        	   hp.selectArticle();
           }
        }
        @Then("Article detail {string} page must be displayed")
        public void artilce_detail_page_displayed(String articlecontent)
        {
        	Assert.assertEquals(articlecontent, hp.getTextofArticle());
        }
        
        @Given("Article detail page must be displayed")
        public void articledetails_page_must_be_displayed()
        {
        	Assert.assertTrue(ep.isclicklinkEditArticle());
        }
        @When("User update article detail")
        public void user_update_article_Details()
        {
        	ep.clicklinkEditArticle();
        	up.updateArticleTitle("siddsiddhant");
        	up.clickUpdateTitle();
        }
        @Then("Article detail must be updated")
        public void article_detail_must_be_updated()
        {
        	Assert.assertTrue(ep.isclicklinkEditArticle());
        }
        
       
        @When("User delete article")
        public void user_delete_article()
        {
        	ep.deleteArticle();
        	WebDriverWait wb=new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(40));
        	wb.until(ExpectedConditions.alertIsPresent());
        	Alert alert=TestBase.getDriver().switchTo().alert();
        	String str=alert.getText();
        	String str2="Want to delete the article?";
        	if(str.equals(str2))
        	{
        		alert.accept();
        	}
        	
        	
        }
        @Then("Article must be deleted")
        public void article_must_be_deleted()
        {
        	String str="Articles not available.";
        	String str1=TestBase.getDriver().findElement(By.xpath("//div[contains(text(),'Articles')]")).getText();
        	Assert.assertEquals(str, str1);
        	
        }
}
