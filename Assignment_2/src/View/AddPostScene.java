package View;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddPostScene {
	
	private Stage primaryStage;
	
	public void AddPostScene(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	public String getTitle() {
		return "Add a Post";
	}
	
	public Scene getScene() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("add_post.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(parent,Color.LIGHTBLUE);
		
		return scene;
		
	}
}