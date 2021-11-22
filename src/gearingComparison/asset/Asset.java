package gearingComparison.asset;
import gearingComparison.liability.liability;

public class Asset {
	private double startValue;
	private double growthPercentage;
	private double incomePercentage;
	private liability loan;
	
	public double getStartValue() {
		return startValue;
	}
	public void setStartValue(double startValue) {
		this.startValue = startValue;
	}
	public double getGrowthPercentage() {
		return growthPercentage;
	}
	public void setGrowthPercentage(double growthPercentage) {
		this.growthPercentage = growthPercentage;
	}
	public double getIncomePercentage() {
		return incomePercentage;
	}
	public void setIncomePercentage(double incomePercentage) {
		this.incomePercentage = incomePercentage;
	}
	public liability getLoan() {
		return loan;
	}
	public void setLoan(liability loan) {
		this.loan = loan;
	}
	public Asset(double startValue, double growthPercentage, double incomePercentage) {
		this.startValue = startValue;
		this.growthPercentage = growthPercentage;
		this.incomePercentage = incomePercentage;
	}
	public Asset(double startValue, double growthPercentage, double incomePercentage, liability loan) {
		this.startValue = startValue;
		this.growthPercentage = growthPercentage;
		this.incomePercentage = incomePercentage;
		this.setLoan(loan);
	}
	
	public double futureValue(int years) {
		double result = this.startValue * Math.pow(1+this.growthPercentage,years);
		return result;
	}
	
	
	
	
	
	// TODO: method to calculate value as at certain date
}
