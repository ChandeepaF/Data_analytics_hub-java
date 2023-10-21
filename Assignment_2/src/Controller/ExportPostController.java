package Controller;

import Model.TestModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExportPostController {
	
private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	private TextField idTextField;
	
	@FXML
	private TextField folderTextField;
	
	@FXML
	private TextField filenameTextField;
	
	@FXML
	private Label outputLabel;
	
		
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().exportCsvPost(idTextField.getText(),
				folderTextField.getText(), filenameTextField.getText());
		
		outputLabel.setText(result);
	}
	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		
	}
	
}
