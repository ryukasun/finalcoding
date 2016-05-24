package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	//Here we will passin the credit score
	
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	//Here we will just make sure an exception is passed here through
	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
		assert(1==1);
	}
	@Test
	public void RocketDalrate_test(){
		ArrayList<RateDomainModel> ratess = RateDAL.getAllRates();
		

	}
	@Test
	public void RocketDalrate_testTwo(){
	}

}
