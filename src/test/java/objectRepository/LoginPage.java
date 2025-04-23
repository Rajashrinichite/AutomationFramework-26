package objectRepository;


import org.openqa.selenium.WebDriver;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class LoginPage {
	@FindBy(id = "user-name")
	private WebElement usernameEdt;
	
	@findAll({@FindBy(id = "password"), @FindBy( name ="password")})
	private WebElement passwordEdt;
	
	@FindBy(className="submit-button")
	private WebElement loginBtn;
	public LoginPage(WebDriver driver )
	{
		PageFactory.initElements(driver, this); 
	}
	}
	public WebElement getUsernameEdt()
	{
		return usernameEdt;
	}
	public WebElement getPasswordEdt()
	{
                 return passwordEdt;
                 
	}
	public WebElement getLoginBtn()
	{
                 return loginBtn;
                 
	}
	public void loginToApp(String username,String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendkeys(password);
		loginBtn.click();
	}
}
