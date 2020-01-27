<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style.css">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style2.css">
<title>Unos jela</title>
</head>
<body>

	<%@include file="navbar.jsp" %><br><br><br><br><br><br>
	
	<form action="/Projekat/vlasnikController/unosJela" method="post">
		
		Unesite naziv jela : <input type = "text" name = "nazivJ"><br>
		Unesite detalje za jelo : <input type="text" placeholder= "Sastojci,kalorijska vrednost"  name = "detaljiJ"><br>
		Unesite cenu za jelo : <input type="number" min = 0 name = "cenaJ"><br>
		Unesite kuhinju kojoj jelo pripada :<input type="text" name = "kuhinjaJ"><br>
		Unesite kategoriju za jelo : <input type="text" name = "kategorijaJ"><br>
		<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
		<input class = "dugme" type="submit" value = "Unesite novo jelo"><br>
	</form>
	


</body>
</html>