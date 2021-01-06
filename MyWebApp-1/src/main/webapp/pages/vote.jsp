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
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
	 <link href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	
	<link rel="stylesheet" type="text/css" href="css/vote.css">

	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <!--   <link rel="stylesheet" href="https://fontawesome.com/v4.7.0/assets/font-awesome/css/font-awesome.css"> -->
	
	     <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@1,500&display=swap" rel="stylesheet">
	 
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

<c:set var="id1" value="${id1}"/>
<c:set var="id2" value = "${id2}"/>



<c:set var="sneaker1" value="${sneakerList.get(id1)}"/>
<c:set var="sneaker2" value="${sneakerList.get(id2)}"/>

<header class="site-header sticky-top py-1">
  <nav class="container d-flex flex-column flex-md-row justify-content-between">
   
    <form action="/vote" method="GET">
    	<a class="py-2 d-none d-md-inline-block" href="vote">Vote</a>
    </form>
    
    <form action="/showRanks" method="GET">
    	<a class="py-2 d-none d-md-inline-block" href="showRanks">Ranking</a>
    </form>
    
   
    <a class="py-2 d-none d-md-inline-block" href="#">About</a>
    
  </nav>
</header>

<!-- display-4  fw-normal pt-3  pt-md-5  py-3-->

<form action="/ContinueVoting" method="GET">
<main>
 <div class="position-relative text-center bg-light box">
    <div class="col-md-5 mx-auto">
      <h2 class="display-4">VS</h2>
    </div>

  </div> 
<div class="vote">
	<!-- ps-md-3 bg-dark bg-light text-white-->
  <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-5 row">
  	<!-- <div class="col-1"> </div> -->
    <div class=" border me-md-3 px-3 px-md-5 text-center  overflow-hidden rounded col-6">
      <div class="my-3">
        <h4>${sneaker1.name}</h4>
      </div>
       <input class="photo" type="image" name="img1" src="getSneakerImage/<c:out value='${sneaker1.id}'/>" class="bg-light shadow-sm mx-auto" style="width: 80%">
      
    
    </div>
    <div class=" border me-md-3 px-3 px-md-5 text-center overflow-hidden rounded col-6">
      <div class="my-3">
        <h4>${sneaker2.name}</h4>
      </div>
       <input class="photo" type="image" name="img2" src="getSneakerImage/<c:out value='${sneaker2.id}'/>" class="bg-light shadow-sm mx-auto" style="width: 80%"> 
    </div>
    <!-- <div class="col-1"></div> -->
  </div>
 </div>
  
  	<div>
		<input type="hidden" name="id1" value="${sneaker1.id}">
	</div>
			
	<div>
		<input type="hidden" name="id2" value="${sneaker2.id}">
	</div> 

 
</main>

<footer class="container py-2">
  <div class="row">
  	<div class="col-sm-12  text-center ">
  		<h4>Made by Arya Phan</h4>
  		<a href="https://github.com/aryaphan" class="fa fa-github fa-6" style="font-size: 48px; color:black" ></a>
  	</div>
  	
  	
   <!--  <div class="col-4 col-md">
      <h5>Features</h5>
      <ul class="list-unstyled text-small">
        <li><a class="link-secondary" href="#">Spring Boot</a></li>
        <li><a class="link-secondary" href="#">Java</a></li>
      </ul>
    </div>
    <div class="col-4 col-md">
      <h5>Resources</h5>
      <ul class="list-unstyled text-small">
        <li><a class="link-secondary" href="#">Resource name</a></li>
        <li><a class="link-secondary" href="#">Resource</a></li>
        
      </ul>
    </div>
    <div class="col-4 col-md">
      <h5>About</h5>
      <ul class="list-unstyled text-small">
        <li><a class="link-secondary" href="#">Team</a></li>
        <li><a class="link-secondary" href="#">Locations</a></li>
        <li><a class="link-secondary" href="#">Privacy</a></li>
        <li><a class="link-secondary" href="#">Terms</a></li>
      </ul>
    </div> -->
  </div>
</footer>
	
</form>

</body>
</html>