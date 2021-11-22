package gearingComparison.liability;

public class liability {
	private double interestRate;
	private double loanAmount;
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public liability(double interestRate, double loanAmount) {
		this.interestRate = interestRate;
		this.loanAmount = loanAmount;
	}
	
	// subtract provided figure from loan
	// works for negative (redraw) amounts as well 
	public void loanRepay(double repayment) {
		this.loanAmount -= repayment;
	}
	
	// TODO:method to print interest rate and loan amount
	// TODO: set optional loan limit
}

