package Controller;

import View.LogInScene;
import View.SignUpScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FirstPageController {

	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	@FXML
	public void loginButton(ActionEvent event) {
		
		LogInScene logInScene = new LogInScene(primaryStage);
		primaryStage.setTitle(logInScene.getTitle());
		primaryStage.setScene(logInScene.getScene());
		
		primaryStage.show();
	}
		
	
	@FXML
	public void signupButton(ActionEvent event) {
		
		SignUpScene SignUpScene = new SignUpScene(primaryStage);
		primaryStage.setTitle(SignUpScene.getTitle());
		primaryStage.setScene(SignUpScene.getScene());
		
		primaryStage.show();
	}
	
}
