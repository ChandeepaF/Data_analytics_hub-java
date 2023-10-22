package Controller;

import Model.TestModel;
import Model.Exceptions.Invalid_Password_Exception;
import View.AddPostScene;
import View.EditProfileScene;
import View.ExportPostScene;
import View.FirstPageScene;
import View.RemovePostScene;
import View.RetriveLikesScene;
import View.RetrivePostScene;
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
		
		try {
			nameLabel.setText("Hello " + firstName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	@FXML
	public void changedetailsButtonHandler(ActionEvent event) {
		
		EditProfileScene editProfileScene = new EditProfileScene(primaryStage);
		primaryStage.setTitle(editProfileScene.getTitle());
		primaryStage.setScene(editProfileScene.getScene());
	
		primaryStage.show();
	}
	
	
	@FXML
	public void addpostButtonHandler(ActionEvent event) {
		
		AddPostScene addPostScene = new AddPostScene(primaryStage);
		primaryStage.setTitle(addPostScene.getTitle());
		primaryStage.setScene(addPostScene.getScene());
		
		primaryStage.show();
	}
	
	
	@FXML
	public void retrievepostButtonHandler(ActionEvent event) {
		
		RetrivePostScene retrivePostScene = new RetrivePostScene(primaryStage);
		primaryStage.setTitle(retrivePostScene.getTitle());
		primaryStage.setScene(retrivePostScene.getScene());
		
		primaryStage.show();
	}
	
	
	@FXML
	public void retrievelikesButtonHandler(ActionEvent event) {
		
		RetriveLikesScene retriveLikesScene = new RetriveLikesScene(primaryStage);
		primaryStage.setTitle(retriveLikesScene.getTitle());
		primaryStage.setScene(retriveLikesScene.getScene());
		
		primaryStage.show();
	}
	
	
	@FXML
	public void removepostButtonHandler(ActionEvent event) {
		
		RemovePostScene removePostScene = new RemovePostScene(primaryStage);
		primaryStage.setTitle(removePostScene.getTitle());
		primaryStage.setScene(removePostScene.getScene());
		
		primaryStage.show();		
	}
	
	@FXML
	public void exportpostButtonHandler(ActionEvent event) {
		
		ExportPostScene exportPostScene = new ExportPostScene(primaryStage);
		primaryStage.setTitle(exportPostScene.getTitle());
		primaryStage.setScene(exportPostScene.getScene());
		
		primaryStage.show();		
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
