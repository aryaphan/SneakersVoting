<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.arya.model.Sneaker" %>
<%@page import="com.arya.rating.RatingHandler" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ranks</title>
</head>
<body>
<h1>Ranks</h1>

<%
	List<Sneaker> sneakerRanks = RatingHandler.getRanking();
	pageContext.setAttribute("sneakerRanks", sneakerRanks);
%>
<div align="center">
	<table>
		<tr>
			<th>Rank</th>
			<th>Name</th>
			<th>Score</th>
			<th>Photo</th>
		</tr>
		
		<c:set var="rank" value="1"/>
		<c:forEach items="${sneakerRanks}" var="sneaker">
			<tr>
				<td><c:out value="${rank}"/></td>
				<td>${sneaker.name}</td>
				<td>${sneaker.score}</td>
				<td><img width="300" height="400" src="getSneakerImage/<c:out value='${sneaker.id}'/>"></td>
			</tr>
			<c:set var="rank" value="${rank + 1}"/>
		</c:forEach>
	</table>
</div>


</body>
</html>