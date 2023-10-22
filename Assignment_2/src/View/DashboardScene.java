package View;

import java.io.IOException;

import Controller.DashboardController;
import Controller.FirstPageController;
import Model.TestModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DashboardScene {
	
	String firstName = null;
	
	private Stage primaryStage;
	
	private Scene scene;
	
	public DashboardScene(Stage primaryStage, String firstName) {
		this.primaryStage = primaryStage;
		this.firstName = firstName;
		scene = null;
	}

	
	public String getTitle() {
		return "Sign Up";
	}
	
	public Scene getScene() {
		
		if(scene != null) {
			return scene;
		}
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		DashboardController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);

		controller.displayName(firstName);
		
		Scene scene = new Scene(parent,600,600,Color.LIGHTBLUE);
		
		return scene;
		
	}
}
