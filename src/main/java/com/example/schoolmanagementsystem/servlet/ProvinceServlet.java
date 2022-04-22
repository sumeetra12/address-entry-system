package com.example.schoolmanagementsystem.servlet;

import com.example.schoolmanagementsystem.dao.ProvinceDao;
import com.example.schoolmanagementsystem.entity.Province;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProvinceServlet", urlPatterns = "/province")
public class ProvinceServlet extends HttpServlet {

    private ProvinceDao provinceDao = new ProvinceDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = "WEB-INF/pages/address/province/province.jsp";
        String action = request.getParameter("action");

        if (action == null) {
            path = "WEB-INF/pages/address/province/province.jsp";
            String search = request.getParameter("search");
            try {
                List<Province> provinceList;
                if(search == null || search.isEmpty()) {
                    provinceList = provinceDao.getAll();
                }else {
                    provinceList = provinceDao.getByKeyword(search);
                }
                request.setAttribute("province", provinceList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equals("add")) {
            path = "WEB-INF/pages/address/province/add_province.jsp";

        } else if (action.equals("edit")) {
            path = "WEB-INF/pages/address/province/edit_province.jsp";
            int id =Integer.parseInt(request.getParameter("id"));

            try {
                Province oneProvince = provinceDao.getOne(id);
                request.setAttribute("province", oneProvince);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                provinceDao.deleteProvince(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/province");
            return;
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");

        if (operation.equals("Add")) {
        String name = request.getParameter("name");

            try {
                provinceDao.addProvince(name);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if(operation.equals("Update")){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("change-name");
            System.out.println(name);
            try {
                provinceDao.updateProvince(id, name);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        response.sendRedirect("/province");
    }
}