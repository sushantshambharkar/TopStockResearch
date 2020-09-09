package pages;

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
	
	@FindBy(xpath="//div [@id=\"tsrchart\"]")
	WebElementFacade usernavigation;
	

	
	public void getUserSelectedDailyValues(String stockname) throws InterruptedException
	{
		userInput.clear();
		userInput.sendKeys(stockname);
		Thread.sleep(1000);
		userInput.sendKeys(Keys.ARROW_DOWN);
		userInput.sendKeys(Keys.ENTER);
		userInput.sendKeys(Keys.TAB);
		

		userFrequency.selectByIndex(8);
	//	String freq = userFrequency.getTextValue();
		
		Thread.sleep(5000);
		
		WebDriver dailydriver = getDriver();
		dailydriver.navigate().refresh();
		
			
		usernavigation.click();
		
		Actions action = new Actions(getDriver());
		action.moveToElement(usernavigation).perform();
		
		
		Actions actiontwo = new Actions(getDriver());
		actiontwo.moveByOffset(265, 645).click();
		
		
		String gettextvalues = userSelectedValues.getTextValue();
		
		System.out.println(stockname +  " Daily Values " + gettextvalues);
		
//		userFrequency.click();
//		Thread.sleep(500);
//		
//		userFrequency.selectByIndex(9);
//		
//		gettextvalues = userSelectedValues.getTextValue();
//		System.out.println(stockname + " Weekly Values "  + " " + gettextvalues);
//		
	}
	

}
