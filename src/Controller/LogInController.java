package Controller;

import Model.TestModel;

public class LogInController {


	@FXML
	private TextField usernameLoginTextField;
	
	@FXML
	private TextField passwordLoginTextField;
	
	@FXML
	private Label outputLabel;
	
	
	@FXML
	public void verifyButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().login(usernameLoginTextField.getText(),
				passwordLoginTextField.getText());
		
		outputLabel.setText(result);
	}
		
}
