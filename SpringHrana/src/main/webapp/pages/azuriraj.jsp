<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Azuriranje cene</title>
</head>
<body>

		
		<form action="/Projekat/vlasnikController/unosJelaAzuriraj" method="get">
			Unesite naziv jela: <input type="text" name = "nazivJ"><br>
			<input type="submit" value = "Prikazi jelo"><br>
		</form>
		
		<c:if test="${!empty jela }">
		<form action="/Projekat/vlasnikController/azurirajCenu" method="post">
			${jela.naziv} i cena ${jela.cena}<br>
			Unesite novu cenu jela: <input type="text" name = "cena"><br>
			<input type="submit" value = "Azuriraj">
		</form>
		
		</c:if>
		
		<c:if test="${empty jela }">
			Uneto jelo ne postoji u restoranu.
		</c:if>
		
		<c:if test="${!empty jelo }">
			Cena jela je uspeso azurirana.
		</c:if>
	
</body>
</html>