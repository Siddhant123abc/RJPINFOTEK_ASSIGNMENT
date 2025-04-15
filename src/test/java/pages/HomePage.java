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
}
