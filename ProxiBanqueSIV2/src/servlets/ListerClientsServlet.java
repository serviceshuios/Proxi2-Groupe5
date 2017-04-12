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
		
		// 1- r�cup�rer les param�tres utilisateur
		//ConseillerClientele conseiller = (ConseillerClientele) request.getAttribute("conseillerClientele");
		HttpSession session = request.getSession();
		ConseillerClientele conseiller = (ConseillerClientele) session.getAttribute("conseillerClientele");
		
		// 2- traitement avec la couche service
		Collection<Client> lesClients = service.listerClient(conseiller);
		
		// 3- pr�paration de l'envoi � la JSP
		//request.setAttribute("conseillerClientele", conseiller);		// setAttribute prends en param�tre un nom qui sera utilis� par la JSP + l'objet correspondant
		//request.setAttribute("lesClients", lesClients);
		session.setAttribute("lesClients", lesClients);
		
		// 4- envoi des �l�ments � la JSP
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
