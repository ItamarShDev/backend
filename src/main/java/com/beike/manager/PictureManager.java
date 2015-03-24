package com.beike.manager;

import com.beike.dao.Picture;
import com.beike.dao.PictureDAO;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by CJL on 2015/3/24.
 */
public class PictureManager {

    private static final Logger LOGGER = Logger.getLogger(PictureManager.class);

    private static PictureDAO pictureDAO = new PictureDAO();

    public Integer addPicture(Picture picture) {
        pictureDAO.save(picture);
        return picture.getId();
    }

    public List<Picture> getAllPictures() {
        return pictureDAO.findAll();
    }

    public static void main(String[] args) {
        PictureManager pictureManager = new PictureManager();
//        System.out.println(userManager.addUser(new User("hello","password")));
        for(Picture picture:pictureManager.getAllPictures()){
            System.out.println("name="+picture.getName()+",originalurl="+picture.getOriginalurl()+",cdnurl="+picture.getCdnurl());
        }
    }
}
