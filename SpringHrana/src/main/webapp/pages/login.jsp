<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/Projekat/css/login.css">
<title>Logovanje</title>
</head>

<body id="LoginForm">
<div class="container">

<div class="login-form">
<div class="main-div">
    <div class="panel">
   <h2>DOSTAVAKI</h2>
   <p>Unesite username i password</p>
   </div>
    <form id="Login" action="${pageContext.request.contextPath}/login" method="post">

        <div class="form-group">


            <input type="text" class="form-control" name="username" placeholder="username">

        </div>

        <div class="form-group">

            <input type="password" class="form-control" name="password" placeholder="password">

        </div>
        <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Login</button>

    </form>
    </div>

</div></div>
</body>
</html>