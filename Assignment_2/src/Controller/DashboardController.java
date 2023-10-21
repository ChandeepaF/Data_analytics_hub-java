package Controller;

import Model.TestModel;
import Model.Exceptions.Invalid_Password_Exception;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardController {
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	

	@FXML
	private Label nameLabel;
	
	@FXML
	private AnchorPane scenePane;
	
	

	public void displayName(String firstName) {
		nameLabel.setText(firstName);
	}
	
	
	@FXML
	public void changedetailsButtonHandler(ActionEvent event) {
		
		
	}
	
	@FXML
	public void addpostButtonHandler(ActionEvent event) {
		
		
	}
	
	@FXML
	public void retrievepostButtonHandler(ActionEvent event) {
		
		
	}
	
	@FXML
	public void retrievelikesButtonHandler(ActionEvent event) {
		
		
	}
	
	@FXML
	public void removepostButtonHandler(ActionEvent event) {
		
		
	}
	
	@FXML
	public void exportpostButtonHandler(ActionEvent event) {
		
		
	}
	
	@FXML
	public void logoutButtonHandler(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You are about to logout!");
		alert.setContentText("Are you sure you want to exit?: ");
		
		if(alert.showAndWait().get() == ButtonType.OK)
			stage = (Stage) scenePane.getScene().getWindow();
			System.out.println("You successfully logged out!");
			stage.close();
		
	}
	
}
