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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>Rankings</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/vote.css">


	<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@1,500&display=swap" rel="stylesheet">
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>

<%
	List<Sneaker> sneakerRanks = RatingHandler.getRanking();
	pageContext.setAttribute("sneakerRanks", sneakerRanks);
%>

<jsp:useBean id="date" class="java.util.Date" />

<header class="site-header sticky-top py-1">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-between text-center">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		    <span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item">
					<form action="/" method="GET">
						<a class=" nav-link" href="/">Vote</a>
					</form>
				</li>

      			<li class="nav-item">
      				<form action="/showRanks" method="GET">
    					<a class="nav-link" href="showRanks">Ranking</a>
    				</form>
    			</li>

    			<li class="nav-item">
    				<form action="/upload" method="GET">
    					<a class="nav-link" href="upload">Upload</a>
    				</form>
    			</li>

     			 <li class="nav-item">
        			<form action="/about" method="GET">
    					<a class="nav-link" href="about">About</a>
    				</form>
      			</li>
    		</ul>
  		</div>
	</nav>
</header>

<!-- px-md-5 px-3 -->

<!-- class="display-4 fw-normal" -->
<main>
  <div class="position-relative text-center bg-light box">
    <div class="col-md-5 mx-auto" >
      <h2>TOP 10 SNEAKERS <fmt:formatDate value="${date}" pattern="yyyy" /></h2>
    </div>

  </div>
 <!--  me-md-3 -->
  <c:set var="rank" value="1"/>
  <c:set var="startIndex" scope="page" value="0"/>
  <c:set var="endIndex" scope="page" value="9"/>

  <c:forEach begin="${startIndex}" end="${endIndex}" step="5" var="index">
  	<div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-5 row">
  		<c:forEach begin="${index}" end="${index + 4}" step="1" var="i">
			<c:set var="sneaker" value="${sneakerRanks.get(i)}"/>
				<div class="border  text-center  overflow-hidden rounded col-sm-2" id="rank">
			    	<div class="my-3">
			        	<h5>Rank <c:out value="${rank}"/></h5>
			        	<h5>${sneaker.name}</h5>
			     	</div>
			     	<img src="getSneakerImage/<c:out value='${sneaker.id}'/>" class="bg-light shadow-sm mx-auto" style="width: 80%">
			    	<c:set var="rank" value="${rank + 1}"/>
			    </div>
		</c:forEach>
	</div>
  </c:forEach>

</main>

</body>
</html>