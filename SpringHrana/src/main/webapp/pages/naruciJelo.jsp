<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style.css">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style2.css">
<title>Narudzbina</title>
</head>
<body>

	<%@include file="navbar.jsp" %><br><br><br><br><br><br>

	<p>Odabrana jela za porudžbinu:</p>
	<form action="/Projekat/korisnikController/poruci" method="post">
		<c:if test="${!empty listaJela && !empty cena}">

			<c:forEach var="j" items="${listaJela}">
				<span>${j.naziv } : ${j.cena }<br></span>
			</c:forEach>
		</c:if>
		
		<p>Ukupna cena narudžbine:</p>
		<c:out value="${cena }"></c:out>
		<br>
		Unesite naziv porudzbine: <input type = "text" name="nazivPorudzbine">
		
		<br> Unesite adresu za isporuku: <input type="text" name="adresa"
			maxlength="50">
		<br>
		Datum isporuke: <input type="date" name = "datum">
		<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
		<input class = "dugme" type="submit" value = "Poruči">
	</form>

</body>
</html>