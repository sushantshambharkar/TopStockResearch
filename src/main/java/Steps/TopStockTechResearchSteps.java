package Steps;

import java.util.ArrayList;

import net.thucydides.core.annotations.Step;
import pages.CreateFNOList;
import pages.LoginPage;
import pages.TopReasearchTechWebPage;
import pages.TopstockresearchChartPage;
import pages.TopstockresearchTechPage;

public class TopStockTechResearchSteps {
	

	private CreateFNOList createFNOList;
	private TopstockresearchTechPage topstockresearchTechPage;
	private TopReasearchTechWebPage topReasearchTechWebPage;
	
	
	ArrayList<String> listb = new ArrayList<String> ();
	
	public void addsharestoList() 
	{
		listb = createFNOList.CreateFNOListshare();
	

	}
	
	public void Opentopsearch()
	{
		topReasearchTechWebPage.openUrl("https://www.topstockresearch.com/");
		
		topReasearchTechWebPage.navigateToTechPage();	
	}
	
	

	

	public void getTechDatavalues() throws InterruptedException
	{
			
		for (int i = 0 ; i < listb.size() ; i++ )
		{
		
			topstockresearchTechPage.getUserSelectedDailyTechValues(listb.get(i).toString());
		
		}
	}

	
	public void getvalueslist ()
	{
		topstockresearchTechPage.printlstTechDataValues();
		
		topstockresearchTechPage.savetechdatainexcel();
	}


}
