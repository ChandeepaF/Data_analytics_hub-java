package Controller;

import Model.TestModel;

public class RetriveLikesController {
	
	@FXML
	private TextField idTextField;
	
	@FXML
	private Label outputLabelVerify;
	
		
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().retrieveTopLikes(idTextField.getText());
		
		outputLabelVerify.setText(result);
	}
	
}