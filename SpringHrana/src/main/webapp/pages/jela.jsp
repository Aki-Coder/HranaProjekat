<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jela iz restorana</title>
</head>
<body>

	
		<form action="/Projekat/korisnikController/prikazJela" method="get">
			<c:if test="${!empty kategorije }">
				<select name="kategorija">
					<c:forEach var="k" items="${kategorije}">
						<option value=${k.idKategorija }>${k.vrstaKategorije }
					</c:forEach>
				</select>
			</c:if>
			<c:if test="${empty kategorije }">
				<span>Na staju nema dostupnih kategorija.</span>
			</c:if>
			
				 <br>
			<c:if test="${!empty kuhinje }"> 
			 <select name="kuhinja">
				<c:forEach var="ku" items="${kuhinje }">
					<option value=${ku.idKuhinja }>${ku.vrstaKuhinje }
				</c:forEach>
			</select>
			</c:if>
			<c:if test="${empty kuhinje}">
				<span>Na stanju nema kuhinja</span>
			</c:if>
			<input type="submit" value="Pretraga">
		</form>
	
	<c:if test="${empty jela }">
		<span>Nema dostupnih jela.</span>
	</c:if>
	<c:if test="${!empty jela }">
		<table border="1">
			<tr>
				<th>Naziv jela</th>
				<th>Detalji o jelu</th>
				<th>Cena jela</th>
				<th>Naruci jelo iz date kategorije</th>
			</tr>

			<c:forEach var="j" items="${jela }">
				<tr>
					<td>${j.naziv }</td>
					<td>${j.detalji }</td>
					<td>${j.cena }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</form>

</body>
</html>