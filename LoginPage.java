package getcalley.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "cmdsinup")
	private WebElement SignUp;
	
	@FindBy(id = "txtEmailId")
	private WebElement Username;
	
	@FindBy(id = "txtPassword")
	private WebElement Password;
	
	@FindBy(id = "btnLogIn")
	private WebElement Login;
	
	public LoginPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}
	
	public void setLogin(String UserId, String PassId) {
		Username.sendKeys(UserId);
		Password.sendKeys(PassId);
		Login.click();
	}

}
