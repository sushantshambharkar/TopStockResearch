package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {
	
	@FindBy(xpath="//input[@id=\"email\"]")
	WebElementFacade userInputEmail;
	
	@FindBy(xpath="//input[@id=\"pass\"]")
	WebElementFacade userInputpassword;
	
	@FindBy(xpath="//button[@type=\"sumbit\"]")
	WebElementFacade submitLogin;
	
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul/li[8]/a")
	WebElementFacade clickCharts;
	
	@FindBy (xpath="//select[@id=\"mySettings\"]")
	WebElementFacade userSelectedChart;
	
	public void userloginstopsearch()
	{
	
	userInputEmail.sendKeys("sushant.shambharkar@gmail.com");
	userInputpassword.sendKeys("testerno1");
	
	try {
		Thread.sleep(30000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	submitLogin.click();
	
	clickCharts.click();
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	userSelectedChart.click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	userSelectedChart.selectByIndex(1);
	
	}

}
