package sample.dal.dao;

import sample.bll.City;
import sample.bll.Picture;
import sample.dal.DatabaseManager;

import java.util.List;

public class PictureDBDao implements  Dao<Picture>{
    @Override
    public List<Picture> getAll() {
        return DatabaseManager.getInstance().getAllPictures();
    }
}
