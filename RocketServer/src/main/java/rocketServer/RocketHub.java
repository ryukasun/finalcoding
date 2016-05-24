package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			//double iMessage = (Double) message;
			try {
				_RateBLL.getRate(lq.getiCreditScore());
				double lRate = _RateBLL.getRate(lq.getiCreditScore());
				lq.setdRate(lRate);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//double lRate = _RateBLL.getRate(lq.getiCreditScore());
			//lq.setdRate(lRate);
			

			double lPayment = _RateBLL.getPayment(lq.getdRate(), lq.getiTerm(), lq.getdAmount(), 0,true);
			lq.setdPayment(lPayment);
			
			
			
			
			//	TODO - RocketHub.messageReceived

			//	You will have to:
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			//		If exception, show error message, stop processing
			//		If no exception, continue
			//	Determine if payment, call RateBLL.getPayment
			//	
			//	you should update lq, and then send lq back to the caller(s)
			
			sendToAll(lq);
		}
	}
}
