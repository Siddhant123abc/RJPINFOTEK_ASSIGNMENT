package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath="//a[contains(@href,'login')]")
	WebElement Loginlink;
	
	@FindBy(xpath="//a[contains(@href,'editor')]")
	WebElement NewArticlelink;
	
	@FindBy(xpath="//a[@aria-current='page'and @class='nav-link active']")
	WebElement HomeLink;
	
	@FindBy(xpath="//a[(@class='nav-link ') and @href='#/']")
	WebElement Homepagelink_afterarticle;
	
	@FindBy(xpath="//button[@class='nav-link ']")
	WebElement GlobalFeedpage;
	
	@FindBy(xpath="//h1[contains(text(),'')]")
	WebElement selectArticle;
	
	@FindBy(xpath="//p[contains(text(),'')]")
			WebElement articledetails;
	String ss;
	String sy;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void clickLogin_link()
	{
		Loginlink.click();
	}
	public void clickNewArticle_link()
	{
		NewArticlelink.click();
		
	}
	public boolean Homepage_Present()
	{
		return HomeLink.isEnabled();
	}
	
	public boolean verifyNewarticlelink()
	{
		return NewArticlelink.isEnabled();
	}
	
	public void click_Homepage()
	{
		HomeLink.click();
	}
	
	public void click_HomepageLinkAfterarticle()
	{
		Homepagelink_afterarticle.click();
	}
	public void click_GlobalFeedPage()
	{
		GlobalFeedpage.click();
	}
	public void selectArticle()
	{
		selectArticle.click();
	}
	public String getArticleTitle()
	{
		sy=selectArticle.getText();
		return sy;
	}
	
	public String getTextofArticle()
	{
		ss=articledetails.getText();
		return ss;
	}
}
