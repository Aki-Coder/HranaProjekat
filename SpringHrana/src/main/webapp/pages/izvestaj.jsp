<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style.css">
<title>Izvestaj</title>
</head>
<body>
	<%@include file="navbar.jsp" %><br><br><br><br><br><br>
	
	<form action="/Projekat/izvestajController/datum" method="get">
		Izaberite pocetni datum : <input type="date" name = "pocetniD"><br>
		Izaberite zavrsni datum : <input type="date" name = "zavrsniD"><br>
		<input type="submit" value = "Generisi izvestaj">
	</form>
</body>
</html>