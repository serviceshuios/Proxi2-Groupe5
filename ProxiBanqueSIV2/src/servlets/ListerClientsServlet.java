package servlets;

import java.io.IOException;
import java.util.Collection;

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
 * Servlet implementation class ListeClientServlet
 */
@WebServlet("/ListerClientsServlet")
public class ListerClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IConseillerClienteleService service = new ConseillerClienteleService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerClientsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 1- récupérer les paramètres utilisateur
		//ConseillerClientele conseiller = (ConseillerClientele) request.getAttribute("conseillerClientele");
		HttpSession session = request.getSession();
		ConseillerClientele conseiller = (ConseillerClientele) session.getAttribute("conseillerClientele");
		
		// 2- traitement avec la couche service
		Collection<Client> lesClients = service.listerClient(conseiller);
		
		// 3- préparation de l'envoi à la JSP
		//request.setAttribute("conseillerClientele", conseiller);		// setAttribute prends en paramètre un nom qui sera utilisé par la JSP + l'objet correspondant
		//request.setAttribute("lesClients", lesClients);
		session.setAttribute("lesClients", lesClients);
		
		// 4- envoi des éléments à la JSP
		request.getRequestDispatcher("/listerClients.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
