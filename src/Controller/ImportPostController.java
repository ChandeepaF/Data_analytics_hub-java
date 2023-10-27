package Controller;

import java.io.File;

import Model.HubModel;
import View.DashboardScene;
import View.VipDashboardScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ImportPostController {

	// Initiating the name to be passed on to the add post controller
	String name = null;
	
	// Defining the primary stage
	private Stage primaryStage;
	
	// Setting the primary stage
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	// To import the different nodes that are present in the fxml file in scene builder
	@FXML
	private TextField idTextField;
	
	@FXML
	private Label outputLabel;
	
	
	// The button to import the posts. ActionEvent captures the click of the submit button 
	@FXML
	public void choosepostsButtonHandler(ActionEvent event) {
		
		// FileChooser is used to choose the file to import
		FileChooser fileChooser = new FileChooser();
		
		// The extension filter ensures that only csv files are imported
		fileChooser.getExtensionFilters().add(new ExtensionFilter("posts", "*.csv"));
		
		// The primaryStage will then be passed on to the file chooser to choose the appropriate file
		File file = fileChooser.showOpenDialog(primaryStage);
		
		// If a certain file is selected
		if(file != null) {
			// The "absolute path" of that chosen folder is stored and the "importCsvPosts" method is called from the HubModel
			String filePath = HubModel.getInstance().importCsvPosts(file.getAbsolutePath());
			
			// The result from the "importCsvPosts" method is displayed
			outputLabel.setText(filePath);

		}
		
	}
	
	
	// The previous button to switch back to the previous scene which is the dashboard 
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		// Since the import posts is a function of the vip users, the scene will switch to the vip dashboard
		// The "VipDashboardScene" is called and the primaryStage is passed onto it along with the name of the user
		VipDashboardScene vipDashboardScene = new VipDashboardScene(primaryStage, name);
		primaryStage.setTitle(vipDashboardScene.getTitle());
		primaryStage.setScene(vipDashboardScene.getScene());

		primaryStage.show();
	}
}
