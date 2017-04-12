package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjoutClientServlet
 */
@WebServlet("/AjouterClientServlet")
public class AjouterClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		// 1- r�cup�rer les param�tres utilisateur
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int age = Integer.parseInt(request.getParameter("age"));
		String yeux = request.getParameter("yeux");
		
		// 2- traitement avec la couche service
		//Client c = new Client();
		//c.setNom(nom);
		//c.setPrenom(prenom);
		//c.setAge(age);
		//c.setCouleurYeux(yeux);
		
		//service.ajouterClient(c);
		
		// 3- pr�paration de l'envoi � la JSP
		request.setAttribute("nom", nom);		// setAttribute prends en param�tre un nom qui sera utilis� par la JSP + l'objet correspondant
		request.setAttribute("prenom", prenom);
		request.setAttribute("age", age);
		request.setAttribute("yeux", yeux);
		request.setAttribute("message", "Le client " + prenom + " " + nom + " a �t� ajout� � la base de donn�e.");		
		
		// 4- envoi des �l�ments � la JSP
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
