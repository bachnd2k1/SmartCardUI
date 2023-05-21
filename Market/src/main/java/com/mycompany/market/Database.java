/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.market;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZZ
 */
public class Database {
    Connection conn;
    public Connection cnSQL(String dbURL, String userName, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Kết nối thành công!");
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return conn;
    }
    public ResultSet HienThongTin(String tvSQL){
        try {
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(tvSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return null;
    }
    public void ChinhSuaThongTin(String tvSQL){
       
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(tvSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public String LayMa(String tvSQL){
        String value = null;
       try {
            Statement stmt = conn.createStatement();           
            ResultSet rslm = stmt.executeQuery(tvSQL);
            while (rslm.next())
                value = rslm.toString();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return value;
        
    }
}
