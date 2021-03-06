package sample.dal;



import javafx.scene.image.Image;
import sample.bll.City;
import sample.bll.Country;
import sample.bll.Picture;
import sample.utie.PropertyManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseManager {
    private Connection connection;
    private String driver;
    private String url;
    private String username;
    private String password;
    private static DatabaseManager instance;
    private HashMap<Integer, Country> countries = null;
    private HashMap<Integer, City> cities = null;

    private DatabaseManager(){
        PropertyManager.getInstance().setFileName("db.properties");
        this.driver = PropertyManager.getInstance().readProperty("driver","oracle.jdbc.OracleDriver");
        this.url = PropertyManager.getInstance().readProperty("url","jdbc:oracle:thin:@tcif.htl-villach.at:1521/orcl");
        this.username = PropertyManager.getInstance().readProperty("username","d3a27");
        this.password = PropertyManager.getInstance().readProperty("password","d3a27");
    }

    private Connection createConnection(){
        Connection con = null;
        //Laden des Treibers
        try {
            Class.forName(this.driver);
            con = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static DatabaseManager getInstance(){
        if(instance == null){
            instance = new DatabaseManager();
        }
        return instance;
    }


    public HashMap<Integer,Country> getAllCountries() {
        Statement stmt;
        ResultSet resultSet;
        this.countries = new HashMap<>();

        String query = "SELECT * FROM country";

        try(Connection con = this.createConnection()){
            //Statement wird erzeugt
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(query);
            // resultset wird durchiteriert
            while(resultSet.next()){
                countries.put(resultSet.getInt(1),new Country(resultSet.getInt(1),resultSet.getString(2)));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return countries;
    }

    public HashMap<Integer,City> getAllCities() {
        Statement stmt;
        ResultSet resultSet;
        this.cities = new HashMap<>();

        String query = "SELECT * FROM city";

        try(Connection con = this.createConnection()){
            //Statement wird erzeugt
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(query);
            // resultset wird durchiteriert
            while(resultSet.next()){
                cities.put(resultSet.getInt(1),new City(resultSet.getInt(1),resultSet.getString(2),getCountries().get(resultSet.getInt(3)),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6),resultSet.getString(7)));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return cities;
    }

    public HashMap<Integer,Picture> getPictures(City city) {
        HashMap<Integer,Picture> pictures = new HashMap<>();

        ResultSet resultSet;
        PreparedStatement preparedStatement;

        String query = "SELECT * FROM picture WHERE idCity = ?";

        try(Connection con = this.createConnection()){
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,city.getId());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                InputStream in = resultSet.getBlob(3).getBinaryStream();
                Image image =  new Image(in);
                pictures.put(resultSet.getInt(1),new Picture(resultSet.getInt(1),getAllCities().get(resultSet.getInt(2)),image));
            }
        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return pictures;
    }


    public HashMap<Integer, City> getCities() {
        if(cities == null){
            this.getAllCities();
        }
        return cities;
    }
    public HashMap<Integer, Country> getCountries() {
        if(countries == null){
            this.getAllCountries();
        }
        return countries;
    }

}
