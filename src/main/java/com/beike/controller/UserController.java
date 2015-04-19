package com.beike.controller;

/**
 * Created by huahui.yang on 3/21/15.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beike.dao.User;
import com.beike.manager.UserManager;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);
    private static UserManager userManager = new UserManager();

    @RequestMapping(value = "/add")
    public void methodUserAdd(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password) {
        String jsonResult = "";
        logger.info("username:" + username + "password:" + password);
        boolean existUser = userManager.existUser(username);
        if (existUser) {
            jsonResult = "{result:false, message:username exists}";
        } else {
            userManager.addUser(new User(username, password));
            jsonResult = "{result:true, message:add user success}";
        }

        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(jsonResult);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/list")
    public void methodUserList(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password) {

        String jsonResult = "";
        List<User> users = userManager.getAllUsers();
        for (User at : users) {
            jsonResult += ("{" + at.getUsername() + ":" + at.getPassword() + "}");
        }
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(jsonResult);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }

    @RequestMapping(value = "/login")
    public void methodUserLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password) {
        String jsonResult = "";
        logger.info("login request: username=" + username + "password=" + password);
        HttpSession session = request.getSession();

        List<User> users = userManager.getUserByUsernameAndPassword(username, password);
        if (users != null && users.size() > 0) {
            jsonResult = "{result:true, message:login success}";
            session.setAttribute("username", username);
            request.getSession().getAttribute("username");
            logger.info("user info:" + users.get(0));
            logger.info("username in session:" + session.getAttribute("username"));
        } else {
            jsonResult = "{result:false, message:login failed}";
        }

        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(jsonResult);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }

    @RequestMapping(value = "/info")
    public void methodUserInfo(
            HttpServletRequest request,
            HttpServletResponse response) {
        String jsonResult = "";
        HttpSession session = request.getSession();
        String username = (String) request.getSession().getAttribute("username");
        if (username == null || "".equals(username)) {
            jsonResult = "{result:false, message:please login}";
        } else {
            User user = userManager.getUserByUsername(username);
            if (user != null) {
                jsonResult = "{result:true, userid:" + user.getId() + ", username:" + username +
                        ", email:" + user.getEmail() + ", message:user in session}";
            } else {
                jsonResult = "{result:false, message:please login}";
            }
        }

        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(jsonResult);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }

    @RequestMapping(value = "/logout")
    public void methodUserLogout(
            HttpServletRequest request,
            HttpServletResponse response) {
        String jsonResult = "";
        HttpSession session = request.getSession();
        request.getSession().removeAttribute("username");
        jsonResult = "{result:true, message:user logout}";

        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(jsonResult);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }
}