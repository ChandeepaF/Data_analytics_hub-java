package View;

import Scene.FXMLLoader;
import Scene.IOException;
import Scene.Parent;
import Scene.Scene;

public class LogInScene {

	public String getTitle() {
		return "Log in";
	}
	
	public Scene getScene() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("log_in.fxml"));
		
		Parent parent = null;
		try {
			parent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(parent);
		
		return scene;
		
	}
}