package getcalley.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	@FindBy(id = "txtName")
	private WebElement Name;
	
	@FindBy(id = "txtEmail")
	private WebElement Email;
	
	@FindBy(id = "txtPassword")
	private WebElement Password01;
	
	@FindBy(id = "txt_mobile")
	private WebElement MobileNo;
	
	@FindBy(id = "checkbox-signup")
	private WebElement Agree;
	
	@FindBy(id = "btnSignUp")
	private WebElement SignUpButton;
	
	@FindBy(xpath = "//button[@class='confirm' and text()='OK']")
	private WebElement Confirm;
	
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getName() {
		return Name;
	}
	public WebElement getEmail() {
		return Email;
	}
	public WebElement getPassword01() {
		return Password01;	
	}
	public WebElement getMobileNo() {
		return MobileNo;
	}
	public WebElement getAgree() {
		return Agree;
	}
	public WebElement getSignUpbutton() {
		return SignUpButton;
	}
}
