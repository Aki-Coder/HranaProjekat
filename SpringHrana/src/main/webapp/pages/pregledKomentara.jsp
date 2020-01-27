<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style.css">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style2.css">
<title>Pregled komentara</title>
</head>
<body>
	<%@include file="navbar.jsp" %><br><br><br><br><br><br>

	<form action="/Projekat/vlasnikController/pregledKomm" method="get">
		Unesite naziv jela za koji zelite da vidite pregled komentara : <input type="text" name = "nazivJela"><br>
		<input class = "dugme" type="submit" value = "Prikazi komentare">
	</form>
	
	
	<form action="/Projekat/vlasnikController/brisiKomentare" method="get">
		<c:if test="${!empty komentari}">
	<p>Komentari za jelo :${k.jelo.naziv}</p>
		<table id = "tabela1" border="1">
		<tr>
			<th>Datum</th>
			<th>Komentari za jelo</th>
			<th>Obrisi komentar/e</th>
		</tr>
		<c:forEach var = "k" items = "${komentari }">
			<tr>
				<td>${k.datum }</td>
				<td>${k.komentar }</td>
				<td>
					<input type="checkbox" name="checkBox"  value = "${k.idKomentar}">
				</td>
			</tr>
		</c:forEach>
		
			
		</table>
		
		<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
		<input class ="dugme"  type="submit" value="Obriši komentar/e">
	<c:if test="${empty komentari }">
		Za izabrano jelo ne postoje komentari.
	</c:if>
	</c:if>
	</form>
	
	<c:if test="${obrisano}">
		<h3>Obrisani su komentari</h3>
	</c:if>
	
</body>
</html>