package com.beike.manager;

import com.beike.dao.User;
import com.beike.dao.UserDAO;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by huahui.yang on 3/22/15.
 */
public class UserManager {
    private static final Logger LOGGER = Logger.getLogger(UserManager.class);

    private static UserDAO userDAO = new UserDAO();

    public Integer addUser(User user) {
        userDAO.save(user);
        return user.getId();
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public List<User> getUserByUsernameAndPassword(String username, String password) {
        return userDAO.findByProperty2("username", username, "password", password);
    }
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
//        System.out.println(userManager.addUser(new User("hello","password")));
        for(User user:userManager.getAllUsers()){
            System.out.println("name="+user.getUsername()+",password="+user.getUsername());
        }
    }

    public boolean existUser(String username) {
        List<User> users = userDAO.findByProperty("username", username);
        if(users == null || users.size() == 0) {
            return false;
        }
        return true;
    }
}
