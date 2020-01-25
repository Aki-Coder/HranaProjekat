<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style1.css">
<title>Komentar</title>
</head>
<body>
	<form action="/Projekat/korisnikController/ostaviKomentar" method="post">
	<fieldset class="fieldset2">
	<legend>Komentari</legend>
		Unesite komentar za odabrano jelo:<textarea name="komm" cols="50" rows="4">Primedbe,sugestije,pohvale</textarea><br><br>
		Datum unosenja komentara : <input type="date" name = "datum"><br>
		<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
		<input type="submit" value = "Ostavi komentar">
	 </fieldset>
	</form>
	
	<br>
	
	
	
</body>
</html>