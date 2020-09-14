package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://my.topstockresearch.com/")
public class TopstockresearchChartPage extends PageObject {
		
	@FindBy(xpath = "//input[@id=\"chartStkchg\"]")
	WebElementFacade userInput;
	
	@FindBy(xpath="//select[@id=\"freq\"]")
	WebElementFacade userFrequency;
	
	@FindBy(xpath="//div[@id=\"selectedValues\"]")
	WebElementFacade userSelectedValues;
	
	@FindBy(id="myStocks")
	WebElementFacade myStockdropdown;
	
	@FindBy(xpath= "//div[@id=\"navbarSupportedContent\"]//a[contains(@href, '#Chart')]")
	WebElementFacade ChartLinkinNavBar;
	
	@FindBy(xpath="//div [@id=\"tsrchart\"]")
	WebElementFacade usernavigation;
	
	@FindBy(xpath= "//*[@id=\"mySettings\"]")
	WebElementFacade mySettingsdropdown;
	
	@FindBy(xpath="//*[@id=\"chartControls\"]/div[1]/form/input[4]")
	WebElementFacade saveButton;
	
	@FindBy(xpath="//*[@id=\"tsrchart\"]/svg/g/text[1]")
	WebElementFacade companyName;

	@FindBy(xpath="//*[@id=\"ppLines\"]")
	WebElementFacade pivotlineslink;  
	
	@FindBy(xpath="//*[@id=\"tsrchart\"]/svg/g/g[1]/g[6]/text")
	WebElementFacade clickonchart;
	
	public String  weeklyMetrics = "WEEKLY  ASHOKLEY     Date:2020-09-11  Open:70.50  High:71.65  Low:64.15  Close:68.15  Volume:152.880M  BBUB:71.27  BBLB:36.78  BBMB:54.03  ema20:58.73  ema6:65.11  RSI:74.03  MACD:6.38  MacdSignal:3.49  ADX:27.91  PDI:31.23  MDI:15.78  "; 
	public String  dailyMetrics = "DAILY   ADANIENT     Date:2020-09-11  Open:299.00  High:303.65  Low:292.10  Close:296.00  Volume:9.740M  BBUB:NotinGraph BBLB:210.23  BBMB:270.28  ema20:267.70  ema5:290.76  RSI:66.40  MACD:22.07  MacdSignal:24.99  ADX:57.04  PDI:34.15  MDI:10.98  "; 
	
	
	public void getUserSelectedDailyValues(String stockname) throws InterruptedException
	{
		userInput.clear();
		userInput.sendKeys(stockname);
		Thread.sleep(1000);
		userInput.sendKeys(Keys.ARROW_DOWN);
		userInput.sendKeys(Keys.ENTER);
		userInput.sendKeys(Keys.TAB);
		
		
	}



	public void getdailychartvalues() {
			
		String metricvalues =" ", scriptname ="";
		
		ChartLinkinNavBar.click();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mySettingsdropdown.click();
		
		mySettingsdropdown.selectByVisibleText("DailyChart");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int x = 1  ;x < 10 ; x++)
		
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
					
		WebDriver dailydriver = getDriver();
	
		Actions actionProvider = new Actions(dailydriver);
		
		actionProvider.moveToElement(usernavigation).moveByOffset(602, 20).click().build().perform();
				
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		metricvalues = userSelectedValues.getTextValue();
		
		metricvalues = metricvalues.replace("BB UB:", "BBUB:");
		metricvalues = metricvalues.replace("BB MB:", "BBMB:");
		metricvalues = metricvalues.replace("BB LB:", "BBLB:");
		metricvalues = metricvalues.replace("Macd Signal:", "MacdSignal:");
		
		if (!metricvalues.contains("BBUB"))
		{
			metricvalues = metricvalues.replace("BBLB:", "BBUB:NotinGraph BBLB:");
		}
		
		if (!metricvalues.contains("BBLB"))
		{
			metricvalues = metricvalues.replace("BBMB:", "BBLB:NotinGraph BBMB:");
		}
		
		
		
		scriptname = StringUtils.rightPad(scriptname, 12, " ") ;
		
		dailyMetrics = "DAILY  " + scriptname + " " + metricvalues ;
		
		System.out.println(dailyMetrics);
		
		metricvalues =" "; scriptname ="";
	  
		}
		

//		//actionProvider.moveToElement(userSelectedValues).perform();
//
//		int xOffset = 100;
//		int yOffset = 200;
//
//		// Perform click-and-hold action on the element
//		actionProvider.moveToElement(saveButton).perform();
//
//		int targetEleXOffset = saveButton.getLocation().getX();
//		int targetEleYOffset = saveButton.getLocation().getY();
//
//		System.out.println("targetEleXOffset is" + targetEleXOffset + "targetEleYOffset" + targetEleYOffset);

		
		
	}



	public void getweeklychartvalues() {
		
			
			String metricvalues =" ", scriptname ="";
			
			ChartLinkinNavBar.click();
			
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mySettingsdropdown.click();
			
			mySettingsdropdown.selectByVisibleText("WeeklyChart");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			for (int x = 1  ;x < 10 ; x++)
			
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
						
			WebDriver dailydriver = getDriver();
		
			Actions actionProvider = new Actions(dailydriver);
			
			actionProvider.moveToElement(usernavigation).moveByOffset(600, 20).click().build().perform();

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			metricvalues = userSelectedValues.getTextValue();
			
			metricvalues = metricvalues.replace("BB UB:", "BBUB:");
			metricvalues = metricvalues.replace("BB MB:", "BBMB:");
			metricvalues = metricvalues.replace("BB LB:", "BBLB:");
			metricvalues = metricvalues.replace("Macd Signal:", "MacdSignal:");
			
			if (!metricvalues.contains("BBUB"))
			{
				metricvalues = metricvalues.replace("BBLB:", "BBUB:NotinGraph BBLB:");
			}
			
			if (!metricvalues.contains("BBLB"))
			{
				metricvalues = metricvalues.replace("BBMB:", "BBLB:NotinGraph BBMB:");
			}
			
			scriptname = StringUtils.rightPad(scriptname, 12, " ") ;
			
			weeklyMetrics = "WEEKLY  " + scriptname + " " + metricvalues ;
			
			System.out.println(weeklyMetrics);
			
			metricvalues =" "; scriptname ="";
		  
			}
			
//			actionProvider.moveToElement(userSelectedValues).perform();
//			int xOffset = 100;
//			int yOffset = 200;
//
//			Perform click-and-hold action on the element
//			actionProvider.moveToElement(saveButton).perform();
//
//			int targetEleXOffset = saveButton.getLocation().getX();
//			int targetEleYOffset = saveButton.getLocation().getY();
//
//			System.out.println("targetEleXOffset is" + targetEleXOffset + "targetEleYOffset" + targetEleYOffset);
//
			
	}



	public void saveweeklychartvalues() {

		String	WeeklyorDaily 		= weeklyMetrics.substring(0, 8);	
		String	StockName 			= weeklyMetrics.substring(8, 20);	
		String	WeekDate			= weeklyMetrics.substring(26, 36);	
		String	OpenPriceWeekly 	= weeklyMetrics.substring(weeklyMetrics.indexOf("Open:") + 5 , weeklyMetrics.indexOf("High:"));
		String	HighPriceWeekly		= weeklyMetrics.substring(weeklyMetrics.indexOf("High:") + 5 , weeklyMetrics.indexOf("Low:")); 
		String	LowPriceWeekly		= weeklyMetrics.substring(weeklyMetrics.indexOf("Low:") + 4 , weeklyMetrics.indexOf("Close:"));
		String	ClosePriceWeekly	= weeklyMetrics.substring(weeklyMetrics.indexOf("Close:") + 6 , weeklyMetrics.indexOf("Volume:"));
		String	VolumeWeekly		= weeklyMetrics.substring(weeklyMetrics.indexOf("Volume:") + 7 , weeklyMetrics.indexOf("BBUB:"));
		String	BBUBWeekly			= weeklyMetrics.substring(weeklyMetrics.indexOf("BBUB:") + 5 , weeklyMetrics.indexOf("BBLB:"));
		String	BBLBWeekly			= weeklyMetrics.substring(weeklyMetrics.indexOf("BBLB:") + 5 , weeklyMetrics.indexOf("BBMB:"));
		String	BBMBWeekly			= weeklyMetrics.substring(weeklyMetrics.indexOf("BBMB:") + 5 , weeklyMetrics.indexOf("ema20:"));
		String  ema20Weekly     	= weeklyMetrics.substring(weeklyMetrics.indexOf("ema20:") + 6 , weeklyMetrics.indexOf("ema6:"));
		String  ema06Weekly     	= weeklyMetrics.substring(weeklyMetrics.indexOf("ema6:") + 6 , weeklyMetrics.indexOf("RSI:"));
		String	RSIWeekly			= weeklyMetrics.substring(weeklyMetrics.indexOf("RSI:") + 4 , weeklyMetrics.indexOf("MACD:"));
		String	MACDWeekly			= weeklyMetrics.substring(weeklyMetrics.indexOf("MACD:") + 5 , weeklyMetrics.indexOf("MacdSignal:"));
		String	MacdSignalWeekly	= weeklyMetrics.substring(weeklyMetrics.indexOf("MacdSignal:") + 11 , weeklyMetrics.indexOf("ADX:"));
		String	ADXWeekly			= weeklyMetrics.substring(weeklyMetrics.indexOf("ADX:") + 4 , weeklyMetrics.indexOf("PDI:"));
		String	PDIWeekly			= weeklyMetrics.substring(weeklyMetrics.indexOf("PDI:") + 4 , weeklyMetrics.indexOf("MDI:"));
		String	MDIWeekly			= weeklyMetrics.substring(weeklyMetrics.indexOf("MDI:") + 4 , weeklyMetrics.length());
		
		
		System.out.println("WeeklyorDaily	" +	WeeklyorDaily)	;
		System.out.println("StockName	" +	StockName	);
		System.out.println("WeekDate	" +	WeekDate			);
		System.out.println("OpenPriceWeekly	" +	OpenPriceWeekly	);
		System.out.println("HighPriceWeekly		" +	HighPriceWeekly		);
		System.out.println("LowPriceWeekly		" +	LowPriceWeekly		);
		System.out.println("ClosePriceWeekly	" +	ClosePriceWeekly	);
		System.out.println("VolumeWeekly		" +	VolumeWeekly		);
		System.out.println("BBUBWeekly			" +	BBUBWeekly			);
		System.out.println("BBLBWeekly			" +	BBLBWeekly		);
		System.out.println("BBMBWeekly			" +	BBMBWeekly);
		System.out.println("ema20Weekly	" +	ema20Weekly	);
		System.out.println("ema06Weekly	" +	ema06Weekly	);
		System.out.println("RSIWeekly			" +	RSIWeekly);
		System.out.println("MACDWeekly			" +	MACDWeekly);
		System.out.println("MacdSignalWeekly	" + MacdSignalWeekly	);
		System.out.println("ADXWeekly			" +	ADXWeekly			);
		System.out.println("PDIWeekly			" +	PDIWeekly			);
		System.out.println("MDIWeekly			" +	MDIWeekly			);

		
	}



	public void savedailychartvalues() {
	
		String	WeeklyorDaily 		= dailyMetrics.substring(0, 8);	
		String	StockName 			= dailyMetrics.substring(8, 20);	
		String	TradeDate			= dailyMetrics.substring(26, 36);	
		String	OpenPriceDaily 		= dailyMetrics.substring(dailyMetrics.indexOf("Open:") + 5 , dailyMetrics.indexOf("High:"));
		String	HighPriceDaily		= dailyMetrics.substring(dailyMetrics.indexOf("High:") + 5 , dailyMetrics.indexOf("Low:")); 
		String	LowPriceDaily		= dailyMetrics.substring(dailyMetrics.indexOf("Low:") + 4 , dailyMetrics.indexOf("Close:"));
		String	ClosePriceDaily		= dailyMetrics.substring(dailyMetrics.indexOf("Close:") + 6 , dailyMetrics.indexOf("Volume:"));
		String	VolumeDaily			= dailyMetrics.substring(dailyMetrics.indexOf("Volume:") + 7 , dailyMetrics.indexOf("BBUB:"));
		String	BBUBDaily			= dailyMetrics.substring(dailyMetrics.indexOf("BBUB:") + 5 , dailyMetrics.indexOf("BBLB:"));
		String	BBLBDaily			= dailyMetrics.substring(dailyMetrics.indexOf("BBLB:") + 5 , dailyMetrics.indexOf("BBMB:"));
		String	BBMBDaily			= dailyMetrics.substring(dailyMetrics.indexOf("BBMB:") + 5 , dailyMetrics.indexOf("ema20:"));
		String  ema20Daily     		= dailyMetrics.substring(dailyMetrics.indexOf("ema20:") + 6 , dailyMetrics.indexOf("ema6:"));
		String  ema06Daily     		= dailyMetrics.substring(dailyMetrics.indexOf("ema6:") + 6 , dailyMetrics.indexOf("RSI:"));
		String	RSIDaily			= dailyMetrics.substring(dailyMetrics.indexOf("RSI:") + 4 , dailyMetrics.indexOf("MACD:"));
		String	MACDDaily			= dailyMetrics.substring(dailyMetrics.indexOf("MACD:") + 5 , dailyMetrics.indexOf("MacdSignal:"));
		String	MacdSignalDaily		= dailyMetrics.substring(dailyMetrics.indexOf("MacdSignal:") + 11 , dailyMetrics.indexOf("ADX:"));
		String	ADXDaily			= dailyMetrics.substring(dailyMetrics.indexOf("ADX:") + 4 , dailyMetrics.indexOf("PDI:"));
		String	PDIDaily			= dailyMetrics.substring(dailyMetrics.indexOf("PDI:") + 4 , dailyMetrics.indexOf("MDI:"));
		String	MDIDaily			= dailyMetrics.substring(dailyMetrics.indexOf("MDI:") + 4 , dailyMetrics.length());
		
		
		System.out.println("DailyorDaily	" +	DailyorDaily)	;
		System.out.println("StockName	" +	StockName	);
		System.out.println("TradeDate	" +	TradeDate			);
		System.out.println("OpenPriceDaily	" +	OpenPriceDaily	);
		System.out.println("HighPriceDaily		" +	HighPriceDaily		);
		System.out.println("LowPriceDaily		" +	LowPriceDaily		);
		System.out.println("ClosePriceDaily	" +	ClosePriceDaily	);
		System.out.println("VolumeDaily		" +	VolumeDaily		);
		System.out.println("BBUBDaily			" +	BBUBDaily			);
		System.out.println("BBLBDaily			" +	BBLBDaily		);
		System.out.println("BBMBDaily			" +	BBMBDaily);
		System.out.println("ema20Daily	" +	ema20Daily	);
		System.out.println("ema06Daily	" +	ema06Daily	);
		System.out.println("RSIDaily			" +	RSIDaily);
		System.out.println("MACDDaily			" +	MACDDaily);
		System.out.println("MacdSignalDaily	" + MacdSignalDaily	);
		System.out.println("ADXDaily			" +	ADXDaily			);
		System.out.println("PDIDaily			" +	PDIDaily			);
		System.out.println("MDIDaily			" +	MDIDaily			);
		
	}

}
