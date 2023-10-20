package Controller;



import java.awt.Label;

import Model.TestModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SignUpController {

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
	
	
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().addPersonalData(usernameTextField.getText(),
				passwordTextField.getText(),firstnameTextField.getText(),lastnameTextField.getText());
		
		outputLabel.setText(result);
	}
		
}
