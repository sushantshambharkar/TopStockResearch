package pages;

import pojos.*;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.serenitybdd.core.pages.PageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;  

public class SaveFinalExcelFilesPage extends PageObject {
	
	
	
	public List<DailyDataAnalysis> lstDailyDataFinal = AnalyzeStocksPage.getLstDailyDataFinal();
	public List<WeeklyDataAnalysis> lstWeeklyDataFinal = AnalyzeStocksPage.getLstWeeklyDataFinal();
	
	
	public void saveFinalDailyAnalysis() {
		

		
		//String fileName = "DailyDataFinal.xlsx";
		File finalfile = new File("c://Selenium//DailyDataFinal.xlsx");

		Workbook finaldailyworkBook = null;
		FileInputStream finaldailyfileInputStream = null;

		// System.out.println(finalfile);

		try {

			finaldailyfileInputStream = new FileInputStream(finalfile);
			finaldailyworkBook = new XSSFWorkbook(finaldailyfileInputStream);

		} catch (IOException e1)

		{
			e1.printStackTrace();
		}

		Sheet sheet = finaldailyworkBook.getSheet("Data");

		// Get the current count of rows in excel file

//		int rCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Get the first row from the sheet

		Row row = sheet.getRow(0);

		// Create a new row and append it at last of sheet

		// Create a loop over the cell of newly created Row

		for (int rowCount = 0; rowCount < lstDailyDataFinal.size(); rowCount++) {

			Row newRow = sheet.createRow(rowCount + 1);

			{

				// Fill data in row

				Cell cell = newRow.createCell(0);
				cell.setCellValue(lstDailyDataFinal.get(rowCount).getWeeklyorDaily());

				Cell cell1 = newRow.createCell(1);
				cell1.setCellValue(lstDailyDataFinal.get(rowCount).getStockName());

				Cell cell2 = newRow.createCell(2);
				cell2.setCellValue(lstDailyDataFinal.get(rowCount).getTradeDate());

				Cell cell3 = newRow.createCell(3);
				cell3.setCellValue(lstDailyDataFinal.get(rowCount).getOpenPriceDaily());

				Cell cell4 = newRow.createCell(4);
				cell4.setCellValue(lstDailyDataFinal.get(rowCount).getHighPriceDaily());

				Cell cell5 = newRow.createCell(5);
				cell5.setCellValue(lstDailyDataFinal.get(rowCount).getLowPriceDaily());

				Cell cell6 = newRow.createCell(6);
				cell6.setCellValue(lstDailyDataFinal.get(rowCount).getClosePriceDaily());

				Cell cell7 = newRow.createCell(7);
				cell7.setCellValue(lstDailyDataFinal.get(rowCount).getVolumeDaily());

				Cell cell8 = newRow.createCell(8);
				cell8.setCellValue(lstDailyDataFinal.get(rowCount).getBBUBDaily());

				Cell cell9 = newRow.createCell(9);
				cell9.setCellValue(lstDailyDataFinal.get(rowCount).getBBLBDaily());

				Cell cell10 = newRow.createCell(10);
				cell10.setCellValue(lstDailyDataFinal.get(rowCount).getBBMBDaily());

				Cell cell11 = newRow.createCell(11);
				cell11.setCellValue(lstDailyDataFinal.get(rowCount).getEma20Daily());

				Cell cell12 = newRow.createCell(12);
				cell12.setCellValue(lstDailyDataFinal.get(rowCount).getEma06Daily());

				Cell cell13 = newRow.createCell(13);
				cell13.setCellValue(lstDailyDataFinal.get(rowCount).getRSIDaily());

				Cell cell14 = newRow.createCell(14);
				cell14.setCellValue(lstDailyDataFinal.get(rowCount).getMACDDaily());

				Cell cell15 = newRow.createCell(15);
				cell15.setCellValue(lstDailyDataFinal.get(rowCount).getMacdSignalDaily());

				Cell cell16 = newRow.createCell(16);
				cell16.setCellValue(lstDailyDataFinal.get(rowCount).getADXDaily());

				Cell cell17 = newRow.createCell(17);
				cell17.setCellValue(lstDailyDataFinal.get(rowCount).getPDIDaily());

				Cell cell18 = newRow.createCell(18);
				cell18.setCellValue(lstDailyDataFinal.get(rowCount).getMDIDaily());

				Cell cell19 = newRow.createCell(19);
				cell19.setCellValue(lstDailyDataFinal.get(rowCount).getMACDBuyOrSell());

				Cell cell20 = newRow.createCell(20);
				cell20.setCellValue(lstDailyDataFinal.get(rowCount).getEMABuyOrSell());

				Cell cell21 = newRow.createCell(21);
				cell21.setCellValue(lstDailyDataFinal.get(rowCount).getBBBuyOrSell());

				Cell cell22 = newRow.createCell(22);
				cell22.setCellValue(lstDailyDataFinal.get(rowCount).getADXBuyOrSell());

				Cell cell23 = newRow.createCell(23);
				cell23.setCellValue(lstDailyDataFinal.get(rowCount).getMACDAboveSignal());
				
				Cell cell24 = newRow.createCell(24);
				cell24.setCellValue(lstDailyDataFinal.get(rowCount).getScriptComments());

			}

			// Close input stream

			try {
				finaldailyfileInputStream.close();

				// Create an object of FileOutputStream class to create write data in excel file

				FileOutputStream dailyOutputStream = new FileOutputStream(finalfile);

				// write data in the excel file

				finaldailyworkBook.write(dailyOutputStream);

				// close output stream

				dailyOutputStream.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void saveFinalWeeklyAnalysis() {

		//String fileName = "WeeklyDataFinal.xlsx";
		File finalfile = new File("c://Selenium//WeeklyDataFinal.xlsx");
		Workbook finalWeeklyworkBook = null;
		FileInputStream finalWeeklyfileInputStream = null;

		// System.out.println(finalfile);

		try {

			finalWeeklyfileInputStream = new FileInputStream(finalfile);
			finalWeeklyworkBook = new XSSFWorkbook(finalWeeklyfileInputStream);

		} catch (IOException e1)

		{
			e1.printStackTrace();
		}

		Sheet sheet = finalWeeklyworkBook.getSheet("Data");

		// Get the current count of rows in excel file

//		int rCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Get the first row from the sheet

		Row row = sheet.getRow(0);

		// Create a new row and append it at last of sheet

		// Create a loop over the cell of newly created Row

		for (int rowCount = 0; rowCount < lstWeeklyDataFinal.size(); rowCount++) {

			Row newRow = sheet.createRow(rowCount + 1);

			{

				// Fill data in row

				Cell cell = newRow.createCell(0);
				cell.setCellValue(lstWeeklyDataFinal.get(rowCount).getWeeklyorDaily());

				Cell cell1 = newRow.createCell(1);
				cell1.setCellValue(lstWeeklyDataFinal.get(rowCount).getStockName());

				Cell cell2 = newRow.createCell(2);
				cell2.setCellValue(lstWeeklyDataFinal.get(rowCount).getWeekDate());

				Cell cell3 = newRow.createCell(3);
				cell3.setCellValue(lstWeeklyDataFinal.get(rowCount).getOpenPriceWeekly());

				Cell cell4 = newRow.createCell(4);
				cell4.setCellValue(lstWeeklyDataFinal.get(rowCount).getHighPriceWeekly());

				Cell cell5 = newRow.createCell(5);
				cell5.setCellValue(lstWeeklyDataFinal.get(rowCount).getLowPriceWeekly());

				Cell cell6 = newRow.createCell(6);
				cell6.setCellValue(lstWeeklyDataFinal.get(rowCount).getClosePriceWeekly());

				Cell cell7 = newRow.createCell(7);
				cell7.setCellValue(lstWeeklyDataFinal.get(rowCount).getVolumeWeekly());

				Cell cell8 = newRow.createCell(8);
				cell8.setCellValue(lstWeeklyDataFinal.get(rowCount).getBBUBWeekly());

				Cell cell9 = newRow.createCell(9);
				cell9.setCellValue(lstWeeklyDataFinal.get(rowCount).getBBLBWeekly());

				Cell cell10 = newRow.createCell(10);
				cell10.setCellValue(lstWeeklyDataFinal.get(rowCount).getBBMBWeekly());

				Cell cell11 = newRow.createCell(11);
				cell11.setCellValue(lstWeeklyDataFinal.get(rowCount).getEma20Weekly());

				Cell cell12 = newRow.createCell(12);
				cell12.setCellValue(lstWeeklyDataFinal.get(rowCount).getEma06Weekly());

				Cell cell13 = newRow.createCell(13);
				cell13.setCellValue(lstWeeklyDataFinal.get(rowCount).getRSIWeekly());

				Cell cell14 = newRow.createCell(14);
				cell14.setCellValue(lstWeeklyDataFinal.get(rowCount).getMACDWeekly());

				Cell cell15 = newRow.createCell(15);
				cell15.setCellValue(lstWeeklyDataFinal.get(rowCount).getMacdSignalWeekly());

				Cell cell16 = newRow.createCell(16);
				cell16.setCellValue(lstWeeklyDataFinal.get(rowCount).getADXWeekly());

				Cell cell17 = newRow.createCell(17);
				cell17.setCellValue(lstWeeklyDataFinal.get(rowCount).getPDIWeekly());

				Cell cell18 = newRow.createCell(18);
				cell18.setCellValue(lstWeeklyDataFinal.get(rowCount).getMDIWeekly());

				Cell cell19 = newRow.createCell(19);
				cell19.setCellValue(lstWeeklyDataFinal.get(rowCount).getMACDBuyOrSell());

				Cell cell20 = newRow.createCell(20);
				cell20.setCellValue(lstWeeklyDataFinal.get(rowCount).getEMABuyOrSell());

				Cell cell21 = newRow.createCell(21);
				cell21.setCellValue(lstWeeklyDataFinal.get(rowCount).getBBBuyOrSell());

				Cell cell22 = newRow.createCell(22);
				cell22.setCellValue(lstWeeklyDataFinal.get(rowCount).getADXBuyOrSell());

				Cell cell23 = newRow.createCell(23);
				cell23.setCellValue(lstWeeklyDataFinal.get(rowCount).getMACDAboveSignal());

			}

			// Close input stream

			try {
				finalWeeklyfileInputStream.close();

				// Create an object of FileOutputStream class to create write data in excel file

				FileOutputStream WeeklyOutputStream = new FileOutputStream(finalfile);

				// write data in the excel file

				finalWeeklyworkBook.write(WeeklyOutputStream);

				// close output stream

				WeeklyOutputStream.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
