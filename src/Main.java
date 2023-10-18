import Scene.AreaCalculatorScene;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AreaCalculatorScene areaCalculatorScene = new AreaCalculatorScene();
		
		primaryStage.setTitle(areaCalculatorScene.getTitle());
		
		primaryStage.setScene(areaCalculatorScene.getScene());
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

}