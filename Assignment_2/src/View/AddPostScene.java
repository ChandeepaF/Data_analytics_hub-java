package View;

import java.io.IOException;

import Controller.AddPostController;
import Controller.FirstPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddPostScene {
	
	private Stage primaryStage;
	
	private Scene scene;
	
	public AddPostScene(Stage primaryStage) {
		this.primaryStage = primaryStage;
		scene = null;
	}
	
	
	public String getTitle() {
		return "Add a Post";
	}
	
	public Scene getScene() {
		
		if(scene != null) {
			return scene;
		}
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("add_post.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AddPostController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(parent,600,600,Color.LIGHTBLUE);
		
		return scene;
		
	}
}