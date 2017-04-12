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
			
			<% Collection<Client> clients = (Collection<Client>) session.getAttribute("lesClients"); %>
			
			<h2>Clients enregistrés en base de donnée</h2>
			
			<table>
				<!-- 1ère ligne (entêtes des colonnes) -->
				<tr>						
					<th>IDENTIFIANT</th>
					<th>CIVILITE</th>
					<th>NOM</th>
					<th>PRENOM</th>
					<th>NOM ENTREPRISE</th>
					<th>ACTIONS</th>
				</tr>
				
				<c:forEach var="c" items="${lesClients}">
					<!-- lignes du tableau (données de la base) -->
					<tr>
						<td><c:out value="${c.getIdClient()}"></c:out></td>
						<td><c:out value="${c.getCivilite()}"></c:out></td>
						<td><c:out value="${c.getNom()}"></c:out></td>
						<td><c:out value="${c.getPrenom()}"></c:out></td>
						<td><c:out value="${c.getNomEntreprise()}"></c:out></td>
						<td>
						<a href="DetailsClientServlet?id=<c:out value="${c.getIdClient()}"></c:out>">Détails</a> |
						    <a href="ModifierClientServlet?action=afficher&id=<c:out value="${c.getIdClient()}"></c:out>">Modifier</a> |
						    <a href="SupprimerClientServlet?id=<c:out value="${c.getIdClient()}"></c:out>">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
			
			<%String message = (String)request.getAttribute("message");%>
			<%if (message != null) {%>
				<p><%=message%></p>
			<%}%>
			
			<p><a href="ajouterClient.html">Ajouter un nouveau client</a></p>
		</div>
		
	</body>
	
</html>