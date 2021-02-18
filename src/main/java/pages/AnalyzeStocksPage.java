package pages;

import pojos.*;
import util.DatabaseConnection;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;  

public class AnalyzeStocksPage extends PageObject {
	

	
	
	public static List<StockChartDailyData> lstDailyData =  TopstockresearchChartPage.getlistdailyData();

	public static List<StockChartWeeklyData> lstWeeklyData= TopstockresearchChartPage.getlistWeeklyData();
	
	
	public  SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd"); 
	
	public static List<DailyDataAnalysis> lstDailyDataFinal = new ArrayList<DailyDataAnalysis>();
	public static List<WeeklyDataAnalysis> lstWeeklyDataFinal = new ArrayList<WeeklyDataAnalysis>();


	public void AnalyzeData() throws ParseException {
		

		for (int i = 0; i < lstDailyData.size(); i++) {
			DailyDataAnalysis dailyDataAnalysis = new DailyDataAnalysis();

			dailyDataAnalysis.setWeeklyorDaily(lstDailyData.get(i).getWeeklyorDaily().replace(" ", ""));
			dailyDataAnalysis.setStockName(lstDailyData.get(i).getStockName().replace(" ", ""));
			dailyDataAnalysis.setTradeDate(formatter2.parse(lstDailyData.get(i).getTradeDate()));
			dailyDataAnalysis.setOpenPriceDaily(Double.parseDouble(lstDailyData.get(i).getOpenPriceDaily().replace(" ", "")));
			dailyDataAnalysis.setHighPriceDaily(Double.parseDouble(lstDailyData.get(i).getHighPriceDaily().replace(" ", "")));
			dailyDataAnalysis.setLowPriceDaily(Double.parseDouble(lstDailyData.get(i).getLowPriceDaily().replace(" ", "")));
			dailyDataAnalysis.setClosePriceDaily(Double.parseDouble(lstDailyData.get(i).getClosePriceDaily().replace(" ", "")));
			String VolumeDaily = lstDailyData.get(i).getVolumeDaily();
			if(!VolumeDaily.contains("M"))
			{
				dailyDataAnalysis.setVolumeDaily(Double.parseDouble(lstDailyData.get(i).getVolumeDaily().replace(" ", "")));
			}
			else
			{
				dailyDataAnalysis.setVolumeDaily(Double.parseDouble(lstDailyData.get(i).getVolumeDaily().replace(" ", "").replace("M", "000000")));
			}
			 
			String BBUBdaily = lstDailyData.get(i).getBBUBDaily();
			
			if(!BBUBdaily.contains("NotinGraph"))
			{
				dailyDataAnalysis.setBBUBDaily(Double.parseDouble(lstDailyData.get(i).getBBUBDaily().replace(" ", "")));
			} else  {
				dailyDataAnalysis.setBBUBDaily(0.0);
			}
			
			String BBLBdaily = lstDailyData.get(i).getBBLBDaily();
			
			if(!BBLBdaily.contains("NotinGraph"))
			{
				dailyDataAnalysis.setBBLBDaily(Double.parseDouble(lstDailyData.get(i).getBBLBDaily().replace(" ", "")));
			} else  {
				dailyDataAnalysis.setBBLBDaily(0.0);
			}
				
			dailyDataAnalysis.setBBMBDaily(Double.parseDouble(lstDailyData.get(i).getBBMBDaily().replace(" ", "")));
			dailyDataAnalysis.setEma20Daily(Double.parseDouble(lstDailyData.get(i).getEma20Daily().replace(" ", "")));
			dailyDataAnalysis.setEma06Daily(Double.parseDouble(lstDailyData.get(i).getEma06Daily().replace(" ", "").replace(":", "")));
			dailyDataAnalysis.setRSIDaily(Double.parseDouble(lstDailyData.get(i).getRSIDaily().replace(" ", "")));
			dailyDataAnalysis.setMACDDaily(Double.parseDouble(lstDailyData.get(i).getMACDDaily().replace(" ", "")));
			dailyDataAnalysis.setMacdSignalDaily(Double.parseDouble(lstDailyData.get(i).getMacdSignalDaily().replace(" ", "")));
			dailyDataAnalysis.setADXDaily(Double.parseDouble(lstDailyData.get(i).getADXDaily().replace(" ", "")));
			dailyDataAnalysis.setPDIDaily(Double.parseDouble(lstDailyData.get(i).getPDIDaily().replace(" ", "")));
			dailyDataAnalysis.setMDIDaily(Double.parseDouble(lstDailyData.get(i).getMDIDaily().replace(" ", "")));

			double ema20 = 0;
			double ema06 = 0;
			double RSI = 0;
			double MACD = 0;
			double MACDSignal = 0;
			double MACDMinusSignal = 0;
			
			ema20 = Double.parseDouble(lstDailyData.get(i).getEma20Daily().replace(" ", ""));
			ema06 = Double.parseDouble(lstDailyData.get(i).getEma06Daily().replace(" ", "").replace(":", ""));
			RSI =   Double.parseDouble(lstDailyData.get(i).getRSIDaily().replace(" ", ""));
			MACD =  Double.parseDouble(lstDailyData.get(i).getMACDDaily().replace(" ", ""));
			MACDSignal = Double.parseDouble(lstDailyData.get(i).getMacdSignalDaily().replace(" ", ""));
			

			MACDMinusSignal = MACD - MACDSignal;
			
			dailyDataAnalysis.setMACDAboveSignal(MACDMinusSignal);
			
			if (ema20 > ema06) {

					dailyDataAnalysis.setEMABuyOrSell("EMA Cross: Sell");
				}

			else {
					dailyDataAnalysis.setEMABuyOrSell("EMA Cross: Buy");
				}

			
			if (MACD > MACDSignal) {

				dailyDataAnalysis.setMACDBuyOrSell("MACD Buy");

			} else {

				dailyDataAnalysis.setMACDBuyOrSell("MACD Sell");

			}

			String EMABuyOrSell =  dailyDataAnalysis.getEMABuyOrSell();
			String MACDBuyOrSell = dailyDataAnalysis.getMACDBuyOrSell();
			
		//	System.out.println("EMABuyOrSell  "+ EMABuyOrSell + "MACDBuySell  " + MACDBuyOrSell);
			
			if (EMABuyOrSell.contains("Sell") && MACDBuyOrSell.contains("Buy")  || EMABuyOrSell.contains("Buy") && MACDBuyOrSell.contains("Sell"))
			{
				dailyDataAnalysis.setEMABuyOrSell(EMABuyOrSell.concat(".In Divergence."));
				EMABuyOrSell =  dailyDataAnalysis.getEMABuyOrSell();	
				System.out.println("EMABuyOrSell"+ EMABuyOrSell);
			}
			
			if (EMABuyOrSell.contains("Divergence"))
			{
				if (MACDBuyOrSell.contains("Sell")) { if (((ema20)/ema06 *100) > 98) { dailyDataAnalysis.setEMABuyOrSell(EMABuyOrSell.replace(".In Divergence.","Low Risk Entry.Wait for Cross.")); }}
				
				if (MACDBuyOrSell.contains("Buy"))  { if (((ema06)/ema20 *100) > 98) { dailyDataAnalysis.setEMABuyOrSell(EMABuyOrSell.replace(".In Divergence.","Low Risk Entry.Wait for Cross.")); }}
				
				EMABuyOrSell =  dailyDataAnalysis.getEMABuyOrSell();
				System.out.println("EMABuyOrSell"+ EMABuyOrSell);
			}
			
			if (EMABuyOrSell.isEmpty()) {dailyDataAnalysis.setEMABuyOrSell("Ready for Trade");}
			
			
			if (RSI > 40) {

				dailyDataAnalysis.setRSIBuyOrSell(" RSI Sell");

			} else {
				dailyDataAnalysis.setRSIBuyOrSell("RSI Buy");
			}

			
			int ADXPlus = (int) Double.parseDouble(lstDailyData.get(i).getPDIDaily().replace(" ", ""));
			int ADXMinus = (int) Double.parseDouble(lstDailyData.get(i).getMDIDaily().replace(" ", ""));
			
			if (ADXPlus > ADXMinus ) {
				dailyDataAnalysis.setADXBuyOrSell("ADX Buy");
			} else 
			{
				dailyDataAnalysis.setADXBuyOrSell("ADX Sell");
			}
			
			String scriptsComments = lstDailyData.get(i).getScriptComments();
			
			String scriptsCommentstrend = scriptsComments.substring(scriptsComments.indexOf("more") + 5,scriptsComments.indexOf("than"));
			
			String scriptsCommentstrendstrenght = scriptsComments.substring(scriptsComments.indexOf("than") + 5,scriptsComments.indexOf("of"));
					
			dailyDataAnalysis.setScriptComments(scriptsCommentstrend +" " + scriptsCommentstrendstrenght);
			
			dailyDataAnalysis.setEma50Daily(Double.parseDouble(lstDailyData.get(i).getEma50Daily()));
			dailyDataAnalysis.setEma200Daily(Double.parseDouble(lstDailyData.get(i).getEma200Daily()));
			
			dailyDataAnalysis.setPSARDaily(Double.parseDouble(lstDailyData.get(i).getPsar2006Daily()));
			
			lstDailyDataFinal.add(dailyDataAnalysis);
			
			System.out.println("before db insert date " + lstDailyDataFinal.get(i).getTradeDate());
			
			DatabaseConnection dc = new DatabaseConnection();

			try {
				dc.insertDailyData(

						lstDailyDataFinal.get(i).getWeeklyorDaily(), lstDailyDataFinal.get(i).getStockName(),
						lstDailyDataFinal.get(i).getTradeDate(), lstDailyDataFinal.get(i).getOpenPriceDaily(),
						lstDailyDataFinal.get(i).getHighPriceDaily(), lstDailyDataFinal.get(i).getLowPriceDaily(),
						lstDailyDataFinal.get(i).getClosePriceDaily(), lstDailyDataFinal.get(i).getVolumeDaily(),
						lstDailyDataFinal.get(i).getBBUBDaily(), lstDailyDataFinal.get(i).getBBLBDaily(),
						lstDailyDataFinal.get(i).getBBMBDaily(),lstDailyDataFinal.get(i).getEma20Daily(),lstDailyDataFinal.get(i).getEma06Daily(), 
						lstDailyDataFinal.get(i).getRSIDaily(),
						lstDailyDataFinal.get(i).getMACDDaily(), lstDailyDataFinal.get(i).getMacdSignalDaily(),
						lstDailyDataFinal.get(i).getADXDaily(), lstDailyDataFinal.get(i).getPDIDaily(),
						lstDailyDataFinal.get(i).getMDIDaily(), lstDailyDataFinal.get(i).getMACDBuyOrSell(),
						lstDailyDataFinal.get(i).getRSIBuyOrSell(), lstDailyDataFinal.get(i).getBBBuyOrSell(),
						lstDailyDataFinal.get(i).getADXBuyOrSell(), lstDailyDataFinal.get(i).getEMABuyOrSell(),
						lstDailyDataFinal.get(i).getMACDAboveSignal(), lstDailyDataFinal.get(i).getScriptComments(),
						lstDailyDataFinal.get(i).getEma50Daily(),
						lstDailyDataFinal.get(i).getEma200Daily(),lstDailyDataFinal.get(i).getPSARDaily()

				);
			} catch (Exception e) {
				// System.out.println("Daily Analysis " + lstDailyDataFinal.get(i).getStockName() 
//						+ " Trade Date :  "+ lstDailyDataFinal.get(i).getTradeDate()
//						+ " MACD Buy or Sell : "+ lstDailyDataFinal.get(i).getMACDBuyOrSell() 
//						+ " MACD Daily : "	+ lstDailyDataFinal.get(i).getMACDDaily() 
//						+ " MACD Signal : " + lstDailyDataFinal.get(i).getMacdSignalDaily());
			
			} finally
			{
				// System.out.println("Daily Analysis " + lstDailyDataFinal.get(i).getStockName() 
//						+ " Trade Date :  "+ lstDailyDataFinal.get(i).getTradeDate()
//						+ " MACD Buy or Sell : "+ lstDailyDataFinal.get(i).getMACDBuyOrSell() 
//						+ " MACD Daily : "	+ lstDailyDataFinal.get(i).getMACDDaily() 
//						+ " MACD Signal : " + lstDailyDataFinal.get(i).getMacdSignalDaily());
			}


		}

		

		
		for (int i = 0; i < lstWeeklyData.size(); i++) {
			
			
			WeeklyDataAnalysis weeklyDataAnalysis = new WeeklyDataAnalysis();

			weeklyDataAnalysis.setWeeklyorDaily(lstWeeklyData.get(i).getWeeklyorDaily().replace(" ", ""));
			weeklyDataAnalysis.setStockName(lstWeeklyData.get(i).getStockName().replace(" ", ""));
			weeklyDataAnalysis.setWeekDate(formatter2.parse(lstWeeklyData.get(i).getWeekDate()));
			weeklyDataAnalysis.setOpenPriceWeekly(Double.parseDouble(lstWeeklyData.get(i).getOpenPriceWeekly().replace(" ", "")));
			weeklyDataAnalysis.setHighPriceWeekly(Double.parseDouble(lstWeeklyData.get(i).getHighPriceWeekly().replace(" ", "")));
			weeklyDataAnalysis.setLowPriceWeekly(Double.parseDouble(lstWeeklyData.get(i).getLowPriceWeekly().replace(" ", "")));
			weeklyDataAnalysis.setClosePriceWeekly(Double.parseDouble(lstWeeklyData.get(i).getClosePriceWeekly().replace(" ", "")));
				
			String VolumeWeekly = lstWeeklyData.get(i).getVolumeWeekly();
			
			if(!VolumeWeekly.contains("M"))
			{
				weeklyDataAnalysis.setVolumeWeekly(Double.parseDouble(lstWeeklyData.get(i).getVolumeWeekly().replace(" ", "")));
			}
			else
			{
				weeklyDataAnalysis.setVolumeWeekly(Double.parseDouble(lstWeeklyData.get(i).getVolumeWeekly().replace(" ", "").replace("M", "000000")));
			}
			 
			String BBUBWeekly = lstWeeklyData.get(i).getBBUBWeekly();
			
			if(!BBUBWeekly.contains("NotinGraph"))
			{
				 weeklyDataAnalysis.setBBUBWeekly(Double.parseDouble(lstWeeklyData.get(i).getBBUBWeekly().replace(" ", "")));
			}else  { 	
				weeklyDataAnalysis.setBBUBWeekly(0.0);
			}
			
			String BBLBWeekly = lstWeeklyData.get(i).getBBLBWeekly();
			
			if(!BBLBWeekly.contains("NotinGraph"))
			{
				 weeklyDataAnalysis.setBBLBWeekly(Double.parseDouble(lstWeeklyData.get(i).getBBLBWeekly().replace(" ", "")));
			} else  {
				weeklyDataAnalysis.setBBLBWeekly(0.0);
			}
			
			weeklyDataAnalysis.setBBMBWeekly(Double.parseDouble(lstWeeklyData.get(i).getBBMBWeekly().replace(" ", "")));
			weeklyDataAnalysis.setEma20Weekly(Double.parseDouble(lstWeeklyData.get(i).getEma20Weekly().replace(" ", "")));
			weeklyDataAnalysis.setEma06Weekly(Double.parseDouble(lstWeeklyData.get(i).getEma06Weekly().replace(" ", "").replace(":", "")));
			weeklyDataAnalysis.setRSIWeekly(Double.parseDouble(lstWeeklyData.get(i).getRSIWeekly().replace(" ", "")));
			weeklyDataAnalysis.setMACDWeekly(Double.parseDouble(lstWeeklyData.get(i).getMACDWeekly()));
			weeklyDataAnalysis.setMacdSignalWeekly(Double.parseDouble(lstWeeklyData.get(i).getMacdSignalWeekly().replace(" ", "")));
			weeklyDataAnalysis.setADXWeekly(Double.parseDouble(lstWeeklyData.get(i).getADXWeekly().replace(" ", "")));
			weeklyDataAnalysis.setPDIWeekly(Double.parseDouble(lstWeeklyData.get(i).getPDIWeekly().replace(" ", "")));
			weeklyDataAnalysis.setMDIWeekly(Double.parseDouble(lstWeeklyData.get(i).getMDIWeekly().replace(" ", "")));

			double ema20 = 0;
			double ema06 = 0;
			double RSI = 0;
			double MACD = 0;
			double MACDSignal = 0;
			double MACDAboveSignal = 0;

			ema20 =  Double.parseDouble(lstWeeklyData.get(i).getEma20Weekly().replace(" ", ""));
			ema06 =  Double.parseDouble(lstWeeklyData.get(i).getEma06Weekly().replace(" ", ""));
			RSI =    Double.parseDouble(lstWeeklyData.get(i).getRSIWeekly().replace(" ", ""));
			MACD =   Double.parseDouble(lstWeeklyData.get(i).getMACDWeekly().replace(" ", ""));
			MACDSignal = Double.parseDouble(lstWeeklyData.get(i).getMacdSignalWeekly().replace(" ", ""));
			
			MACDAboveSignal = MACD - MACDSignal;
			weeklyDataAnalysis.setMACDAboveSignal(MACDAboveSignal );
			
			if (ema20 > ema06) 
			{
				weeklyDataAnalysis.setEMABuyOrSell("EMA Cross: Sell");
				
//				if ((ema20 / ema06) * 100 > 95) {
//					weeklyDataAnalysis.setEMABuyOrSell("EMA Cross: Ready to Sell");
//				}
//
//				else {


			} else {
				
				weeklyDataAnalysis.setEMABuyOrSell("EMA Cross: Buy");
				
//				if ((ema06 / ema20) * 100 > 95) {
//					weeklyDataAnalysis.setEMABuyOrSell("EMA Cross : Ready to Buy");
//				}
//
//				else {
					
				

			}

			if (MACD > MACDSignal) {
				// System.out.println("inside buy loop MACD" + MACD + " " + "MACDSignal" + MACDSignal);

				weeklyDataAnalysis.setMACDBuyOrSell("Buy");

			} else {
				// // System.out.println("inside Sell loop MACD" + MACD + " " + "MACDSignal" +
				// MACDSignal );

				weeklyDataAnalysis.setMACDBuyOrSell("Sell");

			}

			if (RSI > 40) {

				weeklyDataAnalysis.setRSIBuyOrSell("Sell");

			} else {
				weeklyDataAnalysis.setRSIBuyOrSell("Buy");
			}

			
			int ADXPlus = (int) Double.parseDouble(lstWeeklyData.get(i).getPDIWeekly().replace(" ", ""));
			int ADXMinus = (int) Double.parseDouble(lstWeeklyData.get(i).getMDIWeekly().replace(" ", ""));
			
			if (ADXPlus > ADXMinus ) {
				weeklyDataAnalysis.setADXBuyOrSell("ADX Buy");
			} else 
			{
				weeklyDataAnalysis.setADXBuyOrSell("ADX Sell");
			}
			
		weeklyDataAnalysis.setEma50Weekly(Double.parseDouble(lstWeeklyData.get(i).getEma50Weekly()));
		weeklyDataAnalysis.setEma200Weekly(Double.parseDouble(lstWeeklyData.get(i).getEma200Weekly()));
		
		weeklyDataAnalysis.setPSAR2006Weekly(Double.parseDouble(lstWeeklyData.get(i).getPsar2006Weekly()));
			
			lstWeeklyDataFinal.add(weeklyDataAnalysis);
			
			System.out.println("before db insert "  + "on " + lstWeeklyDataFinal.get(i).getWeekDate());

			DatabaseConnection dc = new DatabaseConnection();

			try {
				dc.insertWeeklyData(

						lstWeeklyDataFinal.get(i).getWeeklyorDaily(), lstWeeklyDataFinal.get(i).getStockName(),
						lstWeeklyDataFinal.get(i).getWeekDate(), lstWeeklyDataFinal.get(i).getOpenPriceWeekly(),
						lstWeeklyDataFinal.get(i).getHighPriceWeekly(), lstWeeklyDataFinal.get(i).getLowPriceWeekly(),
						lstWeeklyDataFinal.get(i).getClosePriceWeekly(), lstWeeklyDataFinal.get(i).getVolumeWeekly(),
						lstWeeklyDataFinal.get(i).getBBUBWeekly(), lstWeeklyDataFinal.get(i).getBBLBWeekly(),
						lstWeeklyDataFinal.get(i).getBBMBWeekly(), lstWeeklyDataFinal.get(i).getEma20Weekly(),	lstWeeklyDataFinal.get(i).getEma06Weekly(), 
						lstWeeklyDataFinal.get(i).getRSIWeekly(),lstWeeklyDataFinal.get(i).getMACDWeekly(), lstWeeklyDataFinal.get(i).getMacdSignalWeekly(),
						lstWeeklyDataFinal.get(i).getADXWeekly(), lstWeeklyDataFinal.get(i).getPDIWeekly(),
						lstWeeklyDataFinal.get(i).getMDIWeekly(), lstWeeklyDataFinal.get(i).getMACDBuyOrSell(),
						lstWeeklyDataFinal.get(i).getRSIBuyOrSell(), lstWeeklyDataFinal.get(i).getBBBuyOrSell(),
						lstWeeklyDataFinal.get(i).getADXBuyOrSell(), lstWeeklyDataFinal.get(i).getEMABuyOrSell(),
						lstWeeklyDataFinal.get(i).getMACDAboveSignal(),lstWeeklyDataFinal.get(i).getEma50Weekly(),	lstWeeklyDataFinal.get(i).getEma200Weekly(),
						lstWeeklyDataFinal.get(i).getPSAR2006Weekly()

				);
			} catch (Exception e) {
				
				// System.out.println("Weekly Analysis " + lstWeeklyDataFinal.get(i).getStockName()
//						+ " Week Date :  "+ lstWeeklyDataFinal.get(i).getWeekDate()
//						+ " MACD Buy or Sell : " + lstWeeklyDataFinal.get(i).getMACDBuyOrSell() 
//						+ " MACD Daily : "+ lstWeeklyDataFinal.get(i).getMACDWeekly() 
//						+ " MACD Signal : " + lstWeeklyDataFinal.get(i).getMacdSignalWeekly());

			} finally
			{
				// System.out.println("Weekly Analysis " + lstWeeklyDataFinal.get(i).getStockName()
//						+ " Week Date :  "+ lstWeeklyDataFinal.get(i).getWeekDate()
//						+ " MACD Buy or Sell : " + lstWeeklyDataFinal.get(i).getMACDBuyOrSell() 
//						+ " MACD Daily : "+ lstWeeklyDataFinal.get(i).getMACDWeekly() 
//						+ " MACD Signal : " + lstWeeklyDataFinal.get(i).getMacdSignalWeekly());

			}

			
		}
	}


	private Object indexOf(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public void DisplayStocksData() {

//		for (int i = 0; i < lstWeeklyDataFinal.size(); i++) {
//			// System.out.println("Weekly " + lstWeeklyDataFinal.get(i).getStockName() + " MACD Buy or Sell : "
//			//		+ lstWeeklyDataFinal.get(i).getMACDBuyOrSell() + " MACD Daily : "
//			//		+ lstWeeklyDataFinal.get(i).getMACDWeekly() + " MACD Signal : "
//			//		+ lstWeeklyDataFinal.get(i).getMacdSignalWeekly());
//		}
//
//		for (int i = 0; i < lstDailyDataFinal.size(); i++) {
//			// System.out.println("Daily " + lstDailyDataFinal.get(i).getStockName() + " MACD Buy or Sell : "
//			//		+ lstDailyDataFinal.get(i).getMACDBuyOrSell() + " MACD Daily : "
//			//		+ lstDailyDataFinal.get(i).getMACDDaily() + " MACD Signal : "
//			//		+ lstDailyDataFinal.get(i).getMacdSignalDaily());
//		}

	}


	public static List<DailyDataAnalysis> getLstDailyDataFinal() {
		return lstDailyDataFinal;
	}


	public static List<WeeklyDataAnalysis> getLstWeeklyDataFinal() {
		return lstWeeklyDataFinal;
	}
		
		
	}
	
	

