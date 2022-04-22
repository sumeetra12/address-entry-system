package com.example.schoolmanagementsystem.dao;

import com.example.schoolmanagementsystem.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    DatabaseConnection db = new DatabaseConnection();
    public Boolean validate(String username, String password) throws SQLException {
        Boolean status = false;
        this.db.connect();
        String sql = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        status = rs.next();
        return status;
    }

}
