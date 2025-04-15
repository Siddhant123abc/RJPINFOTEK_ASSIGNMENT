package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditandDeleteArticlePage {
	
	
	@FindBy(xpath="//a[contains(@href,'editor/')]")
	WebElement editarticlelink;
	
	@FindBy(xpath="//button[contains(text(),'Delete Article')]")
	WebElement deletearticlelink;
	
	public EditandDeleteArticlePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void clicklinkEditArticle()
	{
		editarticlelink.click();
	}
	public void deleteArticle()
	{
		deletearticlelink.click();
	}
}
