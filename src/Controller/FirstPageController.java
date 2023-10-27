package Controller;

import View.LogInScene;
import View.SignUpScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FirstPageController {
	
	// This is the first page that the user will see upon starting the application

	// Defining the primary stage
	private Stage primaryStage;
	
	// Setting the primary stage
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	// To switch to the "SignUpScene" where the user can enter their personal details and sign up to the application 
	@FXML
	public void signupButton(ActionEvent event) {
		
		SignUpScene SignUpScene = new SignUpScene(primaryStage);
		primaryStage.setTitle(SignUpScene.getTitle());
		primaryStage.setScene(SignUpScene.getScene());
		
		primaryStage.show();
	}
	
	
	
	// To switch to the "LogInScene" where the user can enter the login details and login to the application 
	@FXML
	public void loginButton(ActionEvent event) {
		
		LogInScene logInScene = new LogInScene(primaryStage);
		primaryStage.setTitle(logInScene.getTitle());
		primaryStage.setScene(logInScene.getScene());
		
		primaryStage.show();
	}
		
}
