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
	
	
	
	@FXML
	public void logoutButtonHandler(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You are about to logout!");
		alert.setContentText("Are you sure you want to exit?: ");
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			
			FirstPageScene firstPageScene = new FirstPageScene(primaryStage);
			primaryStage.setTitle(firstPageScene.getTitle());
			primaryStage.setScene(firstPageScene.getScene());
			primaryStage.show();
			
		}
		
	}
}
