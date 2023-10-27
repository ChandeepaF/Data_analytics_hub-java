package Controller;

import View.FirstPageScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class VipSignoutController {

String name = null;
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	
	// The button to logout of the application once the user has upgraded to a vip 
	@FXML
	public void logoutButtonHandler(ActionEvent event) {
		
		//"Alert" is called and an alert object is created in order to get confirmation upon clicking logout
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		
		// A small window with the following header is shown upon clicking logout
		alert.setHeaderText("You are about to logout!");
		
		// The following message is contained in the small window that is displayed, requesting to confirm
		alert.setContentText("Are you sure you want to exit?: ");
		
		// "showAndWait()" is called to display the message and wait for users response to see if the "OK" button is clicked 
		if(alert.showAndWait().get() == ButtonType.OK) {
			
			// If the "OK" button is clicked, it will redirect to the "FirstPageScene" which allows the user to login again
			FirstPageScene firstPageScene = new FirstPageScene(primaryStage);
			primaryStage.setTitle(firstPageScene.getTitle());
			primaryStage.setScene(firstPageScene.getScene());
			primaryStage.show();
			
		}
		
	}
}
