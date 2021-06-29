package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.bll.City;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
// ControllerWebside WRITTEN BY CHRISTOPH FRITZ
public class ControllerWebside {

    private City cityVi;

    @FXML
    private Button closeButton;

    @FXML
    private WebView idWebview;



  // Funktionaltiät für den Webviewer:
    public void setCity(String currenturl) {
        String weburl = currenturl;
        // replace weil url nur bei http geht also https wird durch http getauscht
        // (aber besser wär wahrscheinlich glei datenbank ändern)

        weburl = weburl.replace("https","http");

        WebEngine webEngine = idWebview.getEngine();
        System.out.println(weburl);
        webEngine.load(weburl);

    }
    // Funktionalität für den ZureckButton:
    public void onclickWVback(ActionEvent actionEvent)  {

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
