<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Redirected Page
<div align="center">
	<h2><c:out value="${sneaker.name}" /></h2>
	<img src="data:image/jpg;base64,${sneaker.base64Image}" width="240", height="300"/>
</div>
</body>
</html>