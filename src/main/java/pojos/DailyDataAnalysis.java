package pojos;

import java.util.Date;

public class DailyDataAnalysis {
	
	private String	WeeklyorDaily	;
	private String	StockName	;
	private Date	TradeDate	;
	private Double	OpenPriceDaily	;
	private Double	HighPriceDaily	;
	private Double	LowPriceDaily	;
	private Double	ClosePriceDaily	;
	private Double	VolumeDaily	;
	private Double	BBUBDaily	;
	private Double	BBLBDaily	;
	private Double	BBMBDaily	;
	private Double	ema20Daily	;
	private Double	ema06Daily	;
	private Double	RSIDaily	;
	private Double	MACDDaily	;
	private Double	MacdSignalDaily	;
	private Double  PSARDaily	;
	private Double	ADXDaily	;
	private Double	PDIDaily	;
	private Double	MDIDaily	;
	private String  MACDBuyOrSell;
	private double  MACDAboveSignal;
	private String  RSIBuyOrSell;
	private String  BBBuyOrSell;
	private String  ADXBuyOrSell;
	private String  EMABuyOrSell;
	private String ScriptComments ;
	private Double	ema50Daily	;
	private Double	ema200Daily	;
	
	
	
		
	public String getWeeklyorDaily() {
		return WeeklyorDaily;
	}
	public void setWeeklyorDaily(String weeklyorDaily) {
		WeeklyorDaily = weeklyorDaily;
	}
	public String getStockName() {
		return StockName;
	}
	public void setStockName(String stockName) {
		StockName = stockName;
	}
	public Date getTradeDate() {
		return TradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		TradeDate = tradeDate;
	}
	public Double getOpenPriceDaily() {
		return OpenPriceDaily;
	}
	public void setOpenPriceDaily(Double openPriceDaily) {
		OpenPriceDaily = openPriceDaily;
	}
	public Double getHighPriceDaily() {
		return HighPriceDaily;
	}
	public void setHighPriceDaily(Double highPriceDaily) {
		HighPriceDaily = highPriceDaily;
	}
	public Double getLowPriceDaily() {
		return LowPriceDaily;
	}
	public void setLowPriceDaily(Double lowPriceDaily) {
		LowPriceDaily = lowPriceDaily;
	}
	public Double getClosePriceDaily() {
		return ClosePriceDaily;
	}
	public void setClosePriceDaily(Double closePriceDaily) {
		ClosePriceDaily = closePriceDaily;
	}
	public Double getVolumeDaily() {
		return VolumeDaily;
	}
	public void setVolumeDaily(Double volumeDaily) {
		VolumeDaily = volumeDaily;
	}
	public Double getBBUBDaily() {
		return BBUBDaily;
	}
	public void setBBUBDaily(Double bBUBDaily) {
		BBUBDaily = bBUBDaily;
	}
	public Double getBBLBDaily() {
		return BBLBDaily;
	}
	public void setBBLBDaily(Double bBLBDaily) {
		BBLBDaily = bBLBDaily;
	}
	public Double getBBMBDaily() {
		return BBMBDaily;
	}
	public void setBBMBDaily(Double bBMBDaily) {
		BBMBDaily = bBMBDaily;
	}
	public Double getEma20Daily() {
		return ema20Daily;
	}
	public void setEma20Daily(Double ema20Daily) {
		this.ema20Daily = ema20Daily;
	}
	public Double getEma06Daily() {
		return ema06Daily;
	}
	public void setEma06Daily(Double ema06Daily) {
		this.ema06Daily = ema06Daily;
	}
	public Double getRSIDaily() {
		return RSIDaily;
	}
	public void setRSIDaily(Double rSIDaily) {
		RSIDaily = rSIDaily;
	}
	public Double getMACDDaily() {
		return MACDDaily;
	}
	public void setMACDDaily(Double mACDDaily) {
		MACDDaily = mACDDaily;
	}
	public Double getMacdSignalDaily() {
		return MacdSignalDaily;
	}
	public void setMacdSignalDaily(Double macdSignalDaily) {
		MacdSignalDaily = macdSignalDaily;
	}
	public Double getADXDaily() {
		return ADXDaily;
	}
	public void setADXDaily(Double aDXDaily) {
		ADXDaily = aDXDaily;
	}
	public Double getPDIDaily() {
		return PDIDaily;
	}
	public void setPDIDaily(Double pDIDaily) {
		PDIDaily = pDIDaily;
	}
	public Double getMDIDaily() {
		return MDIDaily;
	}
	public void setMDIDaily(Double mDIDaily) {
		MDIDaily = mDIDaily;
	}
	public String getMACDBuyOrSell() {
		return MACDBuyOrSell;
	}
	public void setMACDBuyOrSell(String mACDBuyOrSell) {
		MACDBuyOrSell = mACDBuyOrSell;
	}
	public double getMACDAboveSignal() {
		return MACDAboveSignal;
	}
	public void setMACDAboveSignal(double mACDAboveSignal) {
		MACDAboveSignal = mACDAboveSignal;
	}
	public String getRSIBuyOrSell() {
		return RSIBuyOrSell;
	}
	public void setRSIBuyOrSell(String rSIBuyOrSell) {
		RSIBuyOrSell = rSIBuyOrSell;
	}
	public String getBBBuyOrSell() {
		return BBBuyOrSell;
	}
	public void setBBBuyOrSell(String bBBuyOrSell) {
		BBBuyOrSell = bBBuyOrSell;
	}
	public String getADXBuyOrSell() {
		return ADXBuyOrSell;
	}
	public void setADXBuyOrSell(String aDXBuyOrSell) {
		ADXBuyOrSell = aDXBuyOrSell;
	}
	public String getEMABuyOrSell() {
		return EMABuyOrSell;
	}
	public void setEMABuyOrSell(String eMABuyOrSell) {
		EMABuyOrSell = eMABuyOrSell;
	}

	public String getScriptComments() {
		return ScriptComments;
	}
	public void setScriptComments(String scriptComments) {
		ScriptComments = scriptComments;
	}
	public Double getEma50Daily() {
		return ema50Daily;
	}
	public void setEma50Daily(double d) {
		this.ema50Daily = d;
	}
	public Double getEma200Daily() {
		return ema200Daily;
	}
	public void setEma200Daily(double d) {
		this.ema200Daily = d;
	}
	public Double getPSARDaily() {
		return PSARDaily;
	}
	public void setPSARDaily(Double pSARDaily) {
		this.PSARDaily = pSARDaily;
	}

}
