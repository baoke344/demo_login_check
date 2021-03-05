package com.example.demo_login_check;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserData userData;

    public void init() {
        userData = new UserData();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        //Response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.jsp").include(request,response);

        //Get username and password
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("password");

        UserClass user = new UserClass();
        user.setUserName(userName) ;
        user.setUserPassword(userPassword);

//        Cookie ck_register = new Cookie("rename", userName);
//        response.addCookie(ck_register);

        try{
            userData.connect(user);
        } catch(Exception e){
            e.printStackTrace();
        }
        out.print("You have registered successfully");
        request.getRequestDispatcher("index.jsp").forward(request,response);


        out.close();
    }

    public void destroy() {
    }
}