package com.example.schoolmanagementsystem.auth;


import com.sun.net.httpserver.HttpExchange;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/province", "/state", "/local-level"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpSession httpSession = ((HttpServletRequest)request).getSession(false);

       if(httpSession != null && httpSession.getAttribute("isLoggedIn") != null &&  (Boolean)httpSession.getAttribute("isLoggedIn")) {

           chain.doFilter(request, response);

       }else{
           ((HttpServletResponse)response).sendRedirect("/login");
       }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
