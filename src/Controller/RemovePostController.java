package Controller;

import Model.TestModel;

public class RemovePostController {

	@FXML
	private TextField idTextField;
	
	@FXML
	private Label outputLabelVerify;
	
	@FXML
	private Label outputLabelSave;
	
	
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().deleteExistingPost(idTextField.getText());
		
		outputLabelVerify.setText(result);
	}
	
	
	@FXML
	public void RemoveFromDatabaseHandler(ActionEvent event) {
		
		String output = TestModel.getInstance().remove_Post_Data(idTextField.getText());
		
		outputLabelSave.setText(output);
	}
}
