package com.example.schoolmanagementsystem.dao;

import com.example.schoolmanagementsystem.database.DatabaseConnection;
import com.example.schoolmanagementsystem.entity.LocalLevel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalLevelDao {
    DatabaseConnection db = new DatabaseConnection();

    private StateDao stateDao = new StateDao();

    public List<LocalLevel> getAll() throws SQLException {
        List<LocalLevel> localLevelList = new ArrayList<>();
        this.db.connect();
        String sql = "SELECT * FROM LOCAL_LEVEL";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            LocalLevel localLevel = new LocalLevel();
            localLevel.setId(rs.getInt("id"));
            localLevel.setName(rs.getString("name"));
            localLevel.setState(stateDao.getOne(rs.getInt("stateId")));
            localLevelList.add(localLevel);
        }
        this.db.con.close();
        return localLevelList;
    }

    public LocalLevel getOne(int id) throws SQLException {
        LocalLevel localLevel = new LocalLevel();
        this.db.connect();
        String sql = "SELECT * FROM LOCAL_LEVEL WHERE ID=?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            localLevel.setId(rs.getInt("id"));
            localLevel.setName(rs.getString("name"));
            localLevel.setState(stateDao.getOne(rs.getInt("stateId")));
        }
        this.db.con.close();
        return localLevel;
    }

    public void addLocalLevel(String name, int stateId) throws SQLException {
        this.db.connect();
        String sql = "INSERT INTO LOCAL_LEVEL(NAME, STATEID) VALUES(?,?)";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setInt(2, stateId);
        stmt.executeUpdate();
        this.db.con.close();
    }

    public void updateLocalLevel(int id, String name, int stateId) throws SQLException {
        this.db.connect();
        String sql = "UPDATE LOCAL_LEVEL SET NAME=?, STATEID=? WHERE ID=?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setInt(2, stateId);
        stmt.setInt(3, id);
        stmt.executeUpdate();
        this.db.con.close();
    }

    public void deleteLocalLevel(int id) throws SQLException {
        this.db.connect();
        String sql = "DELETE FROM LOCAL_LEVEL WHERE ID = ?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        this.db.con.close();
    }

    public List<LocalLevel> searchByName(String search) throws SQLException {
        this.db.connect();
        List<LocalLevel> localLevelByName = new ArrayList<>();
        String sql = "SELECT * FROM LOCAL_LEVEL WHERE NAME LIKE ?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setString(1, "%"+search+"%");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            LocalLevel localLevel = new LocalLevel();
            localLevel.setId(rs.getInt("id"));
            localLevel.setName(rs.getString("name"));
            localLevel.setState(stateDao.getOne(rs.getInt("stateId")));
            localLevelByName.add(localLevel);
        }

        return localLevelByName;
    }
}
