package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.MascotaDto;

public class MascotaDao {

	public MascotaDao() {
		// TODO Auto-generated constructor stub
	}
	public static List<MascotaDto> validate() {        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<MascotaDto> mascotas = new ArrayList<MascotaDto>(); // Creating a user object to fill with user data (I imagine that you have a user class in your model)


        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "clinica";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn.prepareStatement("select * from mascota2");

            rs = pst.executeQuery();
            while(rs.next()){
            	MascotaDto masc= new MascotaDto();
            	Integer idMasc =rs.getInt("idMascota");
            	Integer rutDño = rs.getInt("rutDueño");
                String tMasc = rs.getString("tipoMascota");
                Integer edad = rs.getInt("edad");
                String nomMasc = rs.getString("nombreMascota");
                masc.setIdMascota(idMasc);
                masc.setRutDueño(rutDño);
                masc.setTipoMascota(tMasc);
                masc.setEdad(edad);
                masc.setNombreMascota(nomMasc);
                
                mascotas.add(masc);
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
        return mascotas;
    }
}
