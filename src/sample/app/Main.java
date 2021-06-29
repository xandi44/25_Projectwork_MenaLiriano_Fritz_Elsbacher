package sample.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import sample.ControllerCity;

import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../sample.fxml"));
        primaryStage.setTitle("Projectwork");
        InputStream iconStream = Main.class.getResourceAsStream("/icon.jpg");
        if(iconStream != null){
            primaryStage.getIcons().add(new Image(iconStream));
        }

        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
