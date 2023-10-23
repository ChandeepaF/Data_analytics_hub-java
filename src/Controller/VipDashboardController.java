package Controller;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VipDashboardController {

	private Stage primaryStage;

	private static String name;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;

	}
	

	@FXML
	private Label nameLabel;
	
	@FXML
	private AnchorPane scenePane;
	
	
	public static void setName(String name) {
		
		VipDashboardController.name = name;
	}
	
	
	public void displayName(String name) {
		
		try {
			nameLabel.setText("Hello " + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void changedetailsButtonHandler(ActionEvent event) {
		
		EditProfileScene editProfileScene = new EditProfileScene(primaryStage, name);
		primaryStage.setTitle(editProfileScene.getTitle());
		primaryStage.setScene(editProfileScene.getScene());
	
		primaryStage.show();
	}
	
	
	@FXML
	public void addpostButtonHandler(ActionEvent event) {
		
		AddPostScene addPostScene = new AddPostScene(primaryStage, name);
		primaryStage.setTitle(addPostScene.getTitle());
		primaryStage.setScene(addPostScene.getScene());
		
		primaryStage.show();
	}
	
	
	@FXML
	public void retrievepostButtonHandler(ActionEvent event) {
		
		RetrivePostScene retrivePostScene = new RetrivePostScene(primaryStage, name);
		primaryStage.setTitle(retrivePostScene.getTitle());
		primaryStage.setScene(retrivePostScene.getScene());
		
		primaryStage.show();
	}
	
	
	@FXML
	public void retrievelikesButtonHandler(ActionEvent event) {
		
		RetriveLikesScene retriveLikesScene = new RetriveLikesScene(primaryStage, name);
		primaryStage.setTitle(retriveLikesScene.getTitle());
		primaryStage.setScene(retriveLikesScene.getScene());
		
		primaryStage.show();
	}
	
	
	@FXML
	public void removepostButtonHandler(ActionEvent event) {
		
		RemovePostScene removePostScene = new RemovePostScene(primaryStage, name);
		primaryStage.setTitle(removePostScene.getTitle());
		primaryStage.setScene(removePostScene.getScene());
		
		primaryStage.show();		
	}
	
	
	@FXML
	public void exportpostButtonHandler(ActionEvent event) {
		
		ExportPostScene exportPostScene = new ExportPostScene(primaryStage, name);
		primaryStage.setTitle(exportPostScene.getTitle());
		primaryStage.setScene(exportPostScene.getScene());
		
		primaryStage.show();		
	}
	
	
	@FXML
	public void visualizesharesButtonHandler(ActionEvent event) {
		
//		ExportPostScene exportPostScene = new ExportPostScene(primaryStage, name);
//		primaryStage.setTitle(exportPostScene.getTitle());
//		primaryStage.setScene(exportPostScene.getScene());
//		
//		primaryStage.show();		
	}
	
	
	@FXML
	public void importpostsButtonHandler(ActionEvent event) {
		
//		ExportPostScene exportPostScene = new ExportPostScene(primaryStage, name);
//		primaryStage.setTitle(exportPostScene.getTitle());
//		primaryStage.setScene(exportPostScene.getScene());
//		
//		primaryStage.show();		
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
