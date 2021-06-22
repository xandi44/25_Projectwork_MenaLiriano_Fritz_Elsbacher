package sample.bll;

import sample.dal.dao.Dao;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Picture {
    int id;
    City city;
    Image image;

    public Picture(int id, City city, Image image) {
        this.id = id;
        this.city = city;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static Set<Picture> getPersons(Dao<Picture> dao){
        return new HashSet<>(dao.getAll());
    }
}
