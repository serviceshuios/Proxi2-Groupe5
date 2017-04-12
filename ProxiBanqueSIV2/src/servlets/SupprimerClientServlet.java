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
@WebServlet("/SupprimerClientServlet")
public class SupprimerClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IConseillerClienteleService service = new ConseillerClienteleService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerClientServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		// 1- récupérer les paramètres utilisateur
		int id = Integer.parseInt(request.getParameter("id"));
		//ConseillerClientele conseiller = (ConseillerClientele) request.getAttribute("conseillerClientele");
		HttpSession session = request.getSession();
		ConseillerClientele conseiller = (ConseillerClientele) session.getAttribute("conseillerClientele");
		
		// 2- traitements avec la couche service
		Client client = service.chercherClient(id);
		String prenom = client.getPrenom();
		String nom = client.getNom();
		
		try {
			service.supprimerClient(conseiller, client);

			// 3- préparation envoi
			request.setAttribute("message", "Le client " + prenom + " " + nom + " a été supprimé de la base de donnée.");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4- envoi des éléments à la JSP
		request.getRequestDispatcher("ListerClientsServlet").forward(request, response);

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
