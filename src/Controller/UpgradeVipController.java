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
	
	
	// The button to subscribe as a vip user. ActionEvent captures the click of the submit button 
	@FXML
	public void subscribeButtonHandler(ActionEvent event) {
		
		// The "upgradeVip" method is called to upgrade the user to a vip member
		String Result = HubModel.getInstance().upgradeVip();
		
		// If the type is updated successfully, the user will be redirected to the "VipSignoutScene"
		// Here, the user will be asked to log out and log back in
		if (Result.equals("Type updated successfully!")) {
		
			// The primaryStage is passed onto the "VipSignoutScene"
			VipSignoutScene vipSignoutScene = new VipSignoutScene(primaryStage);
			primaryStage.setTitle(vipSignoutScene.getTitle());
			primaryStage.setScene(vipSignoutScene.getScene());
			
			primaryStage.show();
		}
	}
	
	
	// The button to deny the upgrade to a vip user. ActionEvent captures the click of the submit button 
	@FXML
	public void denyButtonHandler(ActionEvent event) {
		
		// The user will then be directed to the Dashboard of the normal user
		DashboardScene dashboardScene = new DashboardScene(primaryStage, name);
		primaryStage.setTitle(dashboardScene.getTitle());
		primaryStage.setScene(dashboardScene.getScene());
		
		primaryStage.show();
	}
}
