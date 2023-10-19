package Controller;

import Model.TestModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
	
	
		
}
