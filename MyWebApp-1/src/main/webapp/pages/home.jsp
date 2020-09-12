<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="utf-8">
	<title>Sneakers Ranking</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/edit.css">
	<!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">-->

	<link href="https://fonts.googleapis.com/css2?family=Source+Serif+Pro&display=swap" rel="stylesheet">

	
</head>
<body>
<h1>By Arya Phan</h1>
<img id="logo" src="https://media.giphy.com/media/iJIdRPp1LMmUNBSBpd/200_d.gif">
<div class="slideshow-container">
	
  <!-- Full-width images with number and caption text -->
  <div class="mySlides fade">
    <div class="numbertext">1 / 3</div>
    <img src="https://sneakersbr.co/wp-content/uploads/2016/08/adidas-nmd-r1-reflective-black-white-4-1.jpg" style="width:100%">
    <div class="text">Intro (to be added later)</div>
  </div>

  <div class="mySlides fade">
    <div class="numbertext">2 / 3</div>
    <img src="https://img.wallpapersafari.com/desktop/1920/1080/78/64/pnfsea.jpg" style="width:100%">
    <div class="text">Some text? (to be added later)</div>
  </div>

  <div class="mySlides fade">
    <div class="numbertext">3 / 3</div>
    <div class="buttonOnImage">
	    <img src="https://images.unsplash.com/photo-1518002171953-a080ee817e1f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80" style="width:100%">
	    <form action="/redirect" method="GET">
	    	<button id="startButton">Start</button>
	    </form>
	</div>
    <div class="text">Some text here? Press Start to begin.</div>
  </div>

  <!-- Next and previous buttons -->
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br>

<!-- The dots/circles -->
<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span>
  <span class="dot" onclick="currentSlide(2)"></span>
  <span class="dot" onclick="currentSlide(3)"></span>
</div>
<script type="text/javascript" src="js/edit.js"></script>
</div>

</body>
</html>