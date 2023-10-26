package Controller;

import java.io.File;

import Model.TestModel;
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

	String name = null;
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@FXML
	private TextField idTextField;
	
	@FXML
	private Label outputLabel;
	
	
	
	@FXML
	public void choosepostsButtonHandler(ActionEvent event) {
		
		FileChooser fileChooser = new FileChooser();
		
		fileChooser.getExtensionFilters().add(new ExtensionFilter("posts", "*.csv"));
		
		File file = fileChooser.showOpenDialog(primaryStage);
		
		if(file != null) {
			
			String filePath = TestModel.getInstance().importCsvPosts(file.getAbsolutePath());
			
			outputLabel.setText(filePath);

		}
		
	}
	
	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		VipDashboardScene vipDashboardScene = new VipDashboardScene(primaryStage, name);
		primaryStage.setTitle(vipDashboardScene.getTitle());
		primaryStage.setScene(vipDashboardScene.getScene());

		primaryStage.show();
	}
}
