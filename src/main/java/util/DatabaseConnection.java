package util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseConnection {
	
	public SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

	public void insertDailyData(

			String WeeklyorDaily, String StockName, Date TradeDate, Double OpenPriceDaily, Double HighPriceDaily,
			Double LowPriceDaily, Double ClosePriceDaily, Double VolumeDaily, Double BBUBDaily, Double BBLBDaily,
			Double BBMBDaily, Double ema20Daily, Double ema06Daily, Double RSIDaily, Double MACDDaily,
			Double MacdSignalDaily, Double ADXDaily, Double PDIDaily, Double MDIDaily, String MACDBuyOrSell,
			String RSIBuyOrSell, String BBBuyOrSell, String ADXBuyOrSell, String EMABuyOrSell, 
			Double MACDAboveSignal, String scrComments, double ema50Daily, double ema200Daily , Double psarDaily

	) {

		java.sql.Connection conn = null;
		ResultSet result = null;
		
		
		try {

			/// https://www.connectionstrings.com/sql-server/
			/// https://seleniummaster.com/sitecontent/index.php/sql-for-tester-menu/205-how-to-retrieve-data-with-sql-statement-select-syntax

			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TECHNICAL_ANALYSIS;integratedSecurity=true";

			// Initialize Sqldriver instance
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Creating the connection providing URL and username password
			conn = DriverManager.getConnection(connectionUrl);

			// Checking for the connection( returns boolean false if connected)
			//System.out.println("SchemaName " + conn.getSchema());

				
			String d2 = TradeDate.toString() ;
			
		//	System.out.println(  " TradeDate is  " +  d2);
			
			String monthmm = d2.substring(4, 7);
			
			String daydd = d2.substring(8, 10);
			
			String yearyy = d2.substring(24, d2.length());
			
			String d3 = yearyy + "-" + monthmm + "-" + daydd;
			
		//	System.out.println(TradeDate + "is  " +  yearyy + "-" + monthmm + "-" + daydd);
			
			String query = " Insert into DailyDataAnalysis (WeeklyorDaily\r\n" 
			+ "      ,StockName\r\n"
			+ "      ,TradeDate\r\n" 
			+ "      ,OpenPriceDaily\r\n" + "      ,HighPriceDaily\r\n"
					+ "      ,LowPriceDaily\r\n" + "      ,ClosePriceDaily\r\n" + "      ,VolumeDaily\r\n"
					+ "      ,BBUBDaily\r\n" + "      ,BBLBDaily\r\n" + "      ,BBMBDaily\r\n" + "      ,ema20Daily\r\n"
					+ "      ,ema06Daily\r\n" + "      ,RSIDaily\r\n" + "      ,MACDDaily\r\n"
					+ "      ,MacdSignalDaily\r\n" + "      ,ADXDaily\r\n" + "      ,PDIDaily\r\n"
					+ "      ,MDIDaily\r\n" + "      ,MACDBuyOrSell\r\n" + "      ,RSIBuyOrSell\r\n"
					+ "      ,BBBuyOrSell\r\n" + "      ,ADXBuyOrSell\r\n" + "      ,EMABuyOrSell\r\n"
					+ "	  ,MACDAboveSignal"
					+ ", ScriptComments  "
					+",ema50Daily "
					+",ema200Daily "
					+",psarDaily"
					+ ") Values (" 
					+ "'" + WeeklyorDaily + "'" + "," 
					+ "'" + StockName + "'" + "," 
					+ "'"+ d3 + "'" + "," 
					+ OpenPriceDaily + "," 
					+ HighPriceDaily + "," + LowPriceDaily + ","
					+ ClosePriceDaily + "," + VolumeDaily + "," + BBUBDaily + "," + BBLBDaily + "," + BBMBDaily + ","
					+ ema20Daily + "," + ema06Daily + "," + RSIDaily + "," + MACDDaily + "," + MacdSignalDaily + ","
					+ ADXDaily + "," + PDIDaily + "," + MDIDaily + "," + "'" + MACDBuyOrSell + "'" + "," + "'"
					+ RSIBuyOrSell + "'" + "," + "'" + BBBuyOrSell + "'" + "," + "'" + ADXBuyOrSell + "'" + "," + "'"
					+ EMABuyOrSell + "'" + "," 
					+ MACDAboveSignal + "," 
					+ "'" + scrComments + "'" + ","
					+ ema50Daily + "," 		
					+ ema200Daily + "," 
					+ psarDaily
					+ " )";

		//	System.out.println("query  " + query);

			PreparedStatement pst = conn.prepareStatement(query);
			
			

			try {
				pst.executeQuery();
			} catch (Exception e1) {
			
				;
			}finally
			{
				;
			}

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//System.out.println("is connection closed " + conn.isClosed());
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		
	}

	public void insertWeeklyData(

			String WeeklyorDaily, String StockName, Date WeekDate, Double OpenPriceWeekly, Double HighPriceWeekly,
			Double LowPriceWeekly, Double ClosePriceWeekly, Double VolumeWeekly, Double BBUBWeekly, Double BBLBWeekly,
			Double BBMBWeekly, Double ema20Weekly, Double ema06Weekly, Double RSIWeekly, Double MACDWeekly,
			Double MacdSignalWeekly, Double ADXWeekly, Double PDIWeekly, Double MDIWeekly, String MACDBuyOrSell,
			String RSIBuyOrSell, String BBBuyOrSell, String ADXBuyOrSell, String EMABuyOrSell, Double MACDAboveSignal,
			Double ema50Weekly, Double ema200Weekly , Double psarWeekly

	) {

		java.sql.Connection conn = null;
		ResultSet result = null;
		try {

			/// https://www.connectionstrings.com/sql-server/
			/// https://seleniummaster.com/sitecontent/index.php/sql-for-tester-menu/205-how-to-retrieve-data-with-sql-statement-select-syntax

			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TECHNICAL_ANALYSIS;integratedSecurity=true";

			// Initialize Sqldriver instance
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Creating the connection providing URL and username password
			conn = DriverManager.getConnection(connectionUrl);

			// Checking for the connection( returns boolean false if connected)
			//	System.out.println("SchemaName " + conn.getSchema());

			String d2 = WeekDate.toString() ;
			
		//	System.out.println(  " WeekDate  is  " +  d2);
			
			
			String monthmm = d2.substring(4, 7);
			
			String daydd = d2.substring(8, 10);
			
			String yearyy = d2.substring(24, d2.length());
			
			String d3 = yearyy + "-" + monthmm + "-" + daydd;
			
		//	System.out.println(WeekDate + "is  " + yearyy + "-" + monthmm + "-" + daydd);
			
			String query = " Insert into WeeklyDataAnalysis (WeeklyorDaily\r\n" 
					+ "      ,StockName\r\n"
					+ "      ,WeekDate\r\n" 
					+ "      ,OpenPriceWeekly\r\n" 
					+ "      ,HighPriceWeekly\r\n"
					+ "      ,LowPriceWeekly\r\n" 
					+ "      ,ClosePriceWeekly\r\n" + "      ,VolumeWeekly\r\n"
					+ "      ,BBUBWeekly\r\n" + "      ,BBLBWeekly\r\n" + "      ,BBMBWeekly\r\n"
					+ "      ,ema20Weekly\r\n" 
					+ "      ,ema06Weekly\r\n" 
					+ "      ,RSIWeekly\r\n"
					+ "      ,MACDWeekly\r\n" 
					+ "      ,MacdSignalWeekly\r\n" 
					+ "      ,ADXWeekly\r\n"
					+ "      ,PDIWeekly\r\n" 
					+ "      ,MDIWeekly\r\n" 
					+ "      ,MACDBuyOrSell\r\n"
					+ "      ,RSIBuyOrSell\r\n" 
					+ "      ,BBBuyOrSell\r\n" 
					+ "      ,ADXBuyOrSell\r\n"
					+ "      ,EMABuyOrSell\r\n" 
					+ "	  	 ,MACDAboveSignal "
					+ "      ,ema50Weekly\r\n" 
					+ "      ,ema200Weekly\r\n"
					+ "      ,psarWeekly\r\n"
					+ ") Values (" 
					+ "'" + WeeklyorDaily + "'" + ","
					+ "'" + StockName + "'" + "," 
					+ "'"+ d3 + "'" 
					+ "," + OpenPriceWeekly 
					+ "," + HighPriceWeekly + ","
					+ LowPriceWeekly + "," 
					+ ClosePriceWeekly + "," 
					+ VolumeWeekly + "," 
					+ BBUBWeekly + "," 
					+ BBLBWeekly
					+ "," + BBMBWeekly + "," + ema20Weekly + "," + ema06Weekly + "," + RSIWeekly + "," + MACDWeekly
					+ "," + MacdSignalWeekly + "," + ADXWeekly + "," + PDIWeekly + "," + MDIWeekly + "," + "'"
					+ MACDBuyOrSell + "'" + "," + "'" + RSIBuyOrSell + "'" + "," + "'" + BBBuyOrSell + "'" + "," + "'"
					+ ADXBuyOrSell + "'" + "," + "'" + EMABuyOrSell + "'" + "," + MACDAboveSignal 
					+ "," + ema50Weekly 
					+ "," + ema200Weekly 
					+ "," + psarWeekly 
					+ " )";

		//	System.out.println("Weekly query  " + query);

			PreparedStatement pst = conn.prepareStatement(query);

			try {
				pst.executeQuery();
			} catch (Exception e1) {
				;
				
			}finally
			{
				;
			}

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			//	System.out.println("is connection closed " + conn.isClosed());
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		

	}

}
