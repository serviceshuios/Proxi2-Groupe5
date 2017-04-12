<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Collection,metier.Client" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="css/style.css"/>
		<title>PROXIBANQUE</title>
	</head>
	
	<body>
	
		<div class="block">
						
			<p>Bienvenue ${conseillerClientele.civilite} ${conseillerClientele.nom}</p>
			
			<% Collection<Client> clients = (Collection<Client>) request.getAttribute("lesClients"); %>
			
			<h2>Clients enregistrés en base de donnée</h2>
			
			<table>
				<tr>						<!-- 1ère ligne (entêtes des colonnes) -->
					<th>IDENTIFIANT</th>
					<th>CIVILITE</th>
					<th>NOM</th>
					<th>PRENOM</th>
					<th>ADRESSE</th>
					<th>CODE POSTAL</th>
					<th>VILLE</th>
					<th>TELEPHONE</th>
					<th>EMAIL</th>
					<th>NOM ENTREPRISE</th>
					<th>ACTIONS</th>
				</tr>
				
				<%for(Client c : clients) { %>
					<tr>					<!-- lignes du tableau (données de la base) -->
						<td><c:out value="${c.getIdClient()}"></c:out></td>
						<td><%=c.getCivilite()%></td>
						<td><%=c.getNom()%></td>
						<td><%=c.getPrenom()%></td>
						<td><%=c.getAdresse().getRue()%></td>
						<td><%=c.getAdresse().getCodePostal()%></td>
						<td><%=c.getAdresse().getVille()%></td>
						<td><%=c.getTelephone()%></td>
						<td><%=c.getEmail()%></td>
						<td><%=c.getNomEntreprise()%></td>
						<td><a href="ModifierClient?action=afficher&id=<%= c.getIdClient() %>">Modifier</a> | <a href="SupprimerClient?id=<%= c.getIdClient() %>">Supprimer</a></td>
					</tr>
				<%} %>
			</table>
			
			<%String message = (String)request.getAttribute("message");%>
			<%if (message != null) {%>
				<p><%=message%></p>
			<%}%>
			
			<p><a href="ajouterClient.html">Ajouter un nouveau client</a></p>
		</div>
		
	</body>
	
</html>