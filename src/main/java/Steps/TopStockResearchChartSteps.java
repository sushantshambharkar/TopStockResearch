
package Steps;

import java.util.ArrayList;

import net.thucydides.core.annotations.Step;
import pages.CreateFNOList;
import pages.LoginPage;
import pages.TopstockresearchChartPage;

public class TopStockResearchChartSteps {
	
	private TopstockresearchChartPage topstockresearchChartPage;
	private CreateFNOList createFNOList;
	private LoginPage loginpage;
	
	
	ArrayList<String> lista = new ArrayList<String> ();
	
	public void logintotopsearch()
	{
		loginpage.openUrl("https://my.topstockresearch.com/");
		loginpage.userloginstopsearch();
	}
	
	
	public void addsharestoList() 
	{
		lista = createFNOList.CreateFNOListshare();
	

	}
	

//	public void getSelectvalues() throws InterruptedException
//	{
//			
//		for (int i = 0 ; i < lista.size() ; i++ )
//		{
//		
//		topstockresearch.getUserSelectedDailyValues(lista.get(i).toString());
//		
//		}
//	}

	
	public void getValuesFromDailyChart ()
	{
		topstockresearchChartPage.getdailychartvalues();
		
	}


	public void getValuesFromWeeklyChart() {
		// TODO Auto-generated method stub
		topstockresearchChartPage.getweeklychartvalues();
	}


	public void saveValuesFromWeeklychart() {
		
		topstockresearchChartPage.saveweeklychartvalues();
		
	}


	public void saveValuesFromDailyChart() {
		topstockresearchChartPage.savedailychartvalues();
		
	}


}
