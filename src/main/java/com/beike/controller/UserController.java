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

import com.beike.dao.User;
import com.beike.manager.UserManager;
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
    @RequestMapping(value = "/list")
    public void methodUserList(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password) {

        String jsonResult = "";
        List<User> users = userManager.getAllUsers();
        for(User at:users) {
            jsonResult += ("{" + at.getUsername()+":"+at.getPassword()+"}");
        }

        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(jsonResult);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }
}