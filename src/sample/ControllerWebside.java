package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.bll.City;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerWebside {

    private City cityVi;

    @FXML
    private Button closeButton;
    private String urlofWeb;
    @FXML
    private WebView idWebview;


    public void setCity(City currentCity) {
        cityVi = currentCity;
        urlofWeb = cityVi.getWebseite();
        //idWebview.getEngine().load(urlofWeb);
    }

    public void onclickWVback(ActionEvent actionEvent)  {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }



}
