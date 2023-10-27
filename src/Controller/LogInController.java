package Controller;

import Model.HubModel;
import Model.Exceptions.InvalidPasswordException;
import Model.Exceptions.InvalidUsernameException;
import View.DashboardScene;
import View.FirstPageScene;
import View.UpgradeVipScene;
import View.VipDashboardScene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LogInController {
	
	
	// Defining the primary stage
	private Stage primaryStage;
	
	// Setting the primary stage
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	// To import the different nodes that are present in the fxml file in scene builder
	@FXML
	private TextField usernameLoginTextField;
	
	@FXML
	private TextField passwordLoginTextField;
	
	@FXML
	private Label outputLabel;
	
	
	// The button to verify the login details entered by the user. ActionEvent captures the click of the submit button
	@FXML
	public void verifyButtonHandler(ActionEvent event) throws InvalidUsernameException,InvalidPasswordException {
		
		// The "verifyLoginData" method is called from HubModel
		String result = HubModel.getInstance().verifyLoginData(usernameLoginTextField.getText(),
				passwordLoginTextField.getText());
		
		
		// If "Access granted" given the login details are correct
		if(result.equals("Access granted")) {
			
			// The type of the customer is checked using the "getUserType" method
			String type = HubModel.getInstance().getUserType();
			
			// The full name of the user is then retrieved using the "getName" method
			String name = HubModel.getInstance().getName(usernameLoginTextField.getText());
			
			// "Access granted" is displayed to the user
			outputLabel.setText(result);
			
			// Timeline is imported to to delay the switching of the scenes. This gives enough time to show "Access granted" to the user
			// A delay duration of 3 seconds is determined before switching the scenes
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
			
			
			// If the type of user is normal
			if(type.equals("normal")){
			
				// The name of the user is passed to the "DashboardController" via the "setName" method
			    DashboardController.setName(name);
			
			    // The "UpgradeVipScene" is displayed asking the user if they want to upgrade to vip
			    // The name is also passed along to this scene in order for it to be passed along
				UpgradeVipScene upgradeVipScene = new UpgradeVipScene(primaryStage, name);
				primaryStage.setTitle(upgradeVipScene.getTitle());
				primaryStage.setScene(upgradeVipScene.getScene());
				
				primaryStage.show();
				
			}
			
			// If the type of user is vip
			if(type.equals("vip")) {
				
				// The name of the user is passed to the "VipDashboardController" via the "setName" method
				VipDashboardController.setName(name);
				
				// The "VipDashboardScene" is then displayed to the vip user
				VipDashboardScene vipDashboardScene = new VipDashboardScene(primaryStage, name);
				primaryStage.setTitle(vipDashboardScene.getTitle());
				primaryStage.setScene(vipDashboardScene.getScene());
				
				primaryStage.show();
				
			}
			}));
			
			// The above scene switches will occur after the determined delay
			timeline.play();
		}
		
		else {
			// Any errors with the entered login details is displayed to the user
			outputLabel.setText(result);
		}
				
	}

	
	// The previous button to switch back to the previous scene which is to either sign up or login 
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		FirstPageScene firstPageScene = new FirstPageScene(primaryStage);
		primaryStage.setTitle(firstPageScene.getTitle());
		primaryStage.setScene(firstPageScene.getScene());
		
		primaryStage.show();
	
	}
		
}
