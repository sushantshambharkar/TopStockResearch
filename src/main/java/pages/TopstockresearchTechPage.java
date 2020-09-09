
package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import excelutil.SaveTechDataInExcel;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import pojos.StockRecord;

public class TopstockresearchTechPage extends PageObject{
	
	ArrayList<String> listb = new ArrayList<String> ();
	


	
	@FindBy(xpath = "/html/body/div[1]/div[1]/nav[2]/div[2]/ul/li[3]/a")
	WebElementFacade	clickLinkTechinals;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/nav[2]/div[2]/ul/li[3]/ul/li[1]/a")
	WebElementFacade clickLinkTechnicalsData;
	
	@FindBy(xpath="//select[@id=\"eqSubCat\"]")
	WebElementFacade	selecttechnicalsdropdown;
	
	
	@FindBy(xpath="//input[@id=\"user_input\"]")
	WebElementFacade	searchShareName;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr[2]/td[1]")
	WebElementFacade	ShareName;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
	WebElementFacade	CurrentPrice;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	DailyEMA5;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	DailyEMA20;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	DailyEMA50;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	DailyEMA200;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
	WebElementFacade	DailyMACD;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]")
	WebElementFacade	DailyMACDSignal;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/span[2]")
	WebElementFacade	DailyMACDTopAnalysis;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[2]/div/table/tbody/tr[2]/td[2]")
	WebElementFacade	DailyADX;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[2]/div/table/tbody/tr[2]/td[3]")
	WebElementFacade	DailyADXplusDI;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[2]/div/table/tbody/tr[2]/td[4]")
	WebElementFacade	DailyADXminusDI;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[2]/div/table/tbody/tr[2]/td[7]/span[2]")
	WebElementFacade	DailyADXTopAnalysis;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[6]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
	WebElementFacade	DailyRSI;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[3]/div/table/tbody/tr[2]/td[5]/span[2]")
	WebElementFacade	DailyRSITopAnalysis;
	

	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	EPS;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	PE;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	Dividend;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	WeeklyEMA5;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	WeeklyEMA20;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	WeeklyEMA50;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	WeeklyEMA200;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[1]/div/table/tbody/tr[3]/td[2]")
	WebElementFacade	WeeklyMACD;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[1]/div/table/tbody/tr[3]/td[3]")
	WebElementFacade	WeeklyMACDSignal;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[1]/div/table/tbody/tr[3]/td[6]/span[2]")
	WebElementFacade	WeeklyMACDTopAnalysis;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[2]/div/table/tbody/tr[3]/td[2]")
	WebElementFacade	WeeklyADX;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[2]/div/table/tbody/tr[3]/td[3]")
	WebElementFacade	WeeklyADXplusDI;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[2]/div/table/tbody/tr[3]/td[4]")
	WebElementFacade	WeeklyADXminusDI;
	
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade	WeeklyADXTopAnalysis;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[4]/div/table/tbody/tr[3]/td[2]")
	WebElementFacade	WeeklyRSI;
	
	@FindBy(xpath = "/html/body/div[1]/div[6]/div/div[1]/div[3]/div/table/tbody/tr[3]/td[5]/span[2]")
	WebElementFacade	WeeklyRSITopAnalysis;
	

	

	ArrayList<StockRecord> LstTechDatavalues = new ArrayList<StockRecord>();
	
	

	public void getUserSelectedDailyTechValues(String nameofStock) {
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		searchShareName.clear();
		searchShareName.sendKeys(nameofStock);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		searchShareName.sendKeys(Keys.ARROW_DOWN);
		searchShareName.sendKeys(Keys.ENTER);

		StockRecord stockrecord = new StockRecord ();
			
		stockrecord.setShareName(ShareName.getText());
		stockrecord.setShareName(ShareName.getText());
		stockrecord.setCurrentPrice(CurrentPrice.getText());
//		DailyEMA5
//		DailyEMA20
//		DailyEMA50
//		DailyEMA200
		stockrecord.setDailyMACD(DailyMACD.getText());
		stockrecord.setDailyMACDSignal(DailyMACDSignal.getText());
		stockrecord.setDailyMACDTopAnalysis(DailyMACDTopAnalysis.getText());
//		stockrecord.setDailyADX(DailyADX.getText());
//		stockrecord.setDailyADXplusDI(DailyADXplusDI.getText());
//		stockrecord.setDailyADXminusDI(DailyADXminusDI.getText());
//		stockrecord.setDailyADXTopAnalysis(DailyADXTopAnalysis.getText());
//		stockrecord.setDailyRSI(DailyRSI.getText());
//		stockrecord.setDailyRSITopAnalysis(DailyRSITopAnalysis.getText());	
		
//		stockrecord.setWeeklyMACD(WeeklyMACD.getText());
//		stockrecord.setWeeklyMACDSignal(WeeklyMACDSignal.getText());
//		stockrecord.setWeeklyMACDTopAnalysis(WeeklyMACDTopAnalysis.getText());
//		stockrecord.setWeeklyADX(WeeklyADX.getText());
//		stockrecord.setWeeklyADXplusDI(WeeklyADXplusDI.getText());
//		stockrecord.setWeeklyADminusDI(WeeklyADXminusDI.getText());
//		//stockrecord.setWeeklyADXTopAnalysis(WeeklyADXTopAnalysis.getText());
//		stockrecord.setWeeklyRSI(WeeklyRSI.getText());
//		stockrecord.setWeeklyRSITopAnalysis(WeeklyRSITopAnalysis.getText());	
		
		LstTechDatavalues.add(stockrecord);
		
		
		
		WebDriver w = getDriver();
		w.navigate().refresh();
		
	}
	
	public void printlstTechDataValues() 
	{
		System.out.println("hi in print mode");
		for (int i = 0; i < LstTechDatavalues.size() ; i++)
		{
			System.out.println(LstTechDatavalues.get(i).getShareName());
			System.out.println(LstTechDatavalues.get(i).getCurrentPrice());
		}
		
		
	}

	public void savetechdatainexcel()
	{
		
		System.out.println(" in the excel sheet save method 1 ");
		 
		
		
	    File TechDatafile = new File("C:/selenium/excel/TopStock.xlsx");
	    
	    FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(TechDatafile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet TechDatasheet = workbook.getSheet("TechData");
		
		int i = 1;
		for (StockRecord  stockRecord : LstTechDatavalues )

		{
			System.out.println(" in the excel sheet save method 2");
			
			//Row row = TechDatasheet.getRow(i);
			
			Row newRow = TechDatasheet.createRow(i+1);
	
//			System.out.println(i + " " + LstTechDatavalues.get(i).getShareName());
//			System.out.println(i + " " + LstTechDatavalues.get(i).getCurrentPrice());

			
			for (int j = 1 ; j <= 32 ; j++ )
			{
				switch (j)
				{
				
				case (1): 
				{ 
					Cell cell = newRow.createCell(j);
					cell.setCellValue(stockRecord.getShareName());
					break;
				}
				
				case (2): 
				{ 
					Cell cell = newRow.createCell(j);
					cell.setCellValue(stockRecord.getCurrentPrice().toString());
					break;
				}
				
				
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyEMA5().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyEMA20().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyEMA50().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyEMA200().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyMACD().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyMACDSignal().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyMACDTopAnalysis().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyADX().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyADXplusDI().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyADXminusDI().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyADXTopAnalysis().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyRSI().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyRSISmooth().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDailyRSITopAnalysis().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getEPS().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getPE().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getDividend().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyEMA5().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyEMA20().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyEMA50().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyEMA200().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyMACD().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyMACDSignal().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyMACDTopAnalysis().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyADX().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyADXplusDI().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyADminusDI().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyADXTopAnalysis().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyRSI().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyRSITopAnalysis().toString());
//				cell.setCellValue(LstTechDatavalues.get(i).getWeeklyRSISmooth().toString());

				
				}
				

			}
			
		    //Close input stream

		    try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    //Create an object of FileOutputStream class to create write data in excel file

		    FileOutputStream outputStream = null;
			try {
				outputStream = new FileOutputStream(TechDatafile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    //write data in the excel file

		    try {
				workbook.write(outputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    //close output stream

		    try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
	


}
