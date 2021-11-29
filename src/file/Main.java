package file;
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a pane to hold a button
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(10);
        pane.setVgap(10);

        // Create a button to choose a file
        Button btChooseFile = new Button("책 표지 등록하기");
        pane.add(btChooseFile, 25, 15);

        

        // Set the primary stage properties
        primaryStage.setScene(new Scene(pane, 400, 300));
        primaryStage.setTitle("도서정보");
        primaryStage.setResizable(false);
        primaryStage.show();

        //
        btChooseFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("책 표지 등록하기");
//                fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
//                fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*.*"));
                fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"), new ExtensionFilter("All Files", "*.*"));
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        });

       
    }
}