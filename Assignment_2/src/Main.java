
import View.AddPostScene;
import View.DashboardScene;
import View.EditProfileScene;
import View.ExportPostScene;
import View.FirstPageScene;
import View.LogInScene;
import View.RemovePostScene;
import View.RetriveLikesScene;
import View.RetrivePostScene;
import View.SignUpScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		AddPostScene addPostScene = new AddPostScene();
		primaryStage.setTitle(addPostScene.getTitle());
		primaryStage.setScene(addPostScene.getScene());
		
		
		DashboardScene dashboardScene = new DashboardScene();
		primaryStage.setTitle(dashboardScene.getTitle());
		primaryStage.setScene(dashboardScene.getScene());
		
		EditProfileScene editProfileScene = new EditProfileScene();
		primaryStage.setTitle(editProfileScene.getTitle());
		primaryStage.setScene(editProfileScene.getScene());
		
		ExportPostScene exportPostScene = new ExportPostScene();
		primaryStage.setTitle(exportPostScene.getTitle());
		primaryStage.setScene(exportPostScene.getScene());
		
		FirstPageScene firstPageScene = new FirstPageScene();
		primaryStage.setTitle(firstPageScene.getTitle());
		primaryStage.setScene(firstPageScene.getScene());
		
		LogInScene logInScene = new LogInScene();
		primaryStage.setTitle(logInScene.getTitle());
		primaryStage.setScene(logInScene.getScene());
		
		RemovePostScene removePostScene = new RemovePostScene();
		primaryStage.setTitle(removePostScene.getTitle());
		primaryStage.setScene(removePostScene.getScene());
		
		RetriveLikesScene retriveLikesScene = new RetriveLikesScene();
		primaryStage.setTitle(retriveLikesScene.getTitle());
		primaryStage.setScene(retriveLikesScene.getScene());
		
		RetrivePostScene retrivePostScene = new RetrivePostScene();
		primaryStage.setTitle(retrivePostScene.getTitle());
		primaryStage.setScene(retrivePostScene.getScene());
		
		SignUpScene SignUpScene = new SignUpScene();
		primaryStage.setTitle(SignUpScene.getTitle());
		primaryStage.setScene(SignUpScene.getScene());
		
		
		
		primaryStage.setWidth(420);
		primaryStage.setHeight(420);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

}