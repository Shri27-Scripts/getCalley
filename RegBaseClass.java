package getcalley.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class RegBaseClass {
		
		public static WebDriver driver;
		
		@BeforeClass
		public void OpenBrowser() throws InterruptedException {
			Reporter.log("open browser", true);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		@AfterClass
		public void CloseBrowser() {
			Reporter.log("close browser", true);
			driver.close();
		}
		
		@BeforeMethod
		public void Login() throws IOException  {
			Reporter.log("Registartion", true);
			
			FileInputStream fis= new FileInputStream("./TestData/Calley_data.xlsx");
			try (Workbook wb = new XSSFWorkbook(fis)) {
				Sheet sheet = wb.getSheet("Sheet1");
				
				String Url = sheet.getRow(1).getCell(1).getStringCellValue();
				
				driver.get(Url);
					
			}
			
		}

}
