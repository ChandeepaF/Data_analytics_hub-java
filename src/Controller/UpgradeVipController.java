package Controller;

import Model.HubModel;
import View.DashboardScene;
import View.VipSignoutScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpgradeVipController {

	String name = null;
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	@FXML
	public void subscribeButtonHandler(ActionEvent event) {
		
		String Result = HubModel.getInstance().upgradeVip();
		
		if (Result.equals("Type updated succesfully!")) {
		
			VipSignoutScene vipSignoutScene = new VipSignoutScene(primaryStage);
			primaryStage.setTitle(vipSignoutScene.getTitle());
			primaryStage.setScene(vipSignoutScene.getScene());
			
			primaryStage.show();
		}
	}
	
	
	@FXML
	public void denyButtonHandler(ActionEvent event) {
		
		DashboardScene dashboardScene = new DashboardScene(primaryStage, name);
		primaryStage.setTitle(dashboardScene.getTitle());
		primaryStage.setScene(dashboardScene.getScene());
		
		primaryStage.show();
	}
}
