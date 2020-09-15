package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.UsuarioDto;

public class UsuarioDao {

	public static UsuarioDto validate(String user, String pass) {        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        UsuarioDto usr = new UsuarioDto(); // Creating a user object to fill with user data (I imagine that you have a user class in your model)


        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "clinica";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn.prepareStatement("select * from usuario where nombreUsuario=? and password=?");
            
            pst.setString(1, user);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            while(rs.next()){
                int id =rs.getInt("id");
                String name = rs.getString("nombreUsuario");
                String pwrd = rs.getString("password");
                usr.setId(id);
                usr.setNombreUsuario(name);
                usr.setPassword(pwrd);
                //Add the retrived user to the list
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return usr;
    }
}
