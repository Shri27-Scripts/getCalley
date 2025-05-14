package getcalley.TestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import getcalley.generic.Calley_BaseClass;
import getcalley.pom.DashboardPage;

@Listeners(getcalley.generic.ListnerImplimantion.class)

public class CompleteScript extends Calley_BaseClass{
	
	@Test 
	public void SetUpTest() throws InterruptedException, IOException {
		
		DashboardPage dp = new DashboardPage(driver);
		
		Actions action=new Actions(driver);
		action.moveToElement(dp.getTeam()).perform();
		Thread.sleep(2000);
		
		action.click(dp.getAgents()).perform();
		Thread.sleep(1000); 
		
		FileInputStream fis= new FileInputStream("./TestData/Calley_data.xlsx");
		try (Workbook wb = new XSSFWorkbook(fis)) {
			Sheet sheet = wb.getSheet("Sheet1");
			String name = sheet.getRow(13).getCell(1).getStringCellValue();
			double Number = sheet.getRow(14).getCell(1).getNumericCellValue();
		    String mobileNo = Double.toString(Number);
		    String email = sheet.getRow(15).getCell(1).getStringCellValue();
		    String password = sheet.getRow(16).getCell(1).getStringCellValue();
		    
		    dp.getName().sendKeys(name);
		    Thread.sleep(1000);
		    dp.getMobileNo().sendKeys(mobileNo);
		    Thread.sleep(1000);
		    dp.getEmail().sendKeys(email);
		    Thread.sleep(1000);
		    dp.getPassword().sendKeys(password);
		    Thread.sleep(1000);
		}
		Select select= new Select(dp.getSelectLead());
		select.selectByIndex(1);
		
		dp.getSubmit().click();
		Thread.sleep(1000);
		
		dp.getOkButton().click();
		Thread.sleep(1000);
		
		//FileInputStream fis01= new FileInputStream("./TestData/Calley_data.xlsx");
		//try (Workbook wb = new XSSFWorkbook(fis01)) {
			//Sheet sheet = wb.getSheet("Sheet1");
		//String name = sheet.getRow(13).getCell(1).getStringCellValue();
		//String RegAgent = dp.getAgentName().getText();
		
		//Assert.isTrue(true, RegAgent, name);
		//Thread.sleep(2000);
	//}
		
		action.moveToElement(dp.getCall_List()).perform();
		Thread.sleep(2000);
		
		action.click(dp.getPowerImport()).perform();
		Thread.sleep(1000);
		dp.getFileName().sendKeys("MyCompany Call List");
		Thread.sleep(1000);
		dp.getAgentList().click();
		Thread.sleep(1000);
		dp.getChoosenAgent().click();
		Thread.sleep(1000);
		
		File file= new File("./TestData/Sample_Test.csv");
		String absoluteFile = file.getAbsolutePath();
		dp.getChooseFile().sendKeys(absoluteFile);
		Thread.sleep(1000);
		dp.getUploadFile().click();
		Thread.sleep(1000);
		dp.getConfirm().click();
		Thread.sleep(1000);
	}

}
