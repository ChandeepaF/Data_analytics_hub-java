package Controller;

import Model.TestModel;
import Model.Exceptions.Invalid_Password_Exception;
import Model.Exceptions.Invalid_Username_Exception;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController {
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	@FXML
	private TextField usernameLoginTextField;
	
	@FXML
	private TextField passwordLoginTextField;
	
	@FXML
	private Label outputLabel;
	
	
	@FXML
	public void verifyButtonHandler(ActionEvent event) throws Invalid_Username_Exception,Invalid_Password_Exception {
		
		String result = TestModel.getInstance().verify_Login_Data(usernameLoginTextField.getText(),
				passwordLoginTextField.getText());
		
		outputLabel.setText(result);
	}
	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		
	}
		
}
