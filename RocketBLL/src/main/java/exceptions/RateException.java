package exceptions;

import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	private RateDomainModel dummyRate;
	private LoanRequest dummyLoan;

	public RateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RateException(RateDomainModel DummyRate) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RateException(LoanRequest dummyLoan) {
		super();
		// TODO Auto-generated constructor stub
	}
	

//	public RateException(Throwable cause) {
//		super(cause);
//		// TODO Auto-generated constructor stub
//	}

	public RateDomainModel getDummyRate() {
		return dummyRate;
	}

	public LoanRequest getDummyLoan() {
		return dummyLoan;
	}
	
	
	
	

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}
