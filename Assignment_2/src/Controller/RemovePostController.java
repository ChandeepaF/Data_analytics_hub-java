package Controller;

import Model.TestModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RemovePostController {

	@FXML
	private TextField idTextField;
	
	@FXML
	private Label outputLabel;
	
	
	
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().deleteExistingPost(idTextField.getText());
		
		outputLabel.setText(result);
	}
	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		
	}
	
}
