<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style.css">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style2.css">
<title>Insert title here</title>
</head>
<body>
	<div class="navigacionibar">
	<sec:authorize access="hasRole('korisnik')">
		<a href="/Projekat/korisnikController/pozoviStranicuJelo">Prikaz jela</a>
	</sec:authorize>
	<sec:authorize access="hasRole('vlasnik')">
		<a href="/Projekat/pages/unosJela.jsp">Unos novog jela</a>
		<a href="/Projekat/pages/pregledKomentara.jsp">Komentari</a>
		<a href ="/Projekat/pages/azuriraj.jsp">Ažuriraj cenu jela </a>
		<a href="/Projekat/vlasnikController/prikaziNarudzbine">Narudžbine</a>
		<a href = "/Projekat/pages/izvestaj.jsp">Izveštaji</a>
	</sec:authorize>
	<form action="/Projekat/logout" method="post">
		<input class = "dugme" type="submit" value="Odjavi se">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	
</div>
</body>
</html>