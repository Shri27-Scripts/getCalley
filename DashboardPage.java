package getcalley.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(xpath = "//button[@class='close' and @type='button']")
	private WebElement ModalPopup;
	
	@FindBy(xpath = "//span[text()='Team']")
	private WebElement Team;
	
	@FindBy(xpath = "//span[text()='Agents']")
	private WebElement Agents;
	
	@FindBy(id = "ContentPlaceHolder1_txt_name")
	private WebElement Name;
	
	@FindBy(id = "ContentPlaceHolder1_txt_mobile")
	private WebElement MobileNo;
	
	@FindBy(id = "ContentPlaceHolder1_txt_email")
	private WebElement Email;
	
	@FindBy(id = "ContentPlaceHolder1_txt_pass")
	private WebElement password;
	
	@FindBy(id = "ContentPlaceHolder1_ddl_lead")
	private WebElement SelectLead;
	
	@FindBy(id = "ContentPlaceHolder1_btn_submit")
	private WebElement Submit;
	
	@FindBy(xpath = "//button[@class='confirm' and text()='OK']")
	private WebElement OkButton;
	
	@FindBy(xpath = "//td[text()='Ashley Atson']")
	private WebElement AgentName;
	
	@FindBy(xpath = "//span[text()='Call List ']")
	private WebElement Call_List;
	
	@FindBy(xpath = "//span[text()='Add - Power Import']")
	private WebElement PowerImport;
	
	@FindBy(id = "ContentPlaceHolder1_txtlistname")
	private WebElement FileName;
	
	@FindBy(xpath = "//button[@class='multiselect dropdown-toggle btn btn-default']")
	private WebElement AgentList;
	
	@FindBy(xpath = "//label[@class='checkbox' and text()=' Abhishek']")
	private WebElement ChoosenAgent;
	
	@FindBy(id = "ContentPlaceHolder1_fileUpload")
	private WebElement ChooseFile;
	
	@FindBy(id = "btnUp")
	private WebElement UploadFile;
	
	@FindBy(xpath = "//button[@class='confirm' and text()='Ok']")
	private WebElement Confirm;
	
	@FindBy(xpath = "//i[@class='fa fa-user-circle']")
	private WebElement Profile;
	
	@FindBy(xpath = "(//a[@class='dropdown-item notify-item' and @href='logout.aspx'])[3]")
	private WebElement Logout;
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getModalPopup() {
		return ModalPopup;
	}
	
	public WebElement getTeam() {
		return Team;	
	}
	public WebElement getAgents() {
		return Agents;
	}
	public WebElement getName() {
		return Name;
	}
	public WebElement getMobileNo() {
		return MobileNo;
	}
	public WebElement getEmail() {
		return Email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSelectLead() {
		return SelectLead;
	}
	public WebElement getSubmit() {
		return Submit;
	}
	public WebElement getOkButton() {
		return OkButton;
	}
	public WebElement getAgentName() {
		return AgentName;
	}
	public WebElement getCall_List() {
		return Call_List;
	}
	public WebElement getPowerImport() {
		return PowerImport;
	}
	public WebElement getFileName() {
		return FileName;
	}
	public WebElement getAgentList() {
		return AgentList;
	}
	public WebElement getChoosenAgent() {
		return ChoosenAgent;
	}
	public WebElement getChooseFile() {
		return ChooseFile;
	}
	public WebElement getUploadFile() {
		return UploadFile;
	}
	public WebElement getConfirm() {
		return Confirm;
	}
	
	public void setProfile() {
		Profile.click();
	}
	
	public void setLogout() {
		Logout.click();
	}

}
