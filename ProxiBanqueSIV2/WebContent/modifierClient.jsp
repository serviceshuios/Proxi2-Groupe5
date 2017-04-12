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
			
				<h2>Modifier un client</h2>
				
				<form method="post" action="ModifierClientServlet?action=modifier">
				
					<fieldset id="section-1">
					
						<legend>Informations client</legend>
						
						<label for="id">Identifiant du client :</label>
						<input type="text" readonly="readonly" name="id" id="id" value="<%=request.getAttribute("id")%>"/><br />
						
						<label for="civilite">Civilité du client :</label>
						<input type="text" readonly="readonly" name="civilite" id="civilite" value="<%=request.getAttribute("civilite")%>"/><br />
						
						<label for="nom">Nom du client :</label>
						<input type="text" name="nom" id="nom" value="<%=request.getAttribute("nom")%>"/><br />
						
						<label for="prenom">Prénom du client :</label>
						<input type="text" name="prenom" id="prenom" value="<%=request.getAttribute("prenom")%>"/><br />
						
						<label for="rue">N° et Rue :</label>
						<input type="text" name="rue" id="rue" value="<%=request.getAttribute("rue")%>"/><br />
						
						<label for="cp">Code Postal :</label>
						<input type="text" name="cp" id="cp" value="<%=request.getAttribute("codePostal")%>"/><br />

						<label for="ville">Ville :</label>
						<input type="text" name="ville" id="ville" value="<%=request.getAttribute("ville")%>"/><br />

						<label for="telephone">Numéro de téléphone :</label>
						<input type="text" name="telephone" id="telephone" value="<%=request.getAttribute("telephone")%>"/><br />
						
						<label for="email">Adresse mail :</label>
						<input type="text" name="email" id="email" value="<%=request.getAttribute("email")%>"/><br />
						
						<label for="entreprise">Entreprise :</label>
						<input type="text" name="email" id="entreprise" value="<%=request.getAttribute("entreprise")%>"/><br />
						
					</fieldset>
					<input type="submit" value="Modifier" />
				</form>
			</div>

		</div>
	</body>
</html>