package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Due�oDto;

public class Due�oDao {

	public Due�oDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Due�oDto> validate() {        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Due�oDto> due�os = new ArrayList<Due�oDto>(); // Creating a user object to fill with user data (I imagine that you have a user class in your model)


        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "clinica";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn.prepareStatement("select * from due�o");

            rs = pst.executeQuery();
            while(rs.next()){
            	Due�oDto due�o = new Due�oDto();
            	Integer rut =rs.getInt("rut");
                String name = rs.getString("nombre");
                String lname = rs.getString("apellido");
                String addrs = rs.getString("direccion");
                String email = rs.getString("correo");
                Integer phone = rs.getInt("telefono");
                String nPet = rs.getString("nombreMascota");
                due�o.setRut(rut);
                due�o.setNombre(name);
                due�o.setApellido(lname);
                due�o.setDireccion(addrs);
                due�o.setCorreo(email);
                due�o.setTelefono(phone);
                due�o.setNombreMascota(nPet);
                
                due�os.add(due�o);
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
        return due�os;
    }

}
