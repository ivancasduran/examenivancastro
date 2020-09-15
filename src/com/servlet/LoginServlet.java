package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.Due�oDto;
import com.dto.MascotaDto;
import com.dto.UsuarioDto;
import com.dao.Due�oDao;
import com.dao.MascotaDao;
import com.dao.UsuarioDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", n);
        
        if(!n.isEmpty() || !p.isEmpty()) {
        	
            UsuarioDto usuario = UsuarioDao.validate(n, p);

            
            if(usuario.getId() != null ){
            	List<Due�oDto> d�os = new ArrayList<Due�oDto>();
            	List<MascotaDto> mscts = new ArrayList<MascotaDto>();
            	
            	d�os.addAll(Due�oDao.validate());
            	mscts.addAll(MascotaDao.validate());
            	session.setAttribute("due�os", d�os);
            	session.setAttribute("mascotas", mscts);
            	
                RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
                rd.forward(request,response);  
            }  else{  
                out.print("<p style=\"color:red\">User o Pasword incorrectos</p>");  
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
                rd.include(request,response);  
                
            }  
        } else {
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.include(request,response);
        }
        

        out.close();  
	}

}
