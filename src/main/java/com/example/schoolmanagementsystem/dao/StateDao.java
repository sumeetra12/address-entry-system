package com.example.schoolmanagementsystem.dao;

import com.example.schoolmanagementsystem.database.DatabaseConnection;
import com.example.schoolmanagementsystem.entity.State;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDao {

    DatabaseConnection db = new DatabaseConnection();

    private ProvinceDao provinceDao = new ProvinceDao();

    public List<State> getAll() throws SQLException {
        List<State> stateList = new ArrayList<>();
        this.db.connect();
        String sql = "SELECT * FROM STATE";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            State state = new State();
            state.setId(rs.getInt("id"));
            state.setName(rs.getString("name"));
            state.setProvince(provinceDao.getOne(rs.getInt("provinceId")));
            stateList.add(state);
        }

        this.db.con.close();
        return stateList;

    }

    public State getOne(int id) throws SQLException {
        State state = new State();
        this.db.connect();
        String sql = "SELECT * FROM STATE WHERE ID = ?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            state.setId(rs.getInt("id"));
            state.setName(rs.getString("name"));
            state.setProvince(provinceDao.getOne(rs.getInt("provinceId")));        }

        this.db.con.close();
        return state;
    }

    public void addState(String name, int provinceId) throws SQLException {
        this.db.connect();
        String sql = "INSERT INTO STATE(NAME, PROVINCEID) VALUES(?,?)";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setInt(2, provinceId);
        stmt.executeUpdate();
        this.db.con.close();
    }

    public void updateState(int id, String name, int provinceId) throws SQLException {
        this.db.connect();
        String sql = "UPDATE STATE SET NAME = ? , PROVINCEID = ? WHERE ID=?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setInt(2, provinceId);
        stmt.setInt(3, id);
        stmt.executeUpdate();
        this.db.con.close();
    }

    public void deleteState(int id) throws SQLException {
        this.db.connect();
        String sql1 = "DELETE FROM LOCAL_LEVEL WHERE STATEID = ?";
        PreparedStatement pstmt = db.con.prepareStatement(sql1);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();

        String sql = "DELETE FROM STATE WHERE ID = ?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        this.db.con.close();
    }

    public List<State> searchByName(String search) throws SQLException {
        List<State> stateListByName = new ArrayList<>();
        this.db.connect();
        String sql = "SELECT * FROM STATE WHERE NAME LIKE ?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setString(1, "%" + search + "%");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            State state = new State();
            state.setId(rs.getInt("id"));
            state.setName(rs.getString("name"));
            state.setProvince(provinceDao.getOne(rs.getInt("provinceId")));
            stateListByName.add(state);

        }
        return stateListByName;
    }


}
