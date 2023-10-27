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
	
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	@FXML
	private TextField usernameLoginTextField;
	
	@FXML
	private TextField passwordLoginTextField;
	
	@FXML
	private Label outputLabel;
	
	
	@FXML
	public void verifyButtonHandler(ActionEvent event) throws InvalidUsernameException,InvalidPasswordException {
		
		String result = HubModel.getInstance().verifyLoginData(usernameLoginTextField.getText(),
				passwordLoginTextField.getText());
		
		
		if(result.equals("Access granted")) {
			
			String type = HubModel.getInstance().getUserType();
			
			String name = HubModel.getInstance().getName(usernameLoginTextField.getText());
			
			
			outputLabel.setText(result);
			
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
			
			
			if(type.equals("normal")){
			
			    DashboardController.setName(name);
			
				UpgradeVipScene upgradeVipScene = new UpgradeVipScene(primaryStage, name);
				primaryStage.setTitle(upgradeVipScene.getTitle());
				primaryStage.setScene(upgradeVipScene.getScene());
				
				primaryStage.show();
				
			}
			
			if(type.equals("vip")) {
				
				VipDashboardController.setName(name);
				
				VipDashboardScene vipDashboardScene = new VipDashboardScene(primaryStage, name);
				primaryStage.setTitle(vipDashboardScene.getTitle());
				primaryStage.setScene(vipDashboardScene.getScene());
				
				primaryStage.show();
				
			}
			}));
			
			timeline.play();
		}
		
		else {
			outputLabel.setText(result);
		}
				
	}

	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		FirstPageScene firstPageScene = new FirstPageScene(primaryStage);
		primaryStage.setTitle(firstPageScene.getTitle());
		primaryStage.setScene(firstPageScene.getScene());
		
		primaryStage.show();
	
	}
		
}
