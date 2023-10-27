
import java.awt.Color;

import View.AddPostScene;
import View.DashboardScene;
import View.EditProfileScene;
import View.ExportPostScene;
import View.FirstPageScene;
import View.LogInScene;
import View.RemovePostScene;
import View.RetriveLikesScene;
import View.RetrivePostScene;
import View.SignUpScene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FirstPageScene firstPageScene = new FirstPageScene(primaryStage);
		primaryStage.setTitle(firstPageScene.getTitle());
		primaryStage.setScene(firstPageScene.getScene());
		
		Image icon = new Image("icon.png");
		primaryStage.getIcons().add(icon);
		
		primaryStage.setWidth(750);
		primaryStage.setHeight(700);
		
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(event -> {
			event.consume();
			logoutButtonHandler(primaryStage);
		});
	}
	
	
	public void logoutButtonHandler(Stage primaryStage) {
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Logout");
			alert.setHeaderText("You are about to logout!");
			alert.setContentText("Are you sure you want to exit?: ");
			
			if(alert.showAndWait().get() == ButtonType.OK)
				System.out.println("You successfully logged out!");
			primaryStage.close();
			
		}
	

	public static void main(String[] args) {

		launch(args);
	}

}