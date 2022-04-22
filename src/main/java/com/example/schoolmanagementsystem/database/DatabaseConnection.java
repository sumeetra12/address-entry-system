package com.example.schoolmanagementsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
public Connection con;
    public void connect(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sis";
            con = DriverManager.getConnection(url, "root", "");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
