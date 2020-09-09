
package pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.topstockresearch.com/")
public class TopReasearchTechWebPage extends PageObject{
	
	@FindBy(xpath="//select[@id=\"eqSubCat\"]")
	WebElementFacade	selecttechnicalsdropdown;

	
	public void navigateToTechPage()
	 {
		
			selecttechnicalsdropdown.click();
			selecttechnicalsdropdown.selectByValue("Technicals");

	 }


	
}
