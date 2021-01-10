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
	<!-- <link rel="stylesheet" href="https://fontawesome.com/v4.7.0/assets/font-awesome/css/font-awesome.css">  -->
	
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
        			<form action="/about" method="GET">
    					<a class="nav-link" href="about">About</a>
    				</form>
      			</li>    
    		</ul>
  		</div>  
	</nav>
</header> 


<div class="about">
	<h2>Hi, I'm Arya Phan &#128522</h2>
	<div class="text">
	<p>I'm a Computer Engineering student at UBC. I've always been interested in creating a web application, so this is a self-project 
	to do just that. I'm also a big fan of sneakers and saw this trend on Nike SNKRS Launch where people voted on sneakers, so this is
	where this project idea stems from. Sneakers Voting would provide information to the sneaker industry about what the customers are
	interested in and what the current trends are. It was really exicting because I could combine both my interests in school and outside
	of school together to make a product other people can use.
	  </p>
	  
	<h2>Sneakers Voting and what it does</h2>
	<p>The web app displays 10 different pairs of shoes, 2 pairs for one round, allowing users to pick one over the other. Once the user
	clicks one of the two sneakers, their scores are calculated using Elo Rating System. The ranking will use these scores to display the
	top 10 sneakers.
	</p>
	
	<h2>How it was built</h2>
	<p>
	For the frontend, I used HTML and CSS. For the backend, I used Spring Boot Framework with Java, JSP, and MySQL database. I was able
	to learn this using documentation online and searching Stackoverflow for tips on certain problems I encountered. All this was tracked
	in SneakersVoting repository on my github (See <a href="https://github.com/aryaphan/SneakersVoting"> source code</a>)
	</p>
	
	<h2>Additional features</h2>
	<p>Features to be added:</p>
	<ul>
		<li>Allow users to upload photos of their own sneakers</li>
		<li>Improve user interface for mobile devices</li>
		<li>Display how many times each sneaker is voted in percentage after a vote has been made</li>
	</ul>
	
	<p>Thanks for visiting.</p>
	</div>
</div>

<footer class="container py-2">
  <div class="row">
  	<div class="col-sm-12  text-center ">
  		<a href="https://github.com/aryaphan" class="fa fa-github fa-6" style="font-size: 48px; color:black" ></a>
  		<!-- extra space  -->
  		&nbsp; &nbsp; &nbsp;	
  		<a href="https://www.linkedin.com/in/aryaphan" class="fa fa-linkedin fa-6" style="font-size: 48px;" ></a>
  	</div>
  </div>
</footer> 
	
</body>
</html>