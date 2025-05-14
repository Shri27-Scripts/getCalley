package getcalley.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import getcalley.pom.DashboardPage;
import getcalley.pom.LoginPage;

public class Calley_BaseClass {
	
public static WebDriver driver;
	
	@BeforeClass
	public void OpenBrowser() throws InterruptedException {
		Reporter.log("open browser", true);
		ChromeOptions options = new ChromeOptions(); 
		 options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://app.getcalley.com/Login.aspx");
	}
	
	@AfterClass
	public void CloseBrowser() {
		Reporter.log("close browser", true);
		driver.close();
	}
	
	@BeforeMethod
	public void Login() throws IOException  {
		Reporter.log("login", true);
		
		FileInputStream fis= new FileInputStream("./TestData/Calley_data.xlsx");
		try (Workbook wb = new XSSFWorkbook(fis)) {
			Sheet sheet = wb.getSheet("Sheet1");
			//String Url = sheet.getRow(8).getCell(1).getStringCellValue();
			String UserId = sheet.getRow(9).getCell(1).getStringCellValue();
			String PassId = sheet.getRow(10).getCell(1).getStringCellValue();
			
			LoginPage lp= new LoginPage(driver);
			lp.setLogin(UserId, PassId);
		}
		
	}
	
	@AfterMethod
	public void Logout() {
		Reporter.log("logout", true);
		
		DashboardPage dp= new DashboardPage(driver);
		dp.setProfile();
		dp.setLogout();
	}

}
