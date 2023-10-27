package View;

import java.io.IOException;

import Controller.FirstPageController;
import Controller.RemovePostController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RemovePostScene {
	
	// Defining the primary stage
	private Stage primaryStage;
	
	// Defining the user's name
	private String name;
	
	// Defining the scene to be passed onto the stage
	private Scene scene;
	
	// Defining the constructor for the above attributes
	public RemovePostScene(Stage primaryStage, String name) {
		this.primaryStage = primaryStage;
		this.name = name;
		scene = null;
	}

	
	// To define the title of the scene
	public String getTitle() {
		return "Remove a post";
	}
	
	
	// To define the scene
	public Scene getScene() {
		
		// To make sure that the same scene is not loaded twice
		if(scene != null) {
			return scene;
		}
		
		// To load the relevant fxml file 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("remove_post.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// An "RemovePostController" object is created and the controller is added to the scene. 
		// The primary stage and the name of the user are passed along
		RemovePostController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		controller.setName(name);
		
		// A new scene object is created  
		Scene scene = new Scene(parent,600,600,Color.LIGHTBLUE);
		
		return scene;
		
	}
}