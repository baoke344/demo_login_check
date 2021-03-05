package com.example.demo_login_check;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GetUserData dataCheck;
    private boolean check;

    @Override
    public void init() throws ServletException {
        dataCheck = new GetUserData();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.jsp").include(request,response);

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("password");

        try{
            check = dataCheck.checkData(userName,userPassword);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(check == true){
            out.println("Hello "+ userName);
            out.println("You have logged in");
            Cookie ck = new Cookie("logname",userName);
            response.addCookie(ck);
        }
        else{
            out.print("Invalid user name or incorrect! ");
            request.getRequestDispatcher("Login.jsp").include(request,response);
        }
        out.close();
    }
}
