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
	
	private Stage primaryStage;
	
	private Scene scene;
	
	public SignUpScene(Stage primaryStage) {
		this.primaryStage = primaryStage;
		scene = null;
	}
	

	public String getTitle() {
		return "Sign Up";
	}
	
	public Scene getScene() {
		
		if(scene != null) {
			return scene;
		}
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("sign_up.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		SignUpController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		
		Scene scene = new Scene(parent,600,600,Color.LIGHTBLUE);
		
		return scene;
		
	}
}
