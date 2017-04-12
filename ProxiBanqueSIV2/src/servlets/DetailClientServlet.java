package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Client;
import service.ConseillerClienteleService;
import service.IConseillerClienteleService;

/**
 * Servlet implementation class ListeClientServlet
 */
@WebServlet("/DetailsClientServlet")
public class DetailClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IConseillerClienteleService service = new ConseillerClienteleService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 1- récupérer les paramètres utilisateur
		int id = Integer.parseInt(request.getParameter("id"));
		
		// 2- traitement avec la couche service
		Client client = service.chercherClient(id);
		
		// 3- préparation de l'envoi à la JSP
		request.setAttribute("id", client.getIdClient());
		request.setAttribute("civilite", client.getCivilite());
		request.setAttribute("nom", client.getNom());
		request.setAttribute("prenom", client.getPrenom());
		request.setAttribute("rue", client.getAdresse().getRue());
		request.setAttribute("codePostal", client.getAdresse().getCodePostal());
		request.setAttribute("ville", client.getAdresse().getVille());
		request.setAttribute("telephone", client.getTelephone());
		request.setAttribute("email", client.getEmail());
		request.setAttribute("entreprise", client.getNomEntreprise());
		
		
		if (client.getCompteCourant().getIdCompte()==0) {
			request.setAttribute("comptecourant", "Ce client n'a pas encore de Compte Courant...");
		} else {
			request.setAttribute("comptecourant", client.getCompteCourant().toString());
		}
		
		if (client.getCompteEpargne().getIdCompte()==0) {
			request.setAttribute("compteepargne", "Ce client n'a pas encore de Compte Epargne...");
		} else {
			request.setAttribute("compteepargne", client.getCompteEpargne().toString());
		}
		
		// 4- envoi des éléments à la JSP
		request.getRequestDispatcher("/detailsClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
