package Controller;

import Model.TestModel;

public class RetrivePostController {

	@FXML
	private TextField idTextField;
	
	@FXML
	private Label outputLabelVerify;
	
		
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().retrieveExistingPost(idTextField.getText());
		
		outputLabelVerify.setText(result);
	}
	
}
