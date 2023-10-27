package Controller;

import Model.HubModel;
import View.DashboardScene;
import View.VipDashboardScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RetriveLikesController {
	
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
	public void submitButtonHandler(ActionEvent event) {
		
		String result = HubModel.getInstance().retrieveTopLikes(idTextField.getText());
		
		outputLabel.setText(result);
	}
	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		String User = HubModel.Store_userType.get(0);
		
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