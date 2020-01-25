<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style.css">
<link rel="stylesheet" type="text/css" href="/Projekat/css/style1.css">
<title>Web portal za dostavu hrane</title>
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
	</sec:authorize>
</div>

  <div>
    <img src="/Projekat/slike/222.jpg" width="100%" height="650px">
  </div>

 <h2 class="okvir">O aplikaciji</h2>
 <div id="kutija1">
    <p style="text-align: center;color:#40143F;font-size:18px;align:center;"><em><ins>Dostavaki</ins></em></p>
    <p class="p">
  
      Sve više ljudi, zbog ubrzanog načina života i nedostatka vremena da sprema hranu se odlučuje da hranu naruči na kućnu adresu. 
      Pogledajte ponudu jela iz našeg restorana,isprobajte kuhinje raznolikih zemalja i prepustite se slatko,slano,ljuto,kiselim 
      ukusima.
      </p>
  </div>
  
  <br>
    <div class="footer">
	    <p>Nađite nas i na društvenim mrežama</p>
	    <script src="https://apps.elfsight.com/p/platform.js" defer></script>
	    <div class="elfsight-app-2f8e0368-d3be-4b58-a316-c06c2f872837"></div>
  </div>
 

<footer >
  <p>Powered by Aki-Coder</p>
</footer>
	
</body>


</html>