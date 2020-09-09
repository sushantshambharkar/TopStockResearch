package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src\\test\\resources\\features\\getSelectedChartValues.feature"}, glue= {"stepDefinations"})
public class getselectedtopstockrunner {

}
