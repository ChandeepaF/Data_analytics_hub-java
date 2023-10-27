package View;

import java.io.IOException;

import Controller.LogInController;
import Controller.SignUpController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SignUpScene {
	
	// Defining the primary stage
	private Stage primaryStage;
	
	// Defining the scene to be passed onto the stage
	private Scene scene;
	
	// Defining the constructor for the above attributes
	public SignUpScene(Stage primaryStage) {
		this.primaryStage = primaryStage;
		scene = null;
	}
	

	// To define the title of the scene
	public String getTitle() {
		return "Sign Up";
	}
	

	// To define the scene
	public Scene getScene() {
		
		// To make sure that the same scene is not loaded twice
		if(scene != null) {
			return scene;
		}
		
		// To load the relevant fxml file 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("sign_up.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// An "SignUpController" object is created and the controller is added to the scene. 
		// The primary stage and the name of the user are passed along
		SignUpController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		// A new scene object is created  
		Scene scene = new Scene(parent,750,700,Color.LIGHTBLUE);
		
		return scene;
		
	}
}
