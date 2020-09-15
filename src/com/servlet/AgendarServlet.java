package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class AgendarServlet
 */
@WebServlet("/AgendarServlet")
public class AgendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
		try {
			java.util.Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha")); 
			java.util.Date selectedTime = new SimpleDateFormat("hh:mm").parse(request.getParameter("hora")); 

			java.sql.Date selectedSQLDate =  new java.sql.Date(selectedDate.getTime());
			java.sql.Time selectedSQLTime =  new java.sql.Time(selectedTime.getTime());
			Connection  con = ConexionBaseDatos.initializeDatabase();
			PreparedStatement st = con.prepareStatement("INSERT INTO `agenda` (`idMascota`, `rutDueño`, `nombreMascota`, `hora`, `fecha`) VALUES (?, ?, ?, ?, ?)");
			System.out.println("RUT DUENIO: "+request.getParameter("duenio"));
			//PreparedStatement st = con.prepareStatement("insert into agenda values(?, ?, ?, ?, ?)");
			st.setInt(1, Integer.valueOf(request.getParameter("mascota")));
			st.setInt(2, Integer.valueOf(request.getParameter("duenio")));
			st.setString(3, "Nombre Mascota"); 
			st.setTime(4, selectedSQLTime);
			st.setDate(5, selectedSQLDate);
			st.executeUpdate(); 
            st.close(); 
            con.close(); 
            out.print("<p style=\"color:red\">Datos insertados con exito</p>");
            RequestDispatcher rd=request.getRequestDispatcher("inserted.jsp"); 
		} catch(Exception e) {
			e.printStackTrace();
			out.print("<p style=\"color:red\">Error en la insercion</p>");
			RequestDispatcher rd=request.getRequestDispatcher("inserted.jsp"); 
		}
	}

}
