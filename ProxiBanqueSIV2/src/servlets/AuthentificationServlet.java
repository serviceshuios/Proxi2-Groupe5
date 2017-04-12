package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.ConseillerClientele;
import service.ConseillerClienteleService;
import service.IConseillerClienteleService;

/**
 * Servlet implementation class AjoutClientServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lien vers la couche service
	 */
	private IConseillerClienteleService service = new ConseillerClienteleService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 1- récupérer les paramètres utilisateur
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		// 2- traitement avec la couche service		
		ConseillerClientele conseiller = service.authentifier(login, password);
		
		if (conseiller != null) {
			// Recupere la session ou la crée si elle n'existe pas
			HttpSession session = request.getSession(true);    

			// 3- préparation de l'envoi à la JSP
			//request.setAttribute("conseillerClientele", conseiller);		// setAttribute prends en paramètre un nom qui sera utilisé par la JSP + l'objet correspondant
			session.setAttribute("conseillerClientele", conseiller);
			
			// 4- envoi des éléments à la JSP
			request.getRequestDispatcher("ListerClientsServlet").forward(request, response);
			
		} else {
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
