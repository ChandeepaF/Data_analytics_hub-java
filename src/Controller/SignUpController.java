package Controller;

import Model.HubModel;
import View.FirstPageScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {
	
	// Defining the primary stage
	private Stage primaryStage;
	
	// Setting the primary stage
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	

	// To import the different nodes that are present in the fxml file in scene builder
	@FXML
	private TextField usernameTextField;
	
	@FXML
	private TextField passwordTextField;
	
	@FXML
	private TextField firstnameTextField;
	
	@FXML
	private TextField lastnameTextField;
	
	@FXML
	private Label outputLabel;
	
	
	// The button to submit the entered details of the new user. ActionEvent captures the click of the submit button 
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		// The "addPersonalData" method is called to get and pass on the data of the new user to be stored in the database
		String result = HubModel.getInstance().addPersonalData(usernameTextField.getText(),
				passwordTextField.getText(),firstnameTextField.getText(),lastnameTextField.getText());
		
		// The result from the above method is displayed to the user
		outputLabel.setText(result);
	}
	
	
	// The previous button to switch back to the previous scene which is to either sign up or login 
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		FirstPageScene firstPageScene = new FirstPageScene(primaryStage);
		primaryStage.setTitle(firstPageScene.getTitle());
		primaryStage.setScene(firstPageScene.getScene());
		
		primaryStage.show();
	}
		
}



