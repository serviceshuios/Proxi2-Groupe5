package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Adresse;
import metier.Client;
import metier.ClientEntreprise;
import metier.ClientParticulier;
import metier.ConseillerClientele;
import service.ConseillerClienteleService;
import service.IConseillerClienteleService;
import service.exceptions.NombreMaxClientsParConseillerException;

/**
 * Servlet implementation class AjoutClientServlet
 */
@WebServlet("/AjouterClientServlet")
public class AjouterClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Lien vers la couche service
	 */
	private IConseillerClienteleService service = new ConseillerClienteleService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		ConseillerClientele conseiller = (ConseillerClientele) session.getAttribute("conseillerClientele");
		
		// 1- récupérer les paramètres utilisateur
		String civilite = request.getParameter("civilite");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String nomEntreprise = request.getParameter("entreprise");
		
		// 2- traitement avec la couche service
		Client client;
		
		if (nomEntreprise != null) {
			client = new ClientEntreprise();
		} else {
			client = new ClientParticulier();
		}
		client.setCivilite(civilite);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(new Adresse(rue,codePostal,ville));
		client.setTelephone(telephone);
		client.setEmail(email);
		client.setNomEntreprise(nomEntreprise);
		
		try {
			service.ajouterClient(conseiller, client);
		} catch (NombreMaxClientsParConseillerException e) {
			request.setAttribute("message", "Vous gérez déjà 10 clients. Le client " + prenom + " " + nom + " n'a pas été ajouté.");
		}
		
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
		request.setAttribute("message", "Le client " + prenom + " " + nom + " a été ajouté à la base de donnée.");		
		
		// 4- envoi des éléments à la JSP
		//request.getRequestDispatcher("/ajouterClient.jsp").forward(request, response);
		request.getRequestDispatcher("ListerClientsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
