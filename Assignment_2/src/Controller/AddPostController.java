package Controller;

import Model.TestModel;
import View.DashboardScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPostController {
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	@FXML
	private TextField idTextField;
	
	@FXML
	private TextField contentTextField;
	
	@FXML
	private TextField authorTextField;
	
	@FXML
	private TextField likesTextField;
	
	@FXML
	private TextField sharesTextField;
	
	@FXML
	private TextField datetimeTextField;
	
	@FXML
	private Label outputLabel;
	
	
	
	@FXML
	public void submitButtonHandler(ActionEvent event) {
		
		String result = TestModel.getInstance().addpostData(idTextField.getText(),
				contentTextField.getText(),authorTextField.getText(),likesTextField.getText(),
				sharesTextField.getText(),datetimeTextField.getText());
		
		outputLabel.setText(result);
	}
	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		DashboardScene dashboardScene = new DashboardScene(primaryStage);
		primaryStage.setTitle(dashboardScene.getTitle());
		primaryStage.setScene(dashboardScene.getScene());

		primaryStage.show();
		
	}
		
}
