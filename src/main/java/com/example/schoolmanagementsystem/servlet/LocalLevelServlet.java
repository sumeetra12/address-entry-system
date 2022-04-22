package com.example.schoolmanagementsystem.servlet;

import com.example.schoolmanagementsystem.dao.LocalLevelDao;
import com.example.schoolmanagementsystem.dao.ProvinceDao;
import com.example.schoolmanagementsystem.dao.StateDao;
import com.example.schoolmanagementsystem.entity.LocalLevel;
import com.example.schoolmanagementsystem.entity.Province;
import com.example.schoolmanagementsystem.entity.State;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LocalLevelServlet", urlPatterns = "/local-level")
public class LocalLevelServlet extends HttpServlet {

    private LocalLevelDao localLevelDao = new LocalLevelDao();

    private StateDao stateDao = new StateDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "WEB-INF/pages/address/local-level/local_level.jsp";

        String action = request.getParameter("action");

        if(action == null){
            path = "WEB-INF/pages/address/local-level/local_level.jsp";
            String search = request.getParameter("search");
            try{
                List<LocalLevel> localLevelList;
                if(search == null || search.isEmpty()){
                    localLevelList = localLevelDao.getAll();
                }else{
                    localLevelList = localLevelDao.searchByName(search);
                }

                request.setAttribute("local-level", localLevelList);
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(action.equals("add")){
            path = "WEB-INF/pages/address/local-level/add_local_level.jsp";

            try{
                List<State> stateList = stateDao.getAll();
                request.setAttribute("state", stateList);
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(action.equals("edit")){
            path = "WEB-INF/pages/address/local-level/edit_local_level.jsp";
            int id = Integer.parseInt(request.getParameter("id"));
            try{
                LocalLevel localLevel = localLevelDao.getOne(id);
                request.setAttribute("local-level", localLevel);

                List<State> stateList = stateDao.getAll();
                request.setAttribute("state", stateList);
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(action.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            try{
               localLevelDao.deleteLocalLevel(id);
            }catch(Exception e){
                e.printStackTrace();
            }

            response.sendRedirect("/local-level");
            return;
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String operation = request.getParameter("operation");

        if(operation.equals("Add")){
            String name = request.getParameter("name");

            int stateId = Integer.parseInt(request.getParameter("state"));
            try {
                localLevelDao.addLocalLevel(name, stateId);
            }catch(Exception e){
                e.printStackTrace();
            }


        }else if(operation.equals("Update")){
            String name = request.getParameter("name");
            int stateId = Integer.parseInt(request.getParameter("state"));
            int id = Integer.parseInt(request.getParameter("id"));

            try{
                localLevelDao.updateLocalLevel(id, name, stateId);

            }catch(Exception e){
                e.printStackTrace();
            }


        }

        response.sendRedirect("/local-level");

    }
}
