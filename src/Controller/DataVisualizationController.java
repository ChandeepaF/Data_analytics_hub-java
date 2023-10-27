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

	String name = null;
	
	private Stage primaryStage;
	
	@FXML
	private ImageView imageView;
	
	@FXML
	private PieChart pieChart;
	
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	
	
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
