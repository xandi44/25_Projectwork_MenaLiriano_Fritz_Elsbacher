package sample.bll;

import sample.dal.DatabaseManager;

import java.util.HashMap;
import java.util.HashSet;

public class Country {
    int id;
    String name;

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static HashSet<Country> getCountries(){
        return new HashSet<>(DatabaseManager.getInstance().getCountries().values());
    }
}
