<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Narudzbina</title>
</head>
<body>

	<form action="/Projekat/korisnikController/naruciJelo" method="get">
	<c:if test="${!empty listaJela }">
	<c:forEach var = "j" items = "${listaJela}">
		<option value = "${j.idJelo }">${j.naziv }
	</c:forEach>
		
		</c:if>
	</form>

</body>
</html>