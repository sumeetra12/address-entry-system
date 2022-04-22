package com.example.schoolmanagementsystem.servlet;

import com.example.schoolmanagementsystem.dao.ProvinceDao;
import com.example.schoolmanagementsystem.dao.StateDao;
import com.example.schoolmanagementsystem.entity.Province;
import com.example.schoolmanagementsystem.entity.State;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StateServlet", urlPatterns = {"/state"})
public class StateServlet extends HttpServlet {

    private StateDao stateDao = new StateDao();

    private ProvinceDao provinceDao = new ProvinceDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String path = "WEB-INF/pages/address/state/state.jsp";

        if(action == null){
            path = "WEB-INF/pages/address/state/state.jsp";
           String search = request.getParameter("search");
            //System.out.println(search);
            try{
                List<State> stateList;
                if(search == null || search.isEmpty()){
                   stateList = stateDao.getAll();
                }else{
                    stateList = stateDao.searchByName(search);
                }
                request.setAttribute("state", stateList);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(action.equals("add")){
            path = "WEB-INF/pages/address/state/add_state.jsp";
            try{
                List<Province> allProvince = provinceDao.getAll();
                request.setAttribute("province", allProvince);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(action.equals("edit")){
            path = "WEB-INF/pages/address/state/edit_state.jsp";
            int id = Integer.parseInt(request.getParameter("id"));

            try{
                List<Province> provinceList = provinceDao.getAll();
                request.setAttribute("province", provinceList);
                State oneState = stateDao.getOne(id);
                request.setAttribute("state", oneState);

            }catch(Exception e){
                e.printStackTrace();
            }


        }else if(action.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));

            try{
                stateDao.deleteState(id);
            }catch(Exception e){
                e.printStackTrace();
            }
            response.sendRedirect("/state");
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
            int stateId = Integer.parseInt(request.getParameter("province"));
            try{
                stateDao.addState(name, stateId);
            }catch (Exception e){
                e.printStackTrace();
            }


        }else if(operation.equals("Update")){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int provinceId = Integer.parseInt(request.getParameter("changeProvince"));
            try{
                stateDao.updateState(id, name, provinceId);

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    response.sendRedirect("/state");
    }
}
	