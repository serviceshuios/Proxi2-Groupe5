<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/style.css" />
		<title>PROXIBANQUE</title>
	</head>
	
	<body>
	
		<div id="content">
		
			<div class="block">
			
				<h2>Informations client</h2>
						
				<p>Client numéro : <%=request.getAttribute("id")%></p>
				<p><%=request.getAttribute("civilite")%> <%=request.getAttribute("prenom")%> <%=request.getAttribute("nom")%></p>		
				<p><%=request.getAttribute("rue")%></p>
				<p><%=request.getAttribute("codePostal")%> <%=request.getAttribute("ville")%></p>
				<p>Téléphone : <%=request.getAttribute("telephone")%></p>
				<p>Adresse mail : <%=request.getAttribute("email")%></p>
				
				<%String message = (String)request.getAttribute("message");%>
				<%if (request.getAttribute("entreprise") != null) {%>
					<p>Client Professionnel : <%=request.getAttribute("entreprise")%></p>
				<%}%>
				
				<p>Compte Courant : <%=request.getAttribute("comptecourant")%></p>
				
				<p>Compte Epargne : <%=request.getAttribute("compteepargne")%></p>
			</div>

		</div>
	</body>
</html>