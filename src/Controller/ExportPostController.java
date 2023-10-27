package Controller;

import java.io.File;

import Model.HubModel;
import View.DashboardScene;
import View.VipDashboardScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class ExportPostController {
	
	// initiating the name to be passed on to the add post controller
	String name = null;
	
	// Defining the primary stage
	private Stage primaryStage;

	// Defining the path of the folder to be exported to
	private String folderPath;
	
	// Setting the primary stage
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPath(String folderPath) {
		this.folderPath = folderPath;
	}

	
	// To import the different nodes that are present in the fxml file in scene builder
	@FXML
	private TextField idTextField;
	
	@FXML
	private TextField filenameTextField;
	
	@FXML
	private Label outputLabel;
	
	@FXML
	private Label pathLabel;
	
	
	// The button to choose the folder to export the post to. ActionEvent captures the click of the submit button
	@FXML
	public void choosefolderButtonHandler(ActionEvent event) {
		
		// DirectoryChooser is called to retrieve the directory of the chosen folder
		DirectoryChooser directoryChooser = new DirectoryChooser();
		
		// The primaryStage will then be passed on to the directory chooser to choose the appropriate folder
		File file = directoryChooser.showDialog(primaryStage);
		
		// If a certain folder is selected
		if(file != null) {
			
			// The "absolute path" of that chosen folder is stored. 
			folderPath = file.getAbsolutePath();
			
			// The folder path is displayed to the user
			pathLabel.setText(folderPath);
			
		}
		
	}
	
	
	// The button to submit the Post Id, Folder Path, and the filename after entering. ActionEvent captures the click of the submit button
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		// The "exportCsvPost" method is called and the appropriate fields are passed in order to the "exportCsvPost" method
		String result = HubModel.getInstance().exportCsvPost(idTextField.getText(), folderPath, filenameTextField.getText());
		
		// The output from the above method is set as text to the label to display to the user
		outputLabel.setText(result);
		
	}
	
	
	// The previous button to take switch back to the previous scene which is the dashboard 
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		// Method to get the type of user from the HubModel 
		String User = HubModel.Store_userType.get(0);
		
		// If the user is a "normal" user, the scene will switch to the normal dashboard
		if (User.equals("normal")) {
		
			DashboardScene dashboardScene = new DashboardScene(primaryStage, name);
			primaryStage.setTitle(dashboardScene.getTitle());
			primaryStage.setScene(dashboardScene.getScene());
	
			primaryStage.show();
			
			}
		
		// If the user is a "vip" user, the scene will switch to the vip dashboard
		if (User.equals("vip")) {
			
			VipDashboardScene vipDashboardScene = new VipDashboardScene(primaryStage, name);
			primaryStage.setTitle(vipDashboardScene.getTitle());
			primaryStage.setScene(vipDashboardScene.getScene());
	
			primaryStage.show();
			
			}
	}
	
}
