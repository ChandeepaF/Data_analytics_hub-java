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
	
	private Stage primaryStage;
	private String name;
	
	private Scene scene;
	
	public RemovePostScene(Stage primaryStage, String name) {
		this.primaryStage = primaryStage;
		this.name = name;
		scene = null;
	}

	public String getTitle() {
		return "Remove a post";
	}
	
	public Scene getScene() {
		
		if(scene != null) {
			return scene;
		}
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("remove_post.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		RemovePostController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		controller.setName(name);
		
		Scene scene = new Scene(parent,600,600,Color.LIGHTBLUE);
		
		return scene;
		
	}
}