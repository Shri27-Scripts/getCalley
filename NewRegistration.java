package getcalley.TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import getcalley.generic.RegBaseClass;
import getcalley.pom.RegistrationPage;

@Listeners(getcalley.generic.ListnerImplimantion.class)

public class NewRegistration extends RegBaseClass{
	 
	@Test
	
	public void Registration() throws IOException, InterruptedException {
		
		Reporter.log("NewRegistartion", true);
		
		FileInputStream fis= new FileInputStream("./TestData/Calley_data.xlsx");
		try (Workbook wb = new XSSFWorkbook(fis)) {
			Sheet sheet = wb.getSheet("Sheet1");

            String name = sheet.getRow(2).getCell(1).getStringCellValue();
			String email = sheet.getRow(3).getCell(1).getStringCellValue();
			String password = sheet.getRow(4).getCell(1).getStringCellValue();
			double Number = sheet.getRow(5).getCell(1).getNumericCellValue();
		    String mobile = Double.toString(Number);
		    
		    RegistrationPage reg= new RegistrationPage(driver);
		    reg.getName().sendKeys(name);
		    Thread.sleep(1000);
		    reg.getEmail().sendKeys(email);
		    Thread.sleep(1000);
		    reg.getPassword01().sendKeys(password);
		    Thread.sleep(1000);
		    reg.getMobileNo().sendKeys(mobile);
		    
		    Thread.sleep(2000);
	
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,300)");
	        Thread.sleep(15000);
	        //for captcha manual interaction so i used scanner class
	        try (Scanner scanner = new Scanner(System.in)) {
				scanner.nextLine();
			}
	        reg.getAgree().click();
	        Thread.sleep(2000);
	        
	        reg.getSignUpbutton().click();
	         		
		}
		
	  }	
}
