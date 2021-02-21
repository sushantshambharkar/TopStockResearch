package stepDefinations;

import java.text.ParseException;

import Steps.TopStockResearchChartSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SelectTopStockChartStepDefination {
	
	@Steps
	TopStockResearchChartSteps topStockResearchChartStep;
	
	@Given("^User open top stock$")
	public void user_open_top_stock() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		topStockResearchChartStep.logintotopsearch();
		topStockResearchChartStep.addsharestoList();
		//topStockResearch.getSelectvalues();
	}

	@When("^User open the daily chart$")
	public void user_open_the_daily_chart() {
		
		topStockResearchChartStep.getValuesFromDailyChart();
		
	}

	@Then("^User saves the daily chart values in excel$")
	public void user_saves_the_daily_chart_values_in_excel() {
		
		topStockResearchChartStep.saveValuesFromDailyChart();
	
		
	}
	
	@When("^User open the weekly chart$")
	public void user_open_the_weekly_chart() throws InterruptedException {
		
		topStockResearchChartStep.getValuesFromWeeklyChart();
		
	}

	@Then("^User saves the weekly chart values in excel$")
	public void user_saves_the_weekly_chart_values_in_excel() throws Exception {
		topStockResearchChartStep.saveValuesFromWeeklychart();
		
	}

	@Then("^User Analyses the Data and saves in DB$")
	public void user_Analyses_the_Data_and_saves_in_DB() throws ParseException {
		topStockResearchChartStep.AnalyseandSaveinDB();

	}
}
