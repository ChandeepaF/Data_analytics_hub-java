package View;

import java.io.IOException;

import Controller.DashboardController;
import Controller.FirstPageController;
import Model.HubModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DashboardScene {
	
	// Initializing the user's name
	String name = null;
	
	// Defining the primary stage
	private Stage primaryStage;
	
	// Defining the scene to be passed onto the stage
	private Scene scene;
	
	// Defining the constructor for the above attributes
	public DashboardScene(Stage primaryStage, String name) {
		this.primaryStage = primaryStage;
		this.name = name;
		scene = null;
	}

	
	// To define the title of the scene
	public String getTitle() {
		return "Dashboard";
	}
	
	
	// To define the scene
	public Scene getScene() {
		
		// To make sure that the same scene is not loaded twice
		if(scene != null) {
			return scene;
		}
		
		// To load the relevant fxml file 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// An "DashboardController" object is created and the controller is added to the scene. 
		// The primary stage and the name of the user are passed along
		DashboardController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);

		// The "displayName" method in the controller is called to display the name of the user
		controller.displayName(name);
		
		// A new scene object is created  
		Scene scene = new Scene(parent,600,600,Color.LIGHTBLUE);
		
		return scene;
		
	}
}
