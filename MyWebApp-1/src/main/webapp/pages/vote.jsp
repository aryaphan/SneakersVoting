<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.concurrent.ThreadLocalRandom" %>
<%@page import="com.arya.model.Sneaker" %>

<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/vote.css">
	<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Serif:ital@1&display=swap" rel="stylesheet">
	  <link href="https://fonts.googleapis.com/css2?family=Space+Grotesk:wght@300&display=swap" rel="stylesheet">
	  <link href="https://fonts.googleapis.com/css2?family=Libre+Franklin:wght@100&display=swap" rel="stylesheet">
	  <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@200&display=swap" rel="stylesheet">
	  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<div class ="topnav">
		<nav>
		<ul>
			<li>
				<form action="/vote" method="GET">
					<a class="active" href="vote">Vote</a>
				</form>
			</li>
			<li>
				<form action="/showRanks" method="GET">
					<a href="showRanks"> Ranking </a>
				</form>
			</li>
			<li><a href="https://www.footlocker.ca/?SID=5564&inceptor=1&cm_mmc=paid%20search-_-google-_-g-_-branded-_--_--_-p-_--_--_-199260539-_--_-13242920699-_-textads-_-p31077138328-_-389030572260-_--_--_-&gclid=Cj0KCQiA_qD_BRDiARIsANjZ2LCYshnRDWGk2fy9RTvreRl95Bxzgo7DPr5sWp_2Y2IyA0w3aC2OOIYaAvhzEALw_wcB&gclsrc=aw.ds">About</a></li>
		</ul>
	</nav>
</div>
<div>
		<p>PICK ONE</p>
		<p></p>
</div>

<%
	List<Sneaker> sneakerList = (List<Sneaker>)request.getAttribute("sneakerList");
	int size = sneakerList.size();
	int id1 = ThreadLocalRandom.current().nextInt(0,size);
	int id2 = ThreadLocalRandom.current().nextInt(0,size);
	
	while (id2 == id1) {
		id2 = ThreadLocalRandom.current().nextInt(0,size);
	}
	pageContext.setAttribute("id1", id1);
	pageContext.setAttribute("id2", id2);
%>

<c:set var="id1" value="${id1}"/>
<c:set var="id2" value = "${id2}"/>


<c:out value = "${id1}"/>
<c:out value = "${id2}"/>

<c:set var="sneaker1" value="${sneakerList.get(id1)}"/>
<c:set var="sneaker2" value="${sneakerList.get(id2)}"/>



<div align="center">
<form action="/ContinueVoting" method="GET">
	<table>
		<tr>
			
			<th>${sneaker1.name}</th>
			<th>${sneaker2.name}</th>
		</tr>
		
		
		<tr>
			
			<td>
				<div>
					<input class="photo" type="image" name="img1" src="getSneakerImage/<c:out value='${sneaker1.id}'/>" width="300" height="400">

				</div>
			</td>
			<td>
				<div>
					<input class="photo" type="image" name="img2" src="getSneakerImage/<c:out value='${sneaker2.id}'/>" width="300" height="400">
<%-- 					<img width="300" height="400" src="getSneakerImage/<c:out value='${sneaker2.id}'/>"> --%>
				</div>
			</td>
			<div>
				<input type="hidden" name="id1" value="${sneaker1.id}">
			</div>
			
			<div>
				<input type="hidden" name="id2" value="${sneaker2.id}">
			</div>
			
		</tr>
	
		
		
	</table>
</form>


</div>



</body>
</html>