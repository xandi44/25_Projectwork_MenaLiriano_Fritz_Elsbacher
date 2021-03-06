package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.app.Main;
import sample.bll.City;
import sample.bll.Country;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;

public class Controller implements Initializable {

    @FXML
    private ListView lvCountry;
    @FXML
    private ListView lvCity;

    HashSet<City> cities = new HashSet();
    HashSet<Country> countries = new HashSet();

    City currentCity = null;
    Country currentCountry = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countries = Country.getCountries();
        ObservableList<Country> countryList;
        countryList = FXCollections.observableList(new ArrayList<>(countries));
        this.lvCountry.setItems(countryList);

        cities = City.getCities();

        this.lvCountry.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldObject, Object newObject) {
                currentCountry = (Country) newObject;
                currentCity = null;
                showCities();
            }
        });

        this.lvCity.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldObject, Object newObject) {
                currentCity = (City) newObject;
            }
        });

    }

    private void showCities() {
        ArrayList<City> currentcities = new ArrayList<>();
        for(City c : cities){
            if(currentCountry.getId() == c.getCountry().getId()){
                currentcities.add(c);
            }
        }
        ObservableList<City> showncities = FXCollections.observableList(currentcities);
        this.lvCity.setItems(showncities);
    }

    @FXML
    private void OnClickPictures(ActionEvent actionEvent) {
        if(currentCity != null){
            try {
                FXMLLoader loader = null;
                ControllerCity controller = null;
                BorderPane root = null;
                loader = new FXMLLoader( getClass().getResource("sampleCity.fxml"));

                Stage stage = null;
                Scene scene = null;
                root = loader.load();
                controller = loader.getController();
                controller.setCity(currentCity);
                controller.setCountry(currentCountry);
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


}
