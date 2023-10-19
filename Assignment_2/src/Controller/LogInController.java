package Controller;

import Model.TestModel;
import Model.Exceptions.Invalid_Password_Exception;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LogInController {


	@FXML
	private TextField usernameLoginTextField;
	
	@FXML
	private TextField passwordLoginTextField;
	
	@FXML
	private Label outputLabel;
	
	
	@FXML
	public void verifyButtonHandler(ActionEvent event) throws Invalid_Password_Exception {
		
		String result = TestModel.getInstance().verify_Login_Data(usernameLoginTextField.getText(),
				passwordLoginTextField.getText());
		
		outputLabel.setText(result);
	}
		
}
