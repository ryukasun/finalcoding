package rocket.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController implements Initializable {

	private MainApp mainApp;
	ObservableList<String> comboList = FXCollections.observableArrayList("15 Years","30 Years");
	
	@FXML
	public ComboBox<String> loanTerm;
	@FXML
	public TextField txtIncome;
	@FXML
	public TextField txtExpenses;
	@FXML
	public TextField txtCreditScore;
	@FXML
	public TextField txtHouseCost;
	@FXML
	public SplitMenuButton Term;
	
	
	@FXML
	public Button loanPayment;
	
	
	
	//	TODO - RocketClient.RocketMainController
	
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		double Income = Double.parseDouble(txtIncome.toString());
		double Expenses = Double.parseDouble(txtExpenses.toString());
		int CreditScore = Integer.parseInt(txtCreditScore.toString());
		double HouseCost = Double.parseDouble(txtHouseCost.toString());
		lq.setdIncome(Income);
		lq.setdExpenses(Expenses);
		lq.setiCreditScore(CreditScore);
		lq.setdAmount(HouseCost);
		//lq.setdAmount(txtExpenses.toString());
//		lq.setiTerm(iTerm);
//		lq.setdRate(dRate);
//		lq.setiCreditScore(iCreditScore);
//		lq.setiDownPayment(iDownPayment);
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq

		a.setLoanRequest(lq);
		
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		loanTerm.setItems(comboList);
	}

}
