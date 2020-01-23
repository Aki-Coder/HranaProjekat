<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style.css">
<title>Komentar</title>
</head>
<body>
	<form action="/Projekat/korisnikController/ostaviKomentar" method="post">
		Unesite komentar za odabrano jelo:<textarea name="komm" cols="50" rows="4">Primedbe,sugestije,pohvale</textarea><br><br>
		Datum unosenja komentara : <input type="date" name = "datum"><br>
		<input type="submit" value = "Ostavi komentar">
	</form>
</body>
</html>