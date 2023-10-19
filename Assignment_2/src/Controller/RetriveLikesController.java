package Controller;

import Model.TestModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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