package View;

import java.io.IOException;

import Controller.FirstPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LogInScene {
	
	private Stage primaryStage;
	
	private Scene scene;
	
	public LogInScene(Stage primaryStage) {
		this.primaryStage = primaryStage;
		scene = null;
	}

	public String getTitle() {
		return "Log in";
	}
	
	public Scene getScene() {
		
		if(scene != null) {
			return scene;
		}
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("log_in.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		FirstPageController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(parent,600,600,Color.LIGHTBLUE);
		
		return scene;
		
	}
}