package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import pojos.StockChartWeeklyData;
import pojos.StockChartDailyData;

@DefaultUrl("https://my.topstockresearch.com/")
public class TopstockresearchChartPage extends PageObject {

	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade userInput;

	@FindBy(xpath = "//select[@id=\"freq\"]")
	WebElementFacade userFrequency;

	@FindBy(xpath = "//div[@id=\"selectedValues\"]")
	WebElementFacade userSelectedValues;

	@FindBy(id = "myStocks")
	WebElementFacade myStockdropdown;

	@FindBy(xpath = "//div[@id=\"navbarSupportedContent\"]//a[contains(@href, '#Chart')]")
	WebElementFacade ChartLinkinNavBar;

	@FindBy(xpath = "//div [@id=\"tsrchart\"]")
	WebElementFacade usernavigation;

	@FindBy(xpath = "//*[@id=\"mySettings\"]")
	WebElementFacade mySettingsdropdown;

	@FindBy(xpath = "//*[@id=\"chartControls\"]/div[1]/form/input[4]")
	WebElementFacade saveButton;

	@FindBy(xpath = "//*[@id=\"tsrchart\"]/svg/g/text[1]")
	WebElementFacade companyName;

	@FindBy(xpath = "//*[@id=\"ppLines\"]")
	WebElementFacade pivotlineslink;

	@FindBy(xpath = "//*[@id=\"tsrchart\"]/svg/g/g[1]/g[6]/text")
	WebElementFacade clickonchart;

	@FindBy(id="tsaRnkDivLabel")
	WebElementFacade stockRanking;
	CreateFNOList clist = new CreateFNOList();
	
	public String weeklyMetrics = "WEEKLY  ASHOKLEY     Date:2020-09-11  Open:70.50  High:71.65  Low:64.15  Close:68.15  Volume:152.880M  BBUB:71.27  BBLB:36.78  BBMB:54.03  ema20:58.73  ema6:65.11  RSI:74.03  MACD:6.38  MacdSignal:3.49  ADX:27.91  PDI:31.23  MDI:15.78  ";
	public String dailyMetrics = "DAILY   ADANIENT     Date:2020-09-11  Open:299.00  High:303.65  Low:292.10  Close:296.00  Volume:9.740M  BBUB:NotinGraph BBLB:210.23  BBMB:270.28  ema20:267.70  ema5:290.76  RSI:66.40  MACD:22.07  MacdSignal:24.99  ADX:57.04  PDI:34.15  MDI:10.98  ";

	public static List<StockChartWeeklyData> lststoryChartWeeklyData = new ArrayList<StockChartWeeklyData>();
	public static List<StockChartDailyData> lststoryChartDailyData = new ArrayList<StockChartDailyData>();
	public List<String> lsttrackhitstocks = clist.CreateFNOListshare();

	public void getUserSelectedDailyValues(String stockname) throws InterruptedException {
		userInput.clear();
		userInput.sendKeys(stockname);
		Thread.sleep(1000);
		userInput.sendKeys(Keys.ARROW_DOWN);
		
		userInput.sendKeys(Keys.ENTER);
		userInput.sendKeys(Keys.TAB);

	}

	public void getdailychartvalues() throws InterruptedException {

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String metricvalues = " ", scriptname = " ", scriptcomments =" ";

		ChartLinkinNavBar.click();



		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mySettingsdropdown.click();

		mySettingsdropdown.selectByVisibleText("DailyChart");

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		for (int x = 1; x <= 1; x++)

		{

			myStockdropdown.click();

			myStockdropdown.selectByIndex(x);

			myStockdropdown.click();

			scriptname = myStockdropdown.getSelectedVisibleTextValue();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			usernavigation.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
			WebDriver dailydriver = getDriver();

			Actions actionProvider = new Actions(dailydriver);

			actionProvider.moveToElement(usernavigation).moveByOffset(870, 0).click().build().perform();

			//actionProvider.moveToElement(usernavigation).moveByOffset(655, 0).click().build().perform();
			
			//actionProvider.moveToElement(usernavigation).moveByOffset(550, 0).click().build().perform();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			metricvalues = userSelectedValues.getTextValue();

			metricvalues = metricvalues.replace("BB UB:", "BBUB:");
			metricvalues = metricvalues.replace("BB MB:", "BBMB:");
			metricvalues = metricvalues.replace("BB LB:", "BBLB:");
			metricvalues = metricvalues.replace("Macd Signal:", "MacdSignal:");
			metricvalues = metricvalues.replace("EMA 6", "ema06:");
			metricvalues = metricvalues.replace("EMA6", "ema06:");
			metricvalues = metricvalues.replace("EMA 200:", "ema200:");
			if (!metricvalues.contains("BBLB")) {
				metricvalues = metricvalues.replace("BBMB:", "BBLB:NotinGraph BBMB:");
			}

			if (!metricvalues.contains("BBUB")) {
				metricvalues = metricvalues.replace("BBLB:", "BBUB:NotinGraph BBLB:");
			}

			if (!metricvalues.contains("ema200:")) {
			
				metricvalues = metricvalues.replace("PSAR:", "ema200:0.0 PSAR:");
				
			}
			userInput.clear();
			userInput.sendKeys(scriptname.replace(" ", ""));
			
			Thread.sleep(2000);
			userInput.sendKeys(Keys.ARROW_DOWN);
			
			userInput.sendKeys(Keys.ENTER);
			userInput.sendKeys(Keys.TAB);
		
			Thread.sleep(3000);
			
			scriptcomments = stockRanking.getTextValue();
			
			scriptname = StringUtils.rightPad(scriptname, 12, " ");
			dailyMetrics = "DAILY  " + scriptname + " " + metricvalues + " "+ "scriptcomments:" + scriptcomments;
			metricvalues = " ";
			scriptname = " ";
			scriptcomments =" ";
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			userInput.clear();
			// dailyMetrics = "DAILY ACC Date:2020-06-02 Open:1282.00 High:1299.30
			// Low:1272.80 Close:1287.10 Volume:980515.00 BBUB:1307.97 BBLB:1098.14
			// BBMB:1203.05 ema20:1214.65 EMA06:1266.48 RSI:68.88 MACD:51.84
			// MacdSignal:44.81 ADX:38.53 PDI:33.14 MDI:9.46 ";
			 System.out.println(dailyMetrics);

			String WeeklyorDaily = dailyMetrics.substring(0, 7);
			String StockName = dailyMetrics.substring(7, 20);
			String TradeDate = dailyMetrics.substring(25, 35);
			String OpenPriceDaily = dailyMetrics.substring(dailyMetrics.indexOf("Open:") + 5,dailyMetrics.indexOf("High:"));
			String HighPriceDaily = dailyMetrics.substring(dailyMetrics.indexOf("High:") + 5,
					dailyMetrics.indexOf("Low:"));
			String LowPriceDaily = dailyMetrics.substring(dailyMetrics.indexOf("Low:") + 4,
					dailyMetrics.indexOf("Close:"));
			String ClosePriceDaily = dailyMetrics.substring(dailyMetrics.indexOf("Close:") + 6,
					dailyMetrics.indexOf("Volume:"));
			String VolumeDaily = dailyMetrics.substring(dailyMetrics.indexOf("Volume:") + 7,
					dailyMetrics.indexOf("ema20:"));
			String ema20Daily = dailyMetrics.substring(dailyMetrics.indexOf("ema20:") + 6,dailyMetrics.indexOf("ema06::"));
			String ema06Daily = dailyMetrics.substring(dailyMetrics.indexOf("ema06::") + 7,dailyMetrics.indexOf("ema50:"));
			String ema50Daily = dailyMetrics.substring(dailyMetrics.indexOf("ema50:") + 6,dailyMetrics.indexOf("ema200:"));
			String ema200Daily = dailyMetrics.substring(dailyMetrics.indexOf("ema200:") + 7,dailyMetrics.indexOf("PSAR:"));
			String psar2006Daily = dailyMetrics.substring(dailyMetrics.indexOf("PSAR:") + 5, dailyMetrics.indexOf("Bollinger Bands Upper:"));
			String BBUBDaily = dailyMetrics.substring(dailyMetrics.indexOf("Bollinger Bands Upper:") + 22, dailyMetrics.indexOf("Middle:"));
			String BBMBDaily = dailyMetrics.substring(dailyMetrics.indexOf("Middle:") + 7, dailyMetrics.indexOf("Lower:"));
			String BBLBDaily = dailyMetrics.substring(dailyMetrics.indexOf("Lower:") + 6,dailyMetrics.indexOf("MACD:"));
			String MACDDaily = dailyMetrics.substring(dailyMetrics.indexOf("MACD:") + 5,dailyMetrics.indexOf("MacdSignal:"));
			String MacdSignalDaily = dailyMetrics.substring(dailyMetrics.indexOf("MacdSignal:") + 11,dailyMetrics.indexOf("RSI:"));
			String RSIDaily = dailyMetrics.substring(dailyMetrics.indexOf("RSI:") + 4, dailyMetrics.indexOf("ADX:"));
			String ADXDaily = dailyMetrics.substring(dailyMetrics.indexOf("ADX:") + 4, dailyMetrics.indexOf("PDI:"));
			String PDIDaily = dailyMetrics.substring(dailyMetrics.indexOf("PDI:") + 4, dailyMetrics.indexOf("MDI:"));
			String MDIDaily = dailyMetrics.substring(dailyMetrics.indexOf("MDI:") + 4, dailyMetrics.indexOf("scriptcomments:"));
			String ScriptComments = dailyMetrics.substring(dailyMetrics.indexOf("scriptcomments:") + 15, dailyMetrics.length());
//			 System.out.println("DailyorDaily	" + WeeklyorDaily);
//			 System.out.println("StockName	" + StockName);
//			 System.out.println("TradeDate	" + TradeDate);
//			 System.out.println("OpenPriceDaily	" + OpenPriceDaily);
//			 System.out.println("HighPriceDaily		" + HighPriceDaily);
//			 System.out.println("LowPriceDaily		" + LowPriceDaily);
//			 System.out.println("ClosePriceDaily	" + ClosePriceDaily);
//			 System.out.println("VolumeDaily		" + VolumeDaily);
//			 System.out.println("BBUBDaily			" + BBUBDaily);
//			 System.out.println("BBLBDaily			" + BBLBDaily);
//			 System.out.println("BBMBDaily			" + BBMBDaily);
//			 System.out.println("ema20Daily	" + ema20Daily);
//			 System.out.println("ema06Daily	" + ema06Daily);
//			 System.out.println("RSIDaily			" + RSIDaily);
//			 System.out.println("MACDDaily			" + MACDDaily);
//			 System.out.println("MacdSignalDaily	" + MacdSignalDaily);
//			 System.out.println("ADXDaily			" + ADXDaily);
//			 System.out.println("PDIDaily			" + PDIDaily);
//			 System.out.println("MDIDaily			" + MDIDaily);

			StockChartDailyData stockChartDailyData = new StockChartDailyData();

			stockChartDailyData.setWeeklyorDaily(WeeklyorDaily);
			stockChartDailyData.setStockName(StockName);
			stockChartDailyData.setTradeDate(TradeDate);
			stockChartDailyData.setOpenPriceDaily(OpenPriceDaily);
			stockChartDailyData.setHighPriceDaily(HighPriceDaily);
			stockChartDailyData.setLowPriceDaily(LowPriceDaily);
			stockChartDailyData.setClosePriceDaily(ClosePriceDaily);
			stockChartDailyData.setVolumeDaily(VolumeDaily);
			stockChartDailyData.setBBUBDaily(BBUBDaily);
			stockChartDailyData.setBBLBDaily(BBLBDaily);
			stockChartDailyData.setBBMBDaily(BBMBDaily);
			stockChartDailyData.setEma20Daily(ema20Daily);
			stockChartDailyData.setEma06Daily(ema06Daily);
			stockChartDailyData.setEma50Daily(ema50Daily);
			stockChartDailyData.setEma200Daily(ema200Daily);
			stockChartDailyData.setPsar2006Daily(psar2006Daily);
			stockChartDailyData.setRSIDaily(RSIDaily);
			stockChartDailyData.setMACDDaily(MACDDaily);
			stockChartDailyData.setMacdSignalDaily(MacdSignalDaily);
			stockChartDailyData.setADXDaily(ADXDaily);
			stockChartDailyData.setPDIDaily(PDIDaily);
			stockChartDailyData.setMDIDaily(MDIDaily);
			stockChartDailyData.setADXDaily(ADXDaily);
			stockChartDailyData.setScriptComments(ScriptComments.replace("%", " "));
			
			lststoryChartDailyData.add(stockChartDailyData);

		}
 int s1 = lsttrackhitstocks.size();
 
 System.out.println("number of stockin list " + s1);
for ( String a :  lsttrackhitstocks) { 
	
	userInput.clear(); 
	Thread.sleep(2000);

	
	userInput.sendKeys(a);
	Thread.sleep(2000);
	userInput.sendKeys(Keys.ARROW_DOWN);
	userInput.sendKeys(Keys.ENTER);
	userInput.sendKeys(Keys.TAB);
	
	
	scriptname = a;
	
	usernavigation.click();

	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	WebDriver dailydriver = getDriver();

	Actions actionProvider = new Actions(dailydriver);

	actionProvider.moveToElement(usernavigation).moveByOffset(870, 0).click().build().perform();

	//actionProvider.moveToElement(usernavigation).moveByOffset(655, 0).click().build().perform();
	
	//actionProvider.moveToElement(usernavigation).moveByOffset(550, 0).click().build().perform();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	metricvalues = userSelectedValues.getTextValue();

	metricvalues = metricvalues.replace("BB UB:", "BBUB:");
	metricvalues = metricvalues.replace("BB MB:", "BBMB:");
	metricvalues = metricvalues.replace("BB LB:", "BBLB:");
	metricvalues = metricvalues.replace("Macd Signal:", "MacdSignal:");
	metricvalues = metricvalues.replace("EMA 6", "ema06:");
	metricvalues = metricvalues.replace("EMA6", "ema06:");
	metricvalues = metricvalues.replace("EMA 200:", "ema200:");
	if (!metricvalues.contains("BBLB")) {
		metricvalues = metricvalues.replace("BBMB:", "BBLB:NotinGraph BBMB:");
	}

	if (!metricvalues.contains("BBUB")) {
		metricvalues = metricvalues.replace("BBLB:", "BBUB:NotinGraph BBLB:");
	}

	if (!metricvalues.contains("ema200:")) {
	
		metricvalues = metricvalues.replace("PSAR:", "ema200:0.0 PSAR:");
		
	}
//	userInput.clear();
//	userInput.sendKeys(scriptname.replace(" ", ""));
//	
//	Thread.sleep(2000);
//	userInput.sendKeys(Keys.ARROW_DOWN);
//	
//	userInput.sendKeys(Keys.ENTER);
//	userInput.sendKeys(Keys.TAB);

	Thread.sleep(3000);
	
	scriptcomments = stockRanking.getTextValue();
	
	scriptname = StringUtils.rightPad(scriptname, 12, " ");
	dailyMetrics = "DAILY  " + scriptname + " " + metricvalues + " "+ "scriptcomments:" + scriptcomments;
	metricvalues = " ";
	scriptname = " ";
	scriptcomments =" ";
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	userInput.clear();
	// dailyMetrics = "DAILY ACC Date:2020-06-02 Open:1282.00 High:1299.30
	// Low:1272.80 Close:1287.10 Volume:980515.00 BBUB:1307.97 BBLB:1098.14
	// BBMB:1203.05 ema20:1214.65 EMA06:1266.48 RSI:68.88 MACD:51.84
	// MacdSignal:44.81 ADX:38.53 PDI:33.14 MDI:9.46 ";
	System.out.println(dailyMetrics);

	String WeeklyorDaily = dailyMetrics.substring(0, 7);
	String StockName = dailyMetrics.substring(7, 20);
	String TradeDate = dailyMetrics.substring(25, 35);
	String OpenPriceDaily = dailyMetrics.substring(dailyMetrics.indexOf("Open:") + 5,dailyMetrics.indexOf("High:"));
	String HighPriceDaily = dailyMetrics.substring(dailyMetrics.indexOf("High:") + 5,
			dailyMetrics.indexOf("Low:"));
	String LowPriceDaily = dailyMetrics.substring(dailyMetrics.indexOf("Low:") + 4,
			dailyMetrics.indexOf("Close:"));
	String ClosePriceDaily = dailyMetrics.substring(dailyMetrics.indexOf("Close:") + 6,
			dailyMetrics.indexOf("Volume:"));
	String VolumeDaily = dailyMetrics.substring(dailyMetrics.indexOf("Volume:") + 7,
			dailyMetrics.indexOf("ema20:"));
	String ema20Daily = dailyMetrics.substring(dailyMetrics.indexOf("ema20:") + 6,dailyMetrics.indexOf("ema06::"));
	String ema06Daily = dailyMetrics.substring(dailyMetrics.indexOf("ema06::") + 7,dailyMetrics.indexOf("ema50:"));
	String ema50Daily = dailyMetrics.substring(dailyMetrics.indexOf("ema50:") + 6,dailyMetrics.indexOf("ema200:"));
	String ema200Daily = dailyMetrics.substring(dailyMetrics.indexOf("ema200:") + 7,dailyMetrics.indexOf("PSAR:"));
	String psar2006Daily = dailyMetrics.substring(dailyMetrics.indexOf("PSAR:") + 5, dailyMetrics.indexOf("Bollinger Bands Upper:"));
	String BBUBDaily = dailyMetrics.substring(dailyMetrics.indexOf("Bollinger Bands Upper:") + 22, dailyMetrics.indexOf("Middle:"));
	String BBMBDaily = dailyMetrics.substring(dailyMetrics.indexOf("Middle:") + 7, dailyMetrics.indexOf("Lower:"));
	String BBLBDaily = dailyMetrics.substring(dailyMetrics.indexOf("Lower:") + 6,dailyMetrics.indexOf("MACD:"));
	String MACDDaily = dailyMetrics.substring(dailyMetrics.indexOf("MACD:") + 5,dailyMetrics.indexOf("MacdSignal:"));
	String MacdSignalDaily = dailyMetrics.substring(dailyMetrics.indexOf("MacdSignal:") + 11,dailyMetrics.indexOf("RSI:"));
	String RSIDaily = dailyMetrics.substring(dailyMetrics.indexOf("RSI:") + 4, dailyMetrics.indexOf("ADX:"));
	String ADXDaily = dailyMetrics.substring(dailyMetrics.indexOf("ADX:") + 4, dailyMetrics.indexOf("PDI:"));
	String PDIDaily = dailyMetrics.substring(dailyMetrics.indexOf("PDI:") + 4, dailyMetrics.indexOf("MDI:"));
	String MDIDaily = dailyMetrics.substring(dailyMetrics.indexOf("MDI:") + 4, dailyMetrics.indexOf("scriptcomments:"));
	String ScriptComments = dailyMetrics.substring(dailyMetrics.indexOf("scriptcomments:") + 15, dailyMetrics.length());
//	 System.out.println("DailyorDaily	" + WeeklyorDaily);
//	 System.out.println("StockName	" + StockName);
//	 System.out.println("TradeDate	" + TradeDate);
//	 System.out.println("OpenPriceDaily	" + OpenPriceDaily);
//	 System.out.println("HighPriceDaily		" + HighPriceDaily);
//	 System.out.println("LowPriceDaily		" + LowPriceDaily);
//	 System.out.println("ClosePriceDaily	" + ClosePriceDaily);
//	 System.out.println("VolumeDaily		" + VolumeDaily);
//	 System.out.println("BBUBDaily			" + BBUBDaily);
//	 System.out.println("BBLBDaily			" + BBLBDaily);
//	 System.out.println("BBMBDaily			" + BBMBDaily);
//	 System.out.println("ema20Daily	" + ema20Daily);
//	 System.out.println("ema06Daily	" + ema06Daily);
//	 System.out.println("RSIDaily			" + RSIDaily);
//	 System.out.println("MACDDaily			" + MACDDaily);
//	 System.out.println("MacdSignalDaily	" + MacdSignalDaily);
//	 System.out.println("ADXDaily			" + ADXDaily);
//	 System.out.println("PDIDaily			" + PDIDaily);
//	 System.out.println("MDIDaily			" + MDIDaily);

	StockChartDailyData stockChartDailyData = new StockChartDailyData();

	stockChartDailyData.setWeeklyorDaily(WeeklyorDaily);
	stockChartDailyData.setStockName(StockName);
	stockChartDailyData.setTradeDate(TradeDate);
	stockChartDailyData.setOpenPriceDaily(OpenPriceDaily);
	stockChartDailyData.setHighPriceDaily(HighPriceDaily);
	stockChartDailyData.setLowPriceDaily(LowPriceDaily);
	stockChartDailyData.setClosePriceDaily(ClosePriceDaily);
	stockChartDailyData.setVolumeDaily(VolumeDaily);
	stockChartDailyData.setBBUBDaily(BBUBDaily);
	stockChartDailyData.setBBLBDaily(BBLBDaily);
	stockChartDailyData.setBBMBDaily(BBMBDaily);
	stockChartDailyData.setEma20Daily(ema20Daily);
	stockChartDailyData.setEma06Daily(ema06Daily);
	stockChartDailyData.setEma50Daily(ema50Daily);
	stockChartDailyData.setEma200Daily(ema200Daily);
	stockChartDailyData.setPsar2006Daily(psar2006Daily);
	stockChartDailyData.setRSIDaily(RSIDaily);
	stockChartDailyData.setMACDDaily(MACDDaily);
	stockChartDailyData.setMacdSignalDaily(MacdSignalDaily);
	stockChartDailyData.setADXDaily(ADXDaily);
	stockChartDailyData.setPDIDaily(PDIDaily);
	stockChartDailyData.setMDIDaily(MDIDaily);
	stockChartDailyData.setADXDaily(ADXDaily);
	stockChartDailyData.setScriptComments(ScriptComments.replace("%", " "));
	
	lststoryChartDailyData.add(stockChartDailyData);
	
	
	}

	}

	public void getweeklychartvalues() throws InterruptedException {

		String metricvalues = " ", scriptname = "";
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ChartLinkinNavBar.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mySettingsdropdown.click();

		mySettingsdropdown.selectByVisibleText("WeeklyChart");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int x = 1; x <= 1; x++)

		{

			myStockdropdown.click();

			myStockdropdown.selectByIndex(x);

			myStockdropdown.click();

			scriptname = myStockdropdown.getSelectedVisibleTextValue();
			

			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			usernavigation.click();

			WebDriver dailydriver = getDriver();

			Actions actionProvider = new Actions(dailydriver);

			 actionProvider.moveToElement(usernavigation).moveByOffset(870, 0).click().build().perform();
			
			//actionProvider.moveToElement(usernavigation).moveByOffset(655, 0).click().build().perform();
			
			//actionProvider.moveToElement(usernavigation).moveByOffset(540, 0).click().build().perform();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			metricvalues = userSelectedValues.getTextValue();

			metricvalues = metricvalues.replace("BB UB:", "BBUB:");
			metricvalues = metricvalues.replace("BB MB:", "BBMB:");
			metricvalues = metricvalues.replace("BB LB:", "BBLB:");
			metricvalues = metricvalues.replace("Macd Signal:", "MacdSignal:");
			metricvalues = metricvalues.replace("EMA 6", "ema06");
			metricvalues = metricvalues.replace("EMA6", "ema06");
			metricvalues = metricvalues.replace("ema 6", "ema06");
			metricvalues = metricvalues.replace("ema6", "ema06");
			metricvalues = metricvalues.replace("EMA 200", "EMA200");

			if (!metricvalues.contains("BBLB")) {
				metricvalues = metricvalues.replace("BBMB:", "BBLB:NotinGraph BBMB:");
			}

			if (!metricvalues.contains("BBUB")) {
				metricvalues = metricvalues.replace("BBLB:", "BBUB:NotinGraph BBLB:");
			}

			
			if (!metricvalues.contains("EMA200:")) {
				
				metricvalues = metricvalues.replace("PSAR:", "EMA200:0.0 PSAR:");
				
			}
			
			if (!metricvalues.contains("ema50:")) {
				
				metricvalues = metricvalues.replace("EMA200:", "ema50:0.0 EMA200:");
				
			}
		
			
			scriptname = StringUtils.rightPad(scriptname, 12, " ");

			weeklyMetrics = "WEEKLY  " + scriptname + " " + metricvalues;

			System.out.println(weeklyMetrics);

			metricvalues = " ";
			scriptname = "";

			String WeeklyorDaily = weeklyMetrics.substring(0, 8);
			String StockName = weeklyMetrics.substring(8, 20);
			String WeekDate = weeklyMetrics.substring(26, 36);
			String OpenPriceWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Open:") + 5,weeklyMetrics.indexOf("High:"));
			String HighPriceWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("High:") + 5,
					weeklyMetrics.indexOf("Low:"));
			String LowPriceWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Low:") + 4,
					weeklyMetrics.indexOf("Close:"));
			String ClosePriceWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Close:") + 6,
					weeklyMetrics.indexOf("Volume:"));
			String VolumeWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Volume:") + 7,
					weeklyMetrics.indexOf("ema20:"));
			String ema20Weekly = weeklyMetrics.substring(weeklyMetrics.indexOf("ema20:") + 6,weeklyMetrics.indexOf("ema06:"));
			String ema06Weekly = weeklyMetrics.substring(weeklyMetrics.indexOf("ema06:") + 6,weeklyMetrics.indexOf("ema50:"));
			String ema50Weekly = weeklyMetrics.substring(weeklyMetrics.indexOf("ema50:") + 6,weeklyMetrics.indexOf("EMA200:"));
			String ema200Weekly = weeklyMetrics.substring(weeklyMetrics.indexOf("EMA200:") + 7,weeklyMetrics.indexOf("PSAR:"));
			String psar2006Weekly = weeklyMetrics.substring(weeklyMetrics.indexOf("PSAR:") + 5, weeklyMetrics.indexOf("Bollinger Bands Upper:"));
			String BBUBWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Bollinger Bands Upper:") + 22, weeklyMetrics.indexOf("Middle:"));
			String BBMBWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Middle:") + 7, weeklyMetrics.indexOf("Lower:"));
			String BBLBWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Lower:") + 6,weeklyMetrics.indexOf("MACD:"));
			String MACDWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("MACD:") + 5,weeklyMetrics.indexOf("MacdSignal:"));
			String MacdSignalWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("MacdSignal:") + 11,weeklyMetrics.indexOf("RSI:"));
			String RSIWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("RSI:") + 4, weeklyMetrics.indexOf("ADX:"));
			String ADXWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("ADX:") + 4, weeklyMetrics.indexOf("PDI:"));
			String PDIWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("PDI:") + 4, weeklyMetrics.indexOf("MDI:"));
			String MDIWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("MDI:") + 4, weeklyMetrics.length());
		

//			 System.out.println("WeeklyorDaily	" + WeeklyorDaily);
//			 System.out.println("StockName	" + StockName);
//			 System.out.println("TradeDate	" + WeekDate);
//			 System.out.println("OpenPriceWeekly	" + OpenPriceWeekly);
//			 System.out.println("HighPriceWeekly		" + HighPriceWeekly);
//			 System.out.println("LowPriceWeekly		" + LowPriceWeekly);
//			 System.out.println("ClosePriceWeekly	" + ClosePriceWeekly);
//			 System.out.println("VolumeWeekly		" + VolumeWeekly);
//			 System.out.println("BBUBWeekly			" + BBUBWeekly);
//			 System.out.println("BBLBWeekly			" + BBLBWeekly);
//			 System.out.println("BBMBWeekly			" + BBMBWeekly);
//			 System.out.println("ema20Weekly	" + ema20Weekly);
//			 System.out.println("ema06Weekly	" + ema06Weekly);
//			 System.out.println("RSIWeekly			" + RSIWeekly);
//			 System.out.println("MACDWeekly			" + MACDWeekly);
//			 System.out.println("MacdSignalWeekly	" + MacdSignalWeekly);
//			 System.out.println("ADXWeekly			" + ADXWeekly);
//			 System.out.println("PDIWeekly			" + PDIWeekly);
//			 System.out.println("MDIWeekly			" + MDIWeekly);

			StockChartWeeklyData stockChartWeeklyData = new StockChartWeeklyData();

			stockChartWeeklyData.setWeeklyorDaily(WeeklyorDaily);
			stockChartWeeklyData.setStockName(StockName);
			stockChartWeeklyData.setWeekDate(WeekDate);
			stockChartWeeklyData.setOpenPriceWeekly(OpenPriceWeekly);
			stockChartWeeklyData.setHighPriceWeekly(HighPriceWeekly);
			stockChartWeeklyData.setLowPriceWeekly(LowPriceWeekly);
			stockChartWeeklyData.setClosePriceWeekly(ClosePriceWeekly);
			stockChartWeeklyData.setVolumeWeekly(VolumeWeekly);
			stockChartWeeklyData.setBBUBWeekly(BBUBWeekly);
			stockChartWeeklyData.setBBLBWeekly(BBLBWeekly);
			stockChartWeeklyData.setBBMBWeekly(BBMBWeekly);
			stockChartWeeklyData.setEma20Weekly(ema20Weekly);
			stockChartWeeklyData.setEma06Weekly(ema06Weekly);
			stockChartWeeklyData.setEma50Weekly(ema50Weekly);
			stockChartWeeklyData.setEma200Weekly(ema200Weekly);
			stockChartWeeklyData.setPsar2006Weekly(psar2006Weekly);
			stockChartWeeklyData.setRSIWeekly(RSIWeekly);
			stockChartWeeklyData.setMACDWeekly(MACDWeekly);
			stockChartWeeklyData.setMacdSignalWeekly(MacdSignalWeekly);
			stockChartWeeklyData.setADXWeekly(ADXWeekly);
			stockChartWeeklyData.setPDIWeekly(PDIWeekly);
			stockChartWeeklyData.setMDIWeekly(MDIWeekly);
			stockChartWeeklyData.setADXWeekly(ADXWeekly);

			lststoryChartWeeklyData.add(stockChartWeeklyData);

		}

// for loop for new stocks weekly
		for (String a : lsttrackhitstocks) {
			
			userInput.clear(); 
			Thread.sleep(2000);
	
			
			userInput.sendKeys(a);
			Thread.sleep(2000);
			userInput.sendKeys(Keys.ARROW_DOWN);
			userInput.sendKeys(Keys.ENTER);
			userInput.sendKeys(Keys.TAB);
			
			
			scriptname = a;
			
			usernavigation.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

			WebDriver dailydriver = getDriver();

			Actions actionProvider = new Actions(dailydriver);

			 actionProvider.moveToElement(usernavigation).moveByOffset(870, 0).click().build().perform();
			
			//actionProvider.moveToElement(usernavigation).moveByOffset(655, 0).click().build().perform();
			
			//actionProvider.moveToElement(usernavigation).moveByOffset(540, 0).click().build().perform();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			metricvalues = userSelectedValues.getTextValue();

			metricvalues = metricvalues.replace("BB UB:", "BBUB:");
			metricvalues = metricvalues.replace("BB MB:", "BBMB:");
			metricvalues = metricvalues.replace("BB LB:", "BBLB:");
			metricvalues = metricvalues.replace("Macd Signal:", "MacdSignal:");
			metricvalues = metricvalues.replace("EMA 6", "ema06");
			metricvalues = metricvalues.replace("EMA6", "ema06");
			metricvalues = metricvalues.replace("ema 6", "ema06");
			metricvalues = metricvalues.replace("ema6", "ema06");
			metricvalues = metricvalues.replace("EMA 200", "EMA200");

			if (!metricvalues.contains("BBLB")) {
				metricvalues = metricvalues.replace("BBMB:", "BBLB:NotinGraph BBMB:");
			}

			if (!metricvalues.contains("BBUB")) {
				metricvalues = metricvalues.replace("BBLB:", "BBUB:NotinGraph BBLB:");
			}

			
			if (!metricvalues.contains("EMA200:")) {
				
				metricvalues = metricvalues.replace("PSAR:", "EMA200:0.0 PSAR:");
				
			}
			
			if (!metricvalues.contains("ema50:")) {
				
				metricvalues = metricvalues.replace("EMA200:", "ema50:0.0 EMA200:");
				
			}
		
			
			scriptname = StringUtils.rightPad(scriptname, 12, " ");

			weeklyMetrics = "WEEKLY  " + scriptname + " " + metricvalues;

			System.out.println(weeklyMetrics);

			metricvalues = " ";
			scriptname = "";

			String WeeklyorDaily = weeklyMetrics.substring(0, 8);
			String StockName = weeklyMetrics.substring(8, 20);
			String WeekDate = weeklyMetrics.substring(26, 36);
			String OpenPriceWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Open:") + 5,weeklyMetrics.indexOf("High:"));
			String HighPriceWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("High:") + 5,
					weeklyMetrics.indexOf("Low:"));
			String LowPriceWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Low:") + 4,
					weeklyMetrics.indexOf("Close:"));
			String ClosePriceWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Close:") + 6,
					weeklyMetrics.indexOf("Volume:"));
			String VolumeWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Volume:") + 7,
					weeklyMetrics.indexOf("ema20:"));
			String ema20Weekly = weeklyMetrics.substring(weeklyMetrics.indexOf("ema20:") + 6,weeklyMetrics.indexOf("ema06:"));
			String ema06Weekly = weeklyMetrics.substring(weeklyMetrics.indexOf("ema06:") + 6,weeklyMetrics.indexOf("ema50:"));
			String ema50Weekly = weeklyMetrics.substring(weeklyMetrics.indexOf("ema50:") + 6,weeklyMetrics.indexOf("EMA200:"));
			String ema200Weekly = weeklyMetrics.substring(weeklyMetrics.indexOf("EMA200:") + 7,weeklyMetrics.indexOf("PSAR:"));
			String psar2006Weekly = weeklyMetrics.substring(weeklyMetrics.indexOf("PSAR:") + 5, weeklyMetrics.indexOf("Bollinger Bands Upper:"));
			String BBUBWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Bollinger Bands Upper:") + 22, weeklyMetrics.indexOf("Middle:"));
			String BBMBWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Middle:") + 7, weeklyMetrics.indexOf("Lower:"));
			String BBLBWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("Lower:") + 6,weeklyMetrics.indexOf("MACD:"));
			String MACDWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("MACD:") + 5,weeklyMetrics.indexOf("MacdSignal:"));
			String MacdSignalWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("MacdSignal:") + 11,weeklyMetrics.indexOf("RSI:"));
			String RSIWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("RSI:") + 4, weeklyMetrics.indexOf("ADX:"));
			String ADXWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("ADX:") + 4, weeklyMetrics.indexOf("PDI:"));
			String PDIWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("PDI:") + 4, weeklyMetrics.indexOf("MDI:"));
			String MDIWeekly = weeklyMetrics.substring(weeklyMetrics.indexOf("MDI:") + 4, weeklyMetrics.length());
		

//			 System.out.println("WeeklyorDaily	" + WeeklyorDaily);
//			 System.out.println("StockName	" + StockName);
//			 System.out.println("TradeDate	" + WeekDate);
//			 System.out.println("OpenPriceWeekly	" + OpenPriceWeekly);
//			 System.out.println("HighPriceWeekly		" + HighPriceWeekly);
//			 System.out.println("LowPriceWeekly		" + LowPriceWeekly);
//			 System.out.println("ClosePriceWeekly	" + ClosePriceWeekly);
//			 System.out.println("VolumeWeekly		" + VolumeWeekly);
//			 System.out.println("BBUBWeekly			" + BBUBWeekly);
//			 System.out.println("BBLBWeekly			" + BBLBWeekly);
//			 System.out.println("BBMBWeekly			" + BBMBWeekly);
//			 System.out.println("ema20Weekly	" + ema20Weekly);
//			 System.out.println("ema06Weekly	" + ema06Weekly);
//			 System.out.println("RSIWeekly			" + RSIWeekly);
//			 System.out.println("MACDWeekly			" + MACDWeekly);
//			 System.out.println("MacdSignalWeekly	" + MacdSignalWeekly);
//			 System.out.println("ADXWeekly			" + ADXWeekly);
//			 System.out.println("PDIWeekly			" + PDIWeekly);
//			 System.out.println("MDIWeekly			" + MDIWeekly);

			StockChartWeeklyData stockChartWeeklyData = new StockChartWeeklyData();

			stockChartWeeklyData.setWeeklyorDaily(WeeklyorDaily);
			stockChartWeeklyData.setStockName(StockName);
			stockChartWeeklyData.setWeekDate(WeekDate);
			stockChartWeeklyData.setOpenPriceWeekly(OpenPriceWeekly);
			stockChartWeeklyData.setHighPriceWeekly(HighPriceWeekly);
			stockChartWeeklyData.setLowPriceWeekly(LowPriceWeekly);
			stockChartWeeklyData.setClosePriceWeekly(ClosePriceWeekly);
			stockChartWeeklyData.setVolumeWeekly(VolumeWeekly);
			stockChartWeeklyData.setBBUBWeekly(BBUBWeekly);
			stockChartWeeklyData.setBBLBWeekly(BBLBWeekly);
			stockChartWeeklyData.setBBMBWeekly(BBMBWeekly);
			stockChartWeeklyData.setEma20Weekly(ema20Weekly);
			stockChartWeeklyData.setEma06Weekly(ema06Weekly);
			stockChartWeeklyData.setEma50Weekly(ema50Weekly);
			stockChartWeeklyData.setEma200Weekly(ema200Weekly);
			stockChartWeeklyData.setPsar2006Weekly(psar2006Weekly);
			stockChartWeeklyData.setRSIWeekly(RSIWeekly);
			stockChartWeeklyData.setMACDWeekly(MACDWeekly);
			stockChartWeeklyData.setMacdSignalWeekly(MacdSignalWeekly);
			stockChartWeeklyData.setADXWeekly(ADXWeekly);
			stockChartWeeklyData.setPDIWeekly(PDIWeekly);
			stockChartWeeklyData.setMDIWeekly(MDIWeekly);
			stockChartWeeklyData.setADXWeekly(ADXWeekly);

			lststoryChartWeeklyData.add(stockChartWeeklyData);
			
			
		}

	}

	public void saveweeklychartvalues() {

//		String fileName = "WeeklyData.xlsx";
		File file = new File("c://Selenium//WeeklyData.xlsx");

		Workbook weeklyworkBook = null;
		FileInputStream weeklyfileInputStream = null;

		// System.out.println(file);

		try {

			weeklyfileInputStream = new FileInputStream(file);
			weeklyworkBook = new XSSFWorkbook(weeklyfileInputStream);

		} catch (IOException e1)

		{
			e1.printStackTrace();
		}

		Sheet sheet = weeklyworkBook.getSheet("Data");

		// Get the current count of rows in excel file

//		int rCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Get the first row from the sheet

		Row row = sheet.getRow(0);

		// Create a new row and append it at last of sheet

		// Create a loop over the cell of newly created Row

		for (int rowCount = 0; rowCount < lststoryChartWeeklyData.size(); rowCount++) {

			Row newRow = sheet.createRow(rowCount + 1);

			{

				// Fill data in row

				Cell cell = newRow.createCell(0);
				cell.setCellValue(lststoryChartWeeklyData.get(rowCount).getWeeklyorDaily());

				Cell cell1 = newRow.createCell(1);
				cell1.setCellValue(lststoryChartWeeklyData.get(rowCount).getStockName());

				Cell cell2 = newRow.createCell(2);
				cell2.setCellValue(lststoryChartWeeklyData.get(rowCount).getWeekDate());

				Cell cell3 = newRow.createCell(3);
				cell3.setCellValue(lststoryChartWeeklyData.get(rowCount).getOpenPriceWeekly());

				Cell cell4 = newRow.createCell(4);
				cell4.setCellValue(lststoryChartWeeklyData.get(rowCount).getHighPriceWeekly());

				Cell cell5 = newRow.createCell(5);
				cell5.setCellValue(lststoryChartWeeklyData.get(rowCount).getLowPriceWeekly());

				Cell cell6 = newRow.createCell(6);
				cell6.setCellValue(lststoryChartWeeklyData.get(rowCount).getClosePriceWeekly());

				Cell cell7 = newRow.createCell(7);
				cell7.setCellValue(lststoryChartWeeklyData.get(rowCount).getVolumeWeekly());

				Cell cell8 = newRow.createCell(8);
				cell8.setCellValue(lststoryChartWeeklyData.get(rowCount).getBBUBWeekly());

				Cell cell9 = newRow.createCell(9);
				cell9.setCellValue(lststoryChartWeeklyData.get(rowCount).getBBLBWeekly());

				Cell cell10 = newRow.createCell(10);
				cell10.setCellValue(lststoryChartWeeklyData.get(rowCount).getBBMBWeekly());

				Cell cell11 = newRow.createCell(11);
				cell11.setCellValue(lststoryChartWeeklyData.get(rowCount).getEma20Weekly());

				Cell cell12 = newRow.createCell(12);
				cell12.setCellValue(lststoryChartWeeklyData.get(rowCount).getEma06Weekly());

				Cell cell13 = newRow.createCell(13);
				cell13.setCellValue(lststoryChartWeeklyData.get(rowCount).getRSIWeekly());

				Cell cell14 = newRow.createCell(14);
				cell14.setCellValue(lststoryChartWeeklyData.get(rowCount).getMACDWeekly());

				Cell cell15 = newRow.createCell(15);
				cell15.setCellValue(lststoryChartWeeklyData.get(rowCount).getMacdSignalWeekly());

				Cell cell16 = newRow.createCell(16);
				cell16.setCellValue(lststoryChartWeeklyData.get(rowCount).getADXWeekly());

				Cell cell17 = newRow.createCell(17);
				cell17.setCellValue(lststoryChartWeeklyData.get(rowCount).getPDIWeekly());

				Cell cell18 = newRow.createCell(18);
				cell18.setCellValue(lststoryChartWeeklyData.get(rowCount).getMDIWeekly());
				
				Cell cell19 = newRow.createCell(19);
				cell19.setCellValue(lststoryChartWeeklyData.get(rowCount).getEma50Weekly());

				Cell cell20 = newRow.createCell(20);
				cell20.setCellValue(lststoryChartWeeklyData.get(rowCount).getEma200Weekly());
				
				Cell cell21 = newRow.createCell(21);
				cell21.setCellValue(lststoryChartWeeklyData.get(rowCount).getPsar2006Weekly());
			}

			// Close input stream

			try {
				weeklyfileInputStream.close();

				// Create an object of FileOutputStream class to create write data in excel file

				FileOutputStream weeklyOutputStream = new FileOutputStream(file);

				// write data in the excel file

				weeklyworkBook.write(weeklyOutputStream);

				// close output stream

				weeklyOutputStream.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void savedailychartvalues() {

		//String fileName = "DailyData.xlsx";
		File file = new File("c://Selenium//DailyData.xlsx");

		Workbook dailyworkBook = null;
		FileInputStream dailyfileInputStream = null;

		// System.out.println(file);

		try {

			dailyfileInputStream = new FileInputStream(file);
			dailyworkBook = new XSSFWorkbook(dailyfileInputStream);

		} catch (IOException e1)

		{
			e1.printStackTrace();
		}

		Sheet sheet = dailyworkBook.getSheet("Data");

		// Get the current count of rows in excel file

//		int rCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Get the first row from the sheet

		Row row = sheet.getRow(0);

		// Create a new row and append it at last of sheet

		// Create a loop over the cell of newly created Row

		for (int rowCount = 0; rowCount < lststoryChartDailyData.size(); rowCount++) {

			Row newRow = sheet.createRow(rowCount + 1);

			{

				// Fill data in row

				Cell cell = newRow.createCell(0);
				cell.setCellValue(lststoryChartDailyData.get(rowCount).getWeeklyorDaily());

				Cell cell1 = newRow.createCell(1);
				cell1.setCellValue(lststoryChartDailyData.get(rowCount).getStockName());

				Cell cell2 = newRow.createCell(2);
				cell2.setCellValue(lststoryChartDailyData.get(rowCount).getTradeDate());

				Cell cell3 = newRow.createCell(3);
				cell3.setCellValue(lststoryChartDailyData.get(rowCount).getOpenPriceDaily());

				Cell cell4 = newRow.createCell(4);
				cell4.setCellValue(lststoryChartDailyData.get(rowCount).getHighPriceDaily());

				Cell cell5 = newRow.createCell(5);
				cell5.setCellValue(lststoryChartDailyData.get(rowCount).getLowPriceDaily());

				Cell cell6 = newRow.createCell(6);
				cell6.setCellValue(lststoryChartDailyData.get(rowCount).getClosePriceDaily());

				Cell cell7 = newRow.createCell(7);
				cell7.setCellValue(lststoryChartDailyData.get(rowCount).getVolumeDaily());

				Cell cell8 = newRow.createCell(8);
				cell8.setCellValue(lststoryChartDailyData.get(rowCount).getBBUBDaily());

				Cell cell9 = newRow.createCell(9);
				cell9.setCellValue(lststoryChartDailyData.get(rowCount).getBBLBDaily());

				Cell cell10 = newRow.createCell(10);
				cell10.setCellValue(lststoryChartDailyData.get(rowCount).getBBMBDaily());

				Cell cell11 = newRow.createCell(11);
				cell11.setCellValue(lststoryChartDailyData.get(rowCount).getEma20Daily());

				Cell cell12 = newRow.createCell(12);
				cell12.setCellValue(lststoryChartDailyData.get(rowCount).getEma06Daily());

				Cell cell13 = newRow.createCell(13);
				cell13.setCellValue(lststoryChartDailyData.get(rowCount).getRSIDaily());

				Cell cell14 = newRow.createCell(14);
				cell14.setCellValue(lststoryChartDailyData.get(rowCount).getMACDDaily());

				Cell cell15 = newRow.createCell(15);
				cell15.setCellValue(lststoryChartDailyData.get(rowCount).getMacdSignalDaily());

				Cell cell16 = newRow.createCell(16);
				cell16.setCellValue(lststoryChartDailyData.get(rowCount).getADXDaily());

				Cell cell17 = newRow.createCell(17);
				cell17.setCellValue(lststoryChartDailyData.get(rowCount).getPDIDaily());

				Cell cell18 = newRow.createCell(18);
				cell18.setCellValue(lststoryChartDailyData.get(rowCount).getMDIDaily());
				
				Cell cell19 = newRow.createCell(19);
				cell19.setCellValue(lststoryChartDailyData.get(rowCount).getScriptComments());
								
				Cell cell20 = newRow.createCell(20);
				cell20.setCellValue(lststoryChartDailyData.get(rowCount).getEma50Daily());

				Cell cell21 = newRow.createCell(21);
				cell21.setCellValue(lststoryChartDailyData.get(rowCount).getEma200Daily());
				
				Cell cell22 = newRow.createCell(22);
				cell22.setCellValue(lststoryChartDailyData.get(rowCount).getPsar2006Daily());
			}

			// Close input stream

			try {
				dailyfileInputStream.close();

				// Create an object of FileOutputStream class to create write data in excel file

				FileOutputStream dailyOutputStream = new FileOutputStream(file);

				// write data in the excel file

				dailyworkBook.write(dailyOutputStream);

				// close output stream

				dailyOutputStream.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public String getWeeklyMetrics() {
		return weeklyMetrics;
	}

	public void setWeeklyMetrics(String weeklyMetrics) {
		this.weeklyMetrics = weeklyMetrics;
	}

	public String getDailyMetrics() {
		return dailyMetrics;
	}

	public void setDailyMetrics(String dailyMetrics) {
		this.dailyMetrics = dailyMetrics;
	}

	public static List<StockChartDailyData> getlistdailyData() {

	//	// System.out.println("returning " + lststoryChartDailyData.size() + "Records");

		return lststoryChartDailyData;
	}

	public static List<StockChartWeeklyData> getlistWeeklyData() {
	//	// System.out.println("returning " + lststoryChartWeeklyData.size() + "Records");
		return lststoryChartWeeklyData;
	}

	

}
