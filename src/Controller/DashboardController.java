package Controller;

import Model.HubModel;
import Model.Exceptions.InvalidPasswordException;
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
	
	// This is the dashboard for the normal user
	
	// Defining the primary stage
	private Stage primaryStage;

	// Defining the name of the user
	private static String name;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;

	}
	

	// Label is imported to display the output/ result
	@FXML
	private Label nameLabel;
	
	@FXML
	private AnchorPane scenePane;
	
	
	// The setName is defined to set the name to this controller, in a static way
	public static void setName(String name) {
		DashboardController.name = name;
	}
	
	
	// "displayName" method is defined to set the name to the nameLabel that is supposed to display the name of the user 
	public void displayName(String name) {
		
		try {
			nameLabel.setText("Welcome " + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// The button on the normal dashboard to update the user details
	@FXML
	public void changedetailsButtonHandler(ActionEvent event) {
		
		// The scene will switch to the "EditProfileScene" which allows to update user details, upon clicking of the button
		// The primaryStage is passed onto it along with the name of the user
		EditProfileScene editProfileScene = new EditProfileScene(primaryStage, name);
		primaryStage.setTitle(editProfileScene.getTitle());
		primaryStage.setScene(editProfileScene.getScene());
	
		primaryStage.show();
	}
	
	
	// The button on the normal dashboard to add a new post
	@FXML
	public void addpostButtonHandler(ActionEvent event) {
		
		// The scene will switch to the "AddPostScene" which allows to add a new post, upon clicking of the button
		AddPostScene addPostScene = new AddPostScene(primaryStage, name);
		primaryStage.setTitle(addPostScene.getTitle());
		primaryStage.setScene(addPostScene.getScene());
		
		primaryStage.show();
	}
	
	
	// The button on the normal dashboard to retrieve a post in the database
	@FXML
	public void retrievepostButtonHandler(ActionEvent event) {
		
		// The scene will switch to the "RetrivePostScene" which allows to retrieve a post, upon clicking of the button
		RetrivePostScene retrivePostScene = new RetrivePostScene(primaryStage, name);
		primaryStage.setTitle(retrivePostScene.getTitle());
		primaryStage.setScene(retrivePostScene.getScene());
		
		primaryStage.show();
	}
	
	
	// The button on the normal dashboard to retrieve posts with likes arranged in descending order
	@FXML
	public void retrievelikesButtonHandler(ActionEvent event) {
		
		// The scene will switch to the "RetriveLikesScene" which allows to retrieve post/posts with the most likes, upon clicking of the button
		RetriveLikesScene retriveLikesScene = new RetriveLikesScene(primaryStage, name);
		primaryStage.setTitle(retriveLikesScene.getTitle());
		primaryStage.setScene(retriveLikesScene.getScene());
		
		primaryStage.show();
	}
	
	
	// The button on the normal dashboard to remove a post in the database
	@FXML
	public void removepostButtonHandler(ActionEvent event) {
		
		// The scene will switch to the "RemovePostScene" which allows to remove a post, upon clicking of the button
		RemovePostScene removePostScene = new RemovePostScene(primaryStage, name);
		primaryStage.setTitle(removePostScene.getTitle());
		primaryStage.setScene(removePostScene.getScene());
		
		primaryStage.show();		
	}
	
	
	// The button on the normal dashboard to export a post in the database
	@FXML
	public void exportpostButtonHandler(ActionEvent event) {
		
		// The scene will switch to the "ExportPostScene" which allows to export a post, upon clicking of the button
		ExportPostScene exportPostScene = new ExportPostScene(primaryStage, name);
		primaryStage.setTitle(exportPostScene.getTitle());
		primaryStage.setScene(exportPostScene.getScene());
		
		primaryStage.show();		
	}
	
	
	// The button on the normal dashboard to Logout of the application
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
