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
	<title>Sneakers Voting</title>
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


<c:set var="sneaker1" value="${sneakerList.get(id1)}"/>
<c:set var="sneaker2" value="${sneakerList.get(id2)}"/>

<header class="site-header sticky-top py-1">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-between text-center">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		    <span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item">
					<form action="/vote" method="GET">
						<a class=" nav-link" href="vote">Vote</a>
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

<!-- display-4  fw-normal pt-3  pt-md-5  py-3 class="display-4"-->

<form action="/ContinueVoting" method="GET">
<main>
	<div class="position-relative text-center bg-light box">
    	<div class="col-md-5 mx-auto">
      		<h2 id="vs">VS</h2>
    	</div>
  	</div>

	<div class="vote">
	<!-- ps-md-3 bg-dark bg-light text-white-->
  		<div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-5 row">
  	<!-- me-md-3 -->
    		<div class=" border  px-3 px-md-5 text-center  overflow-hidden rounded col-sm-6">
      			<div class="my-3">
        			<h4>${sneaker1.name}</h4>
      			</div>
       			<input class="photo" type="image" name="img1" src="getSneakerImage/<c:out value='${sneaker1.id}'/>" class="bg-light shadow-sm mx-auto" style="width: 80%">
    		</div>

    		<div class=" border px-3 px-md-5 text-center overflow-hidden rounded col-sm-6">
      			<div class="my-3">
        			<h4>${sneaker2.name}</h4>
      			</div>
       			<input class="photo" type="image" name="img2" src="getSneakerImage/<c:out value='${sneaker2.id}'/>" class="bg-light shadow-sm mx-auto" style="width: 80%">
    		</div>

  		</div>
 	</div>

  	<div>
		<input type="hidden" name="id1" value="${sneaker1.id}">
	</div>

	<div>
		<input type="hidden" name="id2" value="${sneaker2.id}">
	</div>


</main>
</form>

</body>
</html>