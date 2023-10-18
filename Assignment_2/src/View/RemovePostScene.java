package View;

import Scene.FXMLLoader;
import Scene.IOException;
import Scene.Parent;
import Scene.Scene;

public class RemovePostScene {

	public String getTitle() {
		return "Remove a post";
	}
	
	public Scene getScene() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("remove_post.fxml"));
		
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