<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
 	 <link href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
 	
	<link rel="stylesheet" type="text/css" href="css/vote.css">

	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <!--   <link rel="stylesheet" href="https://fontawesome.com/v4.7.0/assets/font-awesome/css/font-awesome.css"> -->
		     <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@1,500&display=swap" rel="stylesheet">
		   <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		
	
</head>
<body>
<!-- py-2 d-none d-md-inline-block -->
<header class="site-header sticky-top py-1">
	<nav class="navbar navbar-expand-md bg-dark navbar-dark justify-content-between text-center">

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
        <form action="/about" method="GET">
    	<a class="nav-link" href="about">About</a>
    </form>
      </li>    
    </ul>
  </div>  
</nav>
</header> 


<div class="about">
	<h1>Hi, I'm Arya Phan</h1>

	<p>I'm a Computer Engineering student at UBC. Sneakers Voting is my first personal project that was built using Spring Boot Framework comprising of Java, JSP, HTML, CSS and MySQL
	Database. This web app is the biggest accomplishment in my self-learning progress so far. It would provide information to the sneaker industry about what customers are interested in and what the 
	current trends are. I was really excited because I could combine both my interests in school and outside of school together to make a product other people can use.
	  <p>
	
</div>
</body>
</html>