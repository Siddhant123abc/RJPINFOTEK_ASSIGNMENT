package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewArticlePage {
	
		
	@FindBy(xpath="//button[contains(text(),'Publish')]")
	WebElement PublishArticle;
	
	@FindBy(xpath="//input[contains(@placeholder,'Article')]")
	WebElement ArticleTitleTextBox;
	
	@FindBy(xpath="//input[contains(@placeholder,'this')]")
	WebElement WhatsthisarticleaboutTextbox;
	
	@FindBy(xpath="//textarea[contains(@placeholder,'Write')]")
	WebElement WriteYourArticleTextbox;
	
	@FindBy(xpath="//input[contains(@placeholder,'tags')]")
	WebElement EntertagsTextbox;
	
	public CreateNewArticlePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void sendArticleTitle(String articletitle)
	{
		ArticleTitleTextBox.sendKeys(articletitle);
	}

	
	public void sendWhatsthisArticleAbout(String articleabout)
	{
		WhatsthisarticleaboutTextbox.sendKeys(articleabout);
	}
	public void sendWriteyourArticle(String writeyourarticle)
	{
		WriteYourArticleTextbox.sendKeys(writeyourarticle);
	}
	public void sendEnterTags(String entertags)
	{
		EntertagsTextbox.sendKeys(entertags);
	}
	
	public void clickPUblishArticle()
	{
		PublishArticle.click();
	}

}
