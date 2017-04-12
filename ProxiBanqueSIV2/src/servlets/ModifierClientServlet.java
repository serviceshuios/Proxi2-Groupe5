package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Client;
import metier.ConseillerClientele;
import service.ConseillerClienteleService;
import service.IConseillerClienteleService;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/ModifierClientServlet")
public class ModifierClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lien vers la couche service
	 */
	private IConseillerClienteleService service = new ConseillerClienteleService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		ConseillerClientele conseiller = (ConseillerClientele) session.getAttribute("conseillerClientele");
		
		if (request.getParameter("action").equals("afficher")) {
			// 1- r�cup�rer les param�tres utilisateur
			int id = Integer.parseInt(request.getParameter("id"));
			
			// 2- traitements avec la couche service		
			Client c = service.chercherClient(id);
			
			// 3- pr�paration envoi
			request.setAttribute("id", c.getIdClient());
			request.setAttribute("civilite", c.getCivilite());
			request.setAttribute("nom", c.getNom());
			request.setAttribute("prenom", c.getPrenom());
			request.setAttribute("rue", c.getAdresse().getRue());
			request.setAttribute("codePostal", c.getAdresse().getCodePostal());
			request.setAttribute("ville", c.getAdresse().getVille());
			request.setAttribute("telephone", c.getTelephone());
			request.setAttribute("email", c.getEmail());
			request.setAttribute("entreprise", c.getNomEntreprise());
			
			// 4- envoi
			request.getRequestDispatcher("/modifierClient.jsp").forward(request, response);
		}
		
		if (request.getParameter("action").equals("modifier")) {
			// 1- r�cup�rer les param�tres utilisateur
			int id = Integer.parseInt(request.getParameter("id"));
			//String civilite = request.getParameter("civilite");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("cp");
			String ville = request.getParameter("ville");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");
			String nomEntreprise = request.getParameter("entreprise");
			
			// 2- traitements avec la couche service
			Client client = service.chercherClient(id);
			client.setNom(nom);
			client.setPrenom(prenom);
			client.getAdresse().setRue(rue);
			client.getAdresse().setCodePostal(codePostal);
			client.getAdresse().setVille(ville);
			client.setTelephone(telephone);
			client.setEmail(email);
			client.setNomEntreprise(nomEntreprise);
			
			service.modifierClient(conseiller, client//, id, civilite, nom, prenom, rue, codePostal, ville, telephone, email, nomEntreprise
					);
			
			// 3- pr�paration envoi
			//request.setAttribute("conseillerClientele", conseiller);
			request.setAttribute("message", "Les informations du client " + client.getPrenom() + " " + client.getNom() + " ont �t� modifi�es en base de donn�e.");
			
			// 4- envoi
			request.getRequestDispatcher("ListerClientsServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
