package com.example.schoolmanagementsystem.dao;

import com.example.schoolmanagementsystem.database.DatabaseConnection;
import com.example.schoolmanagementsystem.entity.Province;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDao {
    DatabaseConnection db = new DatabaseConnection();

    public List<Province> getAll() throws SQLException {
        List<Province> provinceList = new ArrayList<>();
        this.db.connect();
        String sql = "SELECT * FROM PROVINCE";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Province province = new Province();
            province.setId(rs.getInt("id"));
            province.setName(rs.getString("name"));

            provinceList.add(province);
        }

        this.db.con.close();
        return provinceList;
    }

    public void addProvince(String name) throws SQLException {
        this.db.connect();

        String sql = "INSERT INTO PROVINCE(NAME) VALUES(?)";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.executeUpdate();
        this.db.con.close();
    }

    public void deleteProvince(int id) throws SQLException {
        this.db.connect();

        String query1 = "DELETE FROM LOCAL_LEVEL WHERE STATEID  IN (SELECT ID FROM STATE WHERE PROVINCEID=?)";
        PreparedStatement pstmt1 = db.con.prepareStatement(query1);
        pstmt1.setInt(1, id);
        pstmt1.executeUpdate();

        String query = "DELETE FROM STATE WHERE PROVINCEID =?";
        PreparedStatement pstmt = db.con.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();

        String sql = "DELETE FROM PROVINCE WHERE ID =?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        this.db.con.close();
    }

    public void updateProvince(int id, String name) throws SQLException {
        this.db.connect();
        String sql = "UPDATE PROVINCE SET NAME=? WHERE ID=?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setInt(2, id);
        stmt.executeUpdate();
        this.db.con.close();
    }

    public Province getOne(int id) throws SQLException {
        Province province = new Province();
        this.db.connect();
        String sql = "SELECT * FROM PROVINCE WHERE ID = ?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
            }
        this.db.con.close();
        return province;
    }

    public List<Province> getByKeyword(String search) throws SQLException {
        List<Province> provinceByName = new ArrayList<>();
        this.db.connect();
        String sql = "SELECT * FROM PROVINCE WHERE NAME LIKE ?";
        PreparedStatement stmt = db.con.prepareStatement(sql);
        stmt.setString(1, "%"+search+"%");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Province province = new Province();
            province.setId(rs.getInt("id"));
            province.setName(rs.getString("name"));
            provinceByName.add(province);
        }

        return provinceByName;
    }
}
