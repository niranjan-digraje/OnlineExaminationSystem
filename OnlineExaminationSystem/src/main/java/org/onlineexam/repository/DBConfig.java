package org.onlineexam.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConfig {
    protected Connection conn;
    protected PreparedStatement stmt;
    protected ResultSet rs;

    public DBConfig() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam_system", "root", "root");
            System.out.println("Database Conected...");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error is DBConfig : " + e);
        }
    }

}
