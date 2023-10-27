
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
		
		// The first scene to be displayed once the program is run is the "FirstPageScene" containing the login or sign up options
		FirstPageScene firstPageScene = new FirstPageScene(primaryStage);
		primaryStage.setTitle(firstPageScene.getTitle());
		primaryStage.setScene(firstPageScene.getScene());
		
		// An icon is added to the stage to be displayed through all the scenes
		Image icon = new Image("icon.png");
		primaryStage.getIcons().add(icon);
		
		// To set the width of the primary stage
		primaryStage.setWidth(750);
		
		// To set the height of the primary stage
		primaryStage.setHeight(700);
		
		// Finally, to show the primary stage
		primaryStage.show();
		
		// To make sure that the user is asked if they want to exit, upon clicking the close (X) button at the top of the window
		primaryStage.setOnCloseRequest(event -> {
			event.consume();
			logoutButtonHandler(primaryStage);
		});
	}
	
	
	//
	public void logoutButtonHandler(Stage primaryStage) {
			
			//"Alert" is called and an alert object is created in order to get confirmation upon clicking the close (X) button
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Logout");
			
			// A small window with the following header is shown upon clicking logout
			alert.setHeaderText("You are about to logout!");
			// The following message is contained in the small window that is displayed, requesting to confirm
			alert.setContentText("Are you sure you want to exit?: ");
			
			// "showAndWait()" is called to display the message and wait for users response to see if the "OK" button is clicked 
			if(alert.showAndWait().get() == ButtonType.OK)
				System.out.println("You successfully logged out!");
			primaryStage.close();
			
		}
	

	public static void main(String[] args) {

		// To launch the program
		launch(args);
	}

}