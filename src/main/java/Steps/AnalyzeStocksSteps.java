package Steps;

import pojos.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.TopstockresearchChartPage;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class AnalyzeStocksSteps {
	
	@Steps
	private  StockChartDailyData stockChartDailyData;
	private  StockChartWeeklyData stockChartWeeklyData;
	private  DailyDataAnalysis dailyDataAnalysis;
	private  TopstockresearchChartPage topstockresearchChartPage;
	
	public List<StockChartDailyData> lstDailyData = new ArrayList<StockChartDailyData>();
	public List<StockChartWeeklyData> lstWeeklyData = new ArrayList<StockChartWeeklyData>();
	
	public  SimpleDateFormat formatter2=new SimpleDateFormat("dd-mm-yyyy"); 
	
	public List<DailyDataAnalysis> lstDailyDataFinal = new ArrayList<DailyDataAnalysis>();
	public List<WeeklyDataAnalysis> lstWeeklyDataFinal = new ArrayList<WeeklyDataAnalysis>();
	


	
		
		
	}
	
	

