package Controller;

import Model.TestModel;

public class AddPostController {


	@FXML
	private TextField idTextField;
	
	@FXML
	private TextField contentTextField;
	
	@FXML
	private TextField authorTextField;
	
	@FXML
	private TextField likesTextField;
	
	@FXML
	private TextField sharesTextField;
	
	@FXML
	private TextField datetimeTextField;
	
	@FXML
	private Label outputLabelVerify;
	
	@FXML
	private Label outputLabelSave;
	
	
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().addpostData(idTextField.getText(),
				contentTextField.getText(),authorTextField.getText(),likesTextField.getText(),
				sharesTextField.getText(),datetimeTextField.getText());
		
		outputLabelVerify.setText(result);
	}
	
	
	@FXML
	public void saveToDatabaseHandler(ActionEvent event) {
		
		String output = TestModel.getInstance().Save_Posts(idTextField.getText(),
				contentTextField.getText(),authorTextField.getText(),likesTextField.getText(),
				sharesTextField.getText(),datetimeTextField.getText());
		
		outputLabelSave.setText(output);
	}
		
}
