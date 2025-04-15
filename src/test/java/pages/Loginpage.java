package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	@FindBy(name="email")
	WebElement emailidtextbox;
	
	@FindBy(name="password")
	WebElement passwordtexbox;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement LoginButton;
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void submitLoginDetails(String Emailid,String password)
	{
		emailidtextbox.sendKeys(Emailid);
		passwordtexbox.sendKeys(password);
		LoginButton.click();
	}
	

}
