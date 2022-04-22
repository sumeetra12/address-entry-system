package com.example.schoolmanagementsystem.servlet;

import com.example.schoolmanagementsystem.dao.LoginDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private LoginDao loginDao = new LoginDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "WEB-INF/pages/login/login.jsp";
        HttpSession httpSession = request.getSession();
        if (httpSession != null
                && httpSession.getAttribute("isLoggedIn") != null
                && (Boolean) httpSession.getAttribute("isLoggedIn")) {
            response.sendRedirect("/");
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            String error = "Invalid username password";
            Boolean status = loginDao.validate(username, password);
            if(status){

                HttpSession httpSession = request.getSession();

                httpSession.setAttribute("isLoggedIn", true);


                response.sendRedirect("/");

            }else{
                response.sendRedirect("/login?error=" + error);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


    }
}
