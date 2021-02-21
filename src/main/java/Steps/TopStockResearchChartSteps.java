
package Steps;

import java.text.ParseException;
import java.util.ArrayList;

import pages.AnalyzeStocksPage;
import pages.CreateFNOList;
import pages.LoginPage;
import pages.SaveFinalExcelFilesPage;
import net.thucydides.core.annotations.Steps;
import pages.TopstockresearchChartPage;

public class TopStockResearchChartSteps {
	
	@Steps 
	private TopstockresearchChartPage topstockresearchChartPage;
	private AnalyzeStocksPage analyzeStocksSteps;
	private SaveFinalExcelFilesPage saveFinalExcelFiles;
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
		try {
			topstockresearchChartPage.getdailychartvalues();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void getValuesFromWeeklyChart() throws InterruptedException {
		// TODO Auto-generated method stub
		topstockresearchChartPage.getweeklychartvalues();
	}


	public void saveValuesFromWeeklychart() throws Exception {
		
		topstockresearchChartPage.saveweeklychartvalues();
		
	}


	public void saveValuesFromDailyChart() {
		topstockresearchChartPage.savedailychartvalues();
		
	}

	public void AnalyseandSaveinDB() throws ParseException
	{
		analyzeStocksSteps.AnalyzeData();
		
		analyzeStocksSteps.DisplayStocksData();
		
		saveFinalExcelFiles.saveFinalDailyAnalysis();
		
		saveFinalExcelFiles.saveFinalWeeklyAnalysis();	
	}
}
