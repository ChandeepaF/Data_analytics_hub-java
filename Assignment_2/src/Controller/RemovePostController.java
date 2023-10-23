package Controller;

import Model.TestModel;
import View.DashboardScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RemovePostController {
	
	String name = null;
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	private TextField idTextField;
	
	@FXML
	private Label outputLabel;
	
	
	
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().deleteExistingPost(idTextField.getText());
		
		outputLabel.setText(result);
	}
	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		DashboardScene dashboardScene = new DashboardScene(primaryStage, name);
		primaryStage.setTitle(dashboardScene.getTitle());
		primaryStage.setScene(dashboardScene.getScene());

		primaryStage.show();
	}
	
}
