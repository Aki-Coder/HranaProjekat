<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style.css">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style2.css">
<title>Azuriranje cene</title>
</head>
<body>

	<%@include file="navbar.jsp" %><br><br><br><br><br><br>
		
		<form action="/Projekat/vlasnikController/unosJelaAzuriraj" method="get">
			Unesite naziv jela: <input type="text" name = "nazivJ"><br>
			<input class = "dugme" type="submit" value = "Prikaži jelo"><br>
		</form>
		
		<c:if test="${!empty jela }">
		<form action="/Projekat/vlasnikController/azurirajCenu" method="post">
			${jela.naziv} i cena ${jela.cena}<br>
			Unesite novu cenu jela: <input type="text" name = "cena"><br>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input class = "dugme" type="submit" value = "Ažuriraj">
		</form>
		
		</c:if>
		
		<c:if test="${empty jela }">
			Uneto jelo ne postoji u restoranu.
		</c:if>
		
		<c:if test="${!empty jelo }">
			Cena jela je uspešo ažurirana.
		</c:if>
	
</body>
</html>