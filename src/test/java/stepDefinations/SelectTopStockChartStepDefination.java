package stepDefinations;

import Steps.TopStockResearchChartSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SelectTopStockChartStepDefination {
	
	@Steps
	TopStockResearchChartSteps topStockResearch;
	
	@Given("^User open top stock$")
	public void user_open_top_stock() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		topStockResearch.logintotopsearch();
		topStockResearch.addsharestoList();
		topStockResearch.getSelectvalues();
	}

	@When("^User selects top stock$")
	public void user_selects_top_stock() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^User finalizes top stock$")
	public void user_finalizes_top_stock() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}
