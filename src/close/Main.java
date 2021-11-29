package close;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception{
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setAlignment(Pos.BOTTOM_RIGHT);
		
		Button btn = new Button("Á¾·á");
		btn.setPrefWidth(80);
		btn.setOnAction(event->Platform.exit());
		root.getChildren().add(btn);
		
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Hello");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
		
	}
}
//	@Override
//	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
//	}
//	@Override
//	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
//	}

//}


