package View;

import java.io.IOException;

import Controller.EditProfileController;
import Controller.FirstPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EditProfileScene {
	
	private Stage primaryStage;
	
	private Scene scene;
	
	public EditProfileScene(Stage primaryStage) {
		this.primaryStage = primaryStage;
		scene = null;
	}

	public String getTitle() {
		return "Edit Profile";
	}
	
	public Scene getScene() {
		
		if(scene != null) {
			return scene;
		}
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("edit_profile.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		EditProfileController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(parent,600,600,Color.LIGHTBLUE);
		
		return scene;
		
	}
}
