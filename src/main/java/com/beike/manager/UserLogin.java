package com.beike.manager;

import com.beike.dao.User;
import com.beike.manager.UserManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by CJL on 2015/3/24.
 */
public class UserLogin extends HttpServlet{

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        PrintWriter out=response.getWriter();

        UserManager userManager = new UserManager();
        List<User> list = userManager.getAllUsers();

        for(User user:list)
        {
            if(user.getUsername().equals(userName)&&user.getPassword().equals(password))
            {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/Session/index.jsp");
                //response.addCookie();
                return ;
            }

        }
        out.write("用户名或者密码错误！");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
