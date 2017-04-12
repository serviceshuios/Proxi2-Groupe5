<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<!-- Largeur = la largeur du device Ã  mettre avant l'application du style -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="css/style.css"/>
		<title>PROXIBANQUE</title>
	</head>
	
	<body>
		
		<div id="content">
		
			<div class="block">
			
				<h2>Ajouter un client en base de donnée</h2>
				
				<form method="post" action="AjouterClientServlet">
				
					<fieldset id="section-1">						<!-- Ã©lÃ©ment de regroupement -->
						
						<legend>Informations client</legend>
						
						<label for="civilite">Civilité du client :</label>
						<input type="text" name="civilite" id="civilite"/><br />
						
						<label for="nom">Nom du client :</label>
						<input type="text" name="nom" id="nom"/><br />
						
						<label for="prenom">Prénom du client :</label>
						<input type="text" name="prenom" id="prenom"/><br />
						
						<label for="rue">N° et Rue :</label>
						<input type="text" name="rue" id="rue"/><br />
						
						<label for="cp">Code Postal :</label>
						<input type="text" name="cp" id="cp"/><br />

						<label for="ville">Ville :</label>
						<input type="text" name="ville" id="ville"/><br />

						<label for="telephone">Numéro de téléphone :</label>
						<input type="text" name="telephone" id="telephone"/><br />
						
						<label for="email">Adresse mail :</label>
						<input type="text" name="email" id="email"/><br />
						
						<label for="entreprise">Entreprise :</label>
						<input type="text" name="email" id="entreprise"/><br />
						
					</fieldset>
					
					<input type="submit" value="Ajouter"/>
					
				</form>
				
			</div>
			
		</div>
		
	</body>
	
</html>