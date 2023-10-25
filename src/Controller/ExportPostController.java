package Controller;

import java.io.File;

import Model.TestModel;
import View.DashboardScene;
import View.VipDashboardScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class ExportPostController {
	
	String name = null;
	
	private Stage primaryStage;

	private String folderPath;
	
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPath(String folderPath) {
		this.folderPath = folderPath;
	}

	
	@FXML
	private TextField idTextField;
	
	@FXML
	private TextField filenameTextField;
	
	@FXML
	private Label outputLabel;
	
	@FXML
	private Label pathLabel;
	
		
	
	@FXML
	public void choosefolderButtonHandler(ActionEvent event) {
		
		DirectoryChooser directoryChooser = new DirectoryChooser();
		
		File file = directoryChooser.showDialog(primaryStage);
		
		if(file != null) {
			
			folderPath = file.getAbsolutePath();
			
			pathLabel.setText(folderPath);
			
		}
		
	}
	
	
	
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().exportCsvPost(idTextField.getText(), folderPath, filenameTextField.getText());
		
		outputLabel.setText(result);
		
	}
	
	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		String User = TestModel.Store_userType.get(0);
		
		if (User.equals("normal")) {
		
			DashboardScene dashboardScene = new DashboardScene(primaryStage, name);
			primaryStage.setTitle(dashboardScene.getTitle());
			primaryStage.setScene(dashboardScene.getScene());
	
			primaryStage.show();
			
			}
		
		if (User.equals("vip")) {
			
			VipDashboardScene vipDashboardScene = new VipDashboardScene(primaryStage, name);
			primaryStage.setTitle(vipDashboardScene.getTitle());
			primaryStage.setScene(vipDashboardScene.getScene());
	
			primaryStage.show();
			
			}
	}
	
}
