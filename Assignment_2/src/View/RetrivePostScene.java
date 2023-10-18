package View;

import Scene.FXMLLoader;
import Scene.IOException;
import Scene.Parent;
import Scene.Scene;

public class RetrivePostScene {

	public String getTitle() {
		return "Retrieve a post";
	}
	
	public Scene getScene() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("retrieve_post.fxml"));
		
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
