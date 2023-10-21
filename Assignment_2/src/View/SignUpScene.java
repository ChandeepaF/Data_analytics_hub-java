package View;

import java.io.IOException;

import Controller.SignUpController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpScene {
	
	private Stage primaryStage;
	
	public SignUpScene(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	

	public String getTitle() {
		return "Sign Up";
	}
	
	public Scene getScene() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("sign_up.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SignUpController controller = new SignUpController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(parent);
		
		return scene;
		
	}
}
