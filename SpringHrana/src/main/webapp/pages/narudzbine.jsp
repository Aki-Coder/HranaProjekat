<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style.css">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style2.css">
<title>Narudzbine</title>
</head>
<body>
	<%@include file="navbar.jsp" %><br><br><br><br><br><br>

	<form action="/Projekat/vlasnikController/isporuci"
		method="post">
		<table id = "tabela1" border="1">
			<tr>
				<th>Naziv porudzbine i status</th>
				<th>Odaberi radnika za isporuku</th>
			</tr>

			<tr>

				<td><c:if test="${!empty porudzbine }">
						<select name="por">
							<c:forEach var="p" items="${porudzbine}">
								<option value="${p.idPorudzbina}">${p.nazivPorudzbine} - 
									${p.status}</option>
							</c:forEach>
						</select>
					</c:if></td>

				<td><c:if test="${!empty radnici }">
						<select name="radnik">
							<c:forEach var="r" items="${radnici }">
								<option value="${r.idKorisnik}">${r.ime}${r.prezime }</option>		
							</c:forEach>
						</select>
					</c:if></td>


			</tr>

		</table>

		<input class = "dugme" type="submit" value="Isporuči">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>

</body>
</html>