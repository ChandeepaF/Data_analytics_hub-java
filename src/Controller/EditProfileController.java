package Controller;

import Model.HubModel;
import Model.Exceptions.InvalidUsernameException;
import View.DashboardScene;
import View.VipDashboardScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditProfileController {
	
	// initiating the name to be passed on to the edit profile controller
	String name = null;
	
	// Defining the primary stage
	private Stage primaryStage;
	
	// Setting the primary stage
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	// The name of the user is set to this controller
	public void setName(String name) {
		this.name = name;
	}


	// Relevant nodes are imported  
	@FXML
	private TextField currentusernameTextField;
	
	@FXML
	private TextField usernameTextField;
	
	@FXML
	private TextField passwordTextField;
	
	@FXML
	private TextField firstnameTextField;
	
	@FXML
	private TextField lastnameTextField;
	
	@FXML
	private Label outputLabel;
	
	
	// The button to submit the post details after entering. ActionEvent captures the click of the submit button 
	@FXML
	public void submitButtonHandler(ActionEvent event) throws InvalidUsernameException {
		
		// The "editProfile" method in the HubModel class is called and the "getText" method is called to get the user inputs in text fields
		// The textfields are passed in order to the method
		String result = HubModel.getInstance().editProfile(currentusernameTextField.getText(),usernameTextField.getText(),
				passwordTextField.getText(),firstnameTextField.getText(),lastnameTextField.getText());
		
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
