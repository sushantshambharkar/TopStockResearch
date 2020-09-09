
package stepDefinations;


import Steps.TopStockTechResearchSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.TopReasearchTechWebPage;

public class SelectTopStockTechStepDefination {
	
	@Steps
	TopStockTechResearchSteps topStockTechResearchSteps;
	
	@Given("^User open tech top stock$")
	public void user_open_tech_top_stock() throws Exception {
		
		
		
		topStockTechResearchSteps.addsharestoList();
		
		topStockTechResearchSteps.Opentopsearch();
		
		
		topStockTechResearchSteps.getTechDatavalues();
		
		topStockTechResearchSteps.getvalueslist();
		

	}

	@When("^User gets tech data stock$")
	public void user_gets_tech_data_stock() throws Exception {
	  
	}

	@Then("^User select top stock$")
	public void user_select_top_stock() throws Exception {
	   
	}


}
