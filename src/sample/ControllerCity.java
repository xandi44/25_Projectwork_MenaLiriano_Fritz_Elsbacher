package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.bll.City;
import sample.bll.Country;
import sample.bll.Picture;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerCity implements Initializable {

    City city = null;
    ArrayList<Picture> pictures = null;
    @FXML
    private Label lbPopulation;
    @FXML
    private Label lbSize;
    @FXML
    private Label lbSealevel;
    @FXML
    private Label lbCountryName;
    @FXML
    private Slider slider;
    @FXML
    private ImageView iwPic;

    public void setCity(City city) {
        this.city = city;
        pictures = new ArrayList<>(Picture.getPictures(city));
        iwPic.setImage(pictures.get(0).getImage());

        lbPopulation.setText(String.valueOf(city.getEinwohner()));
        lbSealevel.setText(String.valueOf(city.getSeehohe())+" m");
        lbSize.setText(String.valueOf(city.getFlaeche()) + " km^2");

        slider.setMax(pictures.size());
        slider.setMajorTickUnit(pictures.size()-2);
    }


    public void setCountry(Country country) {
        lbCountryName.setText(country.getName().replace(" ",""));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slider.setMin(1);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setMinorTickCount(0);

    }


    @FXML
    private void slchanged(MouseEvent mouseEvent) {
        Image image = pictures.get((int) (slider.getValue()-1)).getImage();
        iwPic.setImage(image);
    }

    @FXML
    private void OnClickWebsite(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = null;
            ControllerWebside controller = null;
            BorderPane root = null;
            loader = new FXMLLoader( getClass().getResource("sampleWebside.fxml"));

            Stage stage = null;
            Scene scene = null;
            root = loader.load();
            controller = loader.getController();
            controller.setCity(city.getWebseite());
            stage = new Stage();
            scene = new Scene(root);
            stage.setTitle("Projectwork");
            InputStream iconStream = getClass().getResourceAsStream("/icon.jpg");
            if(iconStream != null){
                stage.getIcons().add(new Image(iconStream));
            }
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
