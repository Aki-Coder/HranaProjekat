<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unos jela</title>
</head>
<body>
	
	<form action="/Projekat/vlasnikController/unosJela" method="post">
		
		Unesite naziv jela : <input type="text" name = "nazivJ"><br>
		Unesite detalje za jelo : <input type="text" name = "detaljiJ"><br>
		Unesite cenu za jelo : <input type="number" name = "cenaJ"><br>
		Unesite kuhinju kojoj jelo pripada :<input type="text" name = "kuhinjaJ"><br>
		Unesite kategoriju za jelo : <input type="text" name = "kategorijaJ"><br>
		<input type="submit" value = "Unesite novo jelo"><br>
	</form>
	


</body>
</html>