package Controller;



import java.awt.Label;

import Model.TestModel;

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
	private Label outputLabelVerify;
	
	@FXML
	private Label outputLabelSave;
	
	
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().addPersonalData(usernameTextField.getText(),
				passwordTextField.getText(),firstnameTextField.getText(),lastnameTextField.getText());
		
		outputLabelVerify.setText(result);
	}
	
	
	@FXML
	public void saveToDatabaseHandler(ActionEvent event) {
		
		String output = TestModel.getInstance().Save_Personal_Details(usernameTextField.getText(),
				passwordTextField.getText(),firstnameTextField.getText(),lastnameTextField.getText());
		
		outputLabelSave.setText(output);
	}
		
}
