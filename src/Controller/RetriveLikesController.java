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
	
		
	// The button to submit the number of the post to be retrieved according to the likes. ActionEvent captures the click of the submit button 
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		// The "retrieveTopLikes" method is called to get and pass on the number of posts to be retrieved according to the likes
		String result = HubModel.getInstance().retrieveTopLikes(idTextField.getText());
		// The result from the above method is displayed to the user
		outputLabel.setText(result);
	}
	
	
	// The previous button to switch back to the previous scene which is the dashboard 
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