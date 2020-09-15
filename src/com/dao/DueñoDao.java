package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.DueñoDto;

public class DueñoDao {

	public DueñoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<DueñoDto> validate() {        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<DueñoDto> dueños = new ArrayList<DueñoDto>(); // Creating a user object to fill with user data (I imagine that you have a user class in your model)


        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "clinica";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn.prepareStatement("select * from dueño");

            rs = pst.executeQuery();
            while(rs.next()){
            	DueñoDto dueño = new DueñoDto();
            	Integer rut =rs.getInt("rut");
                String name = rs.getString("nombre");
                String lname = rs.getString("apellido");
                String addrs = rs.getString("direccion");
                String email = rs.getString("correo");
                Integer phone = rs.getInt("telefono");
                String nPet = rs.getString("nombreMascota");
                dueño.setRut(rut);
                dueño.setNombre(name);
                dueño.setApellido(lname);
                dueño.setDireccion(addrs);
                dueño.setCorreo(email);
                dueño.setTelefono(phone);
                dueño.setNombreMascota(nPet);
                
                dueños.add(dueño);
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
        return dueños;
    }

}
