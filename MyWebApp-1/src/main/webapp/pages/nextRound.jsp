<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.concurrent.ThreadLocalRandom" %>

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




<c:set var="id1" value="${id1}"/>
<c:set var="id2" value="${id2}"/>

<c:out value = "${id1}"/>
<c:out value = "${id2}"/>

<c:set var="sneaker1" value="${sneakerList.get(id1)}"/>
<c:set var="sneaker2" value="${sneakerList.get(id2)}"/>

The page has been called ${counter} times.
<div align="center">
<form action="/ContinueVoting" method="GET">
	<main class="container"> 
	
	 <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3">
    <div class="bg-dark me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
      <div class="my-3 py-3">
        <%-- <h2 class="display-5">${sneaker1.name}</h2> --%>
        <p class="lead dark">${sneaker1.name}</p>
        <input align="center" class="photo" type="image" name="img1" src="getSneakerImage/<c:out value='${sneaker1.id}'/>" width="100%" height="100%">
       
      </div>
    

    </div>
  <!--   <div id="vs">
     	<p>
      	<h1>V</h1>
      	<h1>S</h1>
      	</p>
     </div> -->
    
    <div class="bg-light me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
      <div class="my-3 p-3">
       <p class="lead">${sneaker2.name}</p>
         <input class="photo" type="image" name="img2" src="getSneakerImage/<c:out value='${sneaker2.id}'/>" width="100%" height="100%">
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


</div>



</body>
</html>