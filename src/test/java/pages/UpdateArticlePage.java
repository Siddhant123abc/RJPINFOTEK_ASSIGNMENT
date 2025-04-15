package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateArticlePage {
	
	
	@FindBy(xpath="//button[contains(text(),'Update')]")
	WebElement updateArticle;
	@FindBy(xpath="//input[contains(@placeholder,'Article')]")
	WebElement ArticleTitle;
	
	public UpdateArticlePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void updateArticleTitle(String updatetitle)
	{
		ArticleTitle.sendKeys(updatetitle);
	}
	public void clickUpdateTitle()
	{
		updateArticle.click();
	}

}
