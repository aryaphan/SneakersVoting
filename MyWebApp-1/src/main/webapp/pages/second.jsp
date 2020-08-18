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
<%@page import="java.io.*" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Redirected Page..


<div align="center">
<table>
	<tr>
<%-- 		<td width="400"><%=sneaker1.getId() %></td> --%>
<%-- 		<td><%=sneaker2.getId() %></td> --%>
		<th>Id</th>
		<th>Name</th>
		<th>Score</th>
		<th>Photo</th>
	</tr>
	
	<c:forEach var="sneaker" items="${sneakerList}">
	<tr>
<%-- 		<td><%=sneaker1.getName() %></td> --%>
<%-- 		<td><%=sneaker2.getName() %></td> --%>
		
		<td>${sneaker.id}</td>
		<td>${sneaker.name}</td>
		<td>${sneaker.score}</td>
		<td><img width="500" height="600" src="getSneakerImage/<c:out value='${sneaker.id}'/>"></td>
	</tr>
	</c:forEach>
	
</table>

<%-- 	<h2><%=resultSet.getString("name") %></h2>  --%>
<%-- 	<h2><c:out value="${sneaker.name}" /></h2> --%>
<%-- 		<h2 th:text="${sneaker}"></h2> --%>
<%-- 	<img src="data:image/jpg;base64,${sneaker.base64Image}" width="1000", height="900"/> --%>
</div>



</body>
</html>