package pojos;

import java.util.Date;

public class WeeklyDataAnalysis {

	
	//WEEKLY ACC Date:2020-09-11  Open:1315.00  High:1355.40  Low:1289.00  Close:1321.55  Volume:5.320M  BBUB:1456.01  BBLB:1153.29  BBMB:1304.65  RSI:53.05  MACD:25.86  MacdSignal:39.70  ADX:16.48  PDI:15.47  MDI:20.56  

	private String	WeeklyorDaily	;
	private String	StockName	;
	private Date	WeekDate	;
	private Double	OpenPriceWeekly	;
	private Double	HighPriceWeekly	;
	private Double	LowPriceWeekly	;
	private Double	ClosePriceWeekly	;
	private Double	VolumeWeekly	;
	private Double	BBUBWeekly	;
	private Double	BBLBWeekly	;
	private Double	BBMBWeekly	;
	private Double	ema20Weekly	;
	private Double	ema06Weekly	;
	private Double	RSIWeekly	;
	private Double	MACDWeekly	;
	private Double	MacdSignalWeekly	;
	private Double  PSAR2006Weekly;
	private Double	ADXWeekly	;
	private Double	PDIWeekly	;
	private Double	MDIWeekly	;
	private String  MACDBuyOrSell;
	private double  MACDAboveSignal;
	private String  RSIBuyOrSell;
	private String  BBBuyOrSell;
	private String  ADXBuyOrSell;
	private String  EMABuyOrSell;
	private Double	ema50Weekly	;
	private Double	ema200Weekly	;
	
	
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
	public Date getWeekDate() {
		return WeekDate;
	}
	public void setWeekDate(Date weekDate) {
		WeekDate = weekDate;
	}
	public Double getOpenPriceWeekly() {
		return OpenPriceWeekly;
	}
	public void setOpenPriceWeekly(Double openPriceWeekly) {
		OpenPriceWeekly = openPriceWeekly;
	}
	public Double getHighPriceWeekly() {
		return HighPriceWeekly;
	}
	public void setHighPriceWeekly(Double highPriceWeekly) {
		HighPriceWeekly = highPriceWeekly;
	}
	public Double getLowPriceWeekly() {
		return LowPriceWeekly;
	}
	public void setLowPriceWeekly(Double lowPriceWeekly) {
		LowPriceWeekly = lowPriceWeekly;
	}
	public Double getClosePriceWeekly() {
		return ClosePriceWeekly;
	}
	public void setClosePriceWeekly(Double closePriceWeekly) {
		ClosePriceWeekly = closePriceWeekly;
	}
	public Double getVolumeWeekly() {
		return VolumeWeekly;
	}
	public void setVolumeWeekly(Double volumeWeekly) {
		VolumeWeekly = volumeWeekly;
	}
	public Double getBBUBWeekly() {
		return BBUBWeekly;
	}
	public void setBBUBWeekly(Double bBUBWeekly) {
		BBUBWeekly = bBUBWeekly;
	}
	public Double getBBLBWeekly() {
		return BBLBWeekly;
	}
	public void setBBLBWeekly(Double bBLBWeekly) {
		BBLBWeekly = bBLBWeekly;
	}
	public Double getBBMBWeekly() {
		return BBMBWeekly;
	}
	public void setBBMBWeekly(Double bBMBWeekly) {
		BBMBWeekly = bBMBWeekly;
	}
	public Double getEma20Weekly() {
		return ema20Weekly;
	}
	public void setEma20Weekly(Double ema20Weekly) {
		this.ema20Weekly = ema20Weekly;
	}
	public Double getEma06Weekly() {
		return ema06Weekly;
	}
	public void setEma06Weekly(Double ema06Weekly) {
		this.ema06Weekly = ema06Weekly;
	}
	
	public Double getEma50Weekly() {
		return ema50Weekly;
	}
	public void setEma50Weekly(Double ema50Weekly) {
		this.ema50Weekly = ema50Weekly;
	}
	public Double getEma200Weekly() {
		return ema200Weekly;
	}
	public void setEma200Weekly(Double ema200Weekly) {
		this.ema200Weekly = ema200Weekly;
	}
	
	public Double getRSIWeekly() {
		return RSIWeekly;
	}
	public void setRSIWeekly(Double rSIWeekly) {
		RSIWeekly = rSIWeekly;
	}
	public Double getMACDWeekly() {
		return MACDWeekly;
	}
	public void setMACDWeekly(Double mACDWeekly) {
		MACDWeekly = mACDWeekly;
	}
	public Double getMacdSignalWeekly() {
		return MacdSignalWeekly;
	}
	public void setMacdSignalWeekly(Double macdSignalWeekly) {
		MacdSignalWeekly = macdSignalWeekly;
	}
	public Double getADXWeekly() {
		return ADXWeekly;
	}
	public void setADXWeekly(Double aDXWeekly) {
		ADXWeekly = aDXWeekly;
	}
	public Double getPDIWeekly() {
		return PDIWeekly;
	}
	public void setPDIWeekly(Double pDIWeekly) {
		PDIWeekly = pDIWeekly;
	}
	public Double getMDIWeekly() {
		return MDIWeekly;
	}
	public void setMDIWeekly(Double mDIWeekly) {
		MDIWeekly = mDIWeekly;
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

	public Double getPSAR2006Weekly() {
		return PSAR2006Weekly;
	}
	public void setPSAR2006Weekly(Double pSAR2006Weekly) {
		this.PSAR2006Weekly = pSAR2006Weekly;
	}
	
}
