<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.concurrent.ThreadLocalRandom" %>
<%@page import="com.arya.model.Sneaker" %>
<%@page import="com.arya.dao.SneakerDAO" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Redirected Page

<%
SneakerDAO dao = new SneakerDAO();
List<Sneaker> sneakerList = dao.getAllSneakers();
Integer num1 = ThreadLocalRandom.current().nextInt(0, sneakerList.size());
Integer num2 = ThreadLocalRandom.current().nextInt(0, sneakerList.size());

while (num1 == num2){
	num2 = ThreadLocalRandom.current().nextInt(0, sneakerList.size());
}

Sneaker sneaker1 = sneakerList.get(num1);
Sneaker sneaker2 = sneakerList.get(num2);

%>

<%
//for (Sneaker sneaker : sneakerList){
	
%>

<div align="center">
<table>
	<tr>
		<td><%=sneaker1.getId() %></td>
		<td><%=sneaker2.getId() %></td>
	</tr>
	
	<tr>
		<td><%=sneaker1.getName() %></td>
		<td><%=sneaker2.getName() %></td>
	</tr>
</table>

<%-- 	<h2><%=resultSet.getString("name") %></h2>  --%>
<%-- 	<h2><c:out value="${sneaker.name}" /></h2> --%>
<%-- 		<h2 th:text="${sneaker}"></h2> --%>
<%-- 	<img src="data:image/jpg;base64,${sneaker.base64Image}" width="1000", height="900"/> --%>
</div>



</body>
</html>