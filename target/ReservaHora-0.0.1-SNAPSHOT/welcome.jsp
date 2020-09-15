<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agendar Horas</title>
</head>
	<body>
		<form action="AgendarServlet" method="post">
	        <fieldset style="width: 300px">
	            <legend> Login to App </legend>
			    <h3>Agendar Hora</h3>
			    <h4>Bienvenid@ <%=session.getAttribute("name")%></h4>
			    <table>
		            <tr>
		                <td>Dueño</td>
		                <td><select name="duenio">
					            <c:forEach items="${dueños}" var="dño">
					                <option value="${dño.rut}">
					                    ${dño.nombre} ${dño.apellido}
					                </option>
					            </c:forEach>
					        </select>
				        </td>
		            </tr>
		            <tr>
		                <td>Mascota</td>
		                <td>
		                	<select name="mascota">
					            <c:forEach items="${mascotas}" var="mscta">
					                <option value="${mscta.idMascota}">
					                    ${mscta.nombreMascota}
					                </option>
					            </c:forEach>
					        </select>
		                </td>
		            </tr>
		            <tr>
		                <td>Fecha</td>
		                <td><input type="date" id="start" name="fecha" value="today()" min="today()" required="required"></td>
		            </tr>
		            <tr>
		                <td>Hora</td>
		                <td><input type="time" id="appt" name="hora" min="09:00" max="18:00" required="required"></td>
		            </tr>
		            <tr>
		                <td><input type="submit" value="Login" /></td>
		            </tr>
		        </table>
	        </fieldset>
    	</form>
	</body>
</html>