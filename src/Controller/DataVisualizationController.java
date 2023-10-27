package Controller;

import java.io.FileInputStream;

import Model.HubModel;
import View.DashboardScene;
import View.VipDashboardScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DataVisualizationController {

	// Initializing the name to be passed on 
	String name = null;
	
	// Defining the primary stage
	private Stage primaryStage;
	
	// PieChart is imported to generate the pie chart within JavaFx
	@FXML
	private PieChart pieChart;
	
	
	// To set the primary stage
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	// The setName is defined to pass the name of the user to this controller
	public void setName(String name) {
		this.name = name;
	}

	
	// The button to 
	@FXML
	public void generatechartButtonHandler(ActionEvent event) {
		
		ObservableList<Data> pieChartData = HubModel.getInstance().dataVisualization();
		
		pieChart.setData(pieChartData);
		pieChart.setTitle("Distribution of Shares");
		
		pieChart.setLabelLineLength(10);	
		
	}
	
	
	@FXML
	public void previousButtonHandler(ActionEvent event) {
		
		VipDashboardScene vipDashboardScene = new VipDashboardScene(primaryStage, name);
		primaryStage.setTitle(vipDashboardScene.getTitle());
		primaryStage.setScene(vipDashboardScene.getScene());

		primaryStage.show();
	}
}
