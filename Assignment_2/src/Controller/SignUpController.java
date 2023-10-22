package Controller;

import Model.TestModel;
import View.FirstPageScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	

	@FXML
	private TextField usernameTextField;
	
	@FXML
	private TextField passwordTextField;
	
	@FXML
	private TextField firstnameTextField;
	
	@FXML
	private TextField lastnameTextField;
	
	@FXML
	private Label outputLabel;
	
	
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().addPersonalData(usernameTextField.getText(),
				passwordTextField.getText(),firstnameTextField.getText(),lastnameTextField.getText());
		
		outputLabel.setText(result);
	}
	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		FirstPageScene firstPageScene = new FirstPageScene(primaryStage);
		primaryStage.setTitle(firstPageScene.getTitle());
		primaryStage.setScene(firstPageScene.getScene());
		
		primaryStage.show();
	}
		
}



