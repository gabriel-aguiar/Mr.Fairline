package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Amistoso_Dao;
import dao.Recupera_Dao;
import entity.Amistoso;
import entity.Login;

/**
 * Servlet implementation class RecuperacaoServlet
 */
@WebServlet(name = "recuperacaoservlet", urlPatterns = { "/recuperacaoservlet" })
public class RecuperacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Recupera_Dao recupera_dao;
	
    public RecuperacaoServlet() {
    	
    	this.recupera_dao = new Recupera_Dao();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String senha = request.getParameter("nsenha");
		String email = request.getParameter("email");

		Login login = toUpdate(senha, email);
		try {
			recupera_dao = new Recupera_Dao();
			recupera_dao.store(login);
			System.out.println("Update");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private Login toUpdate(String senha, String email) {
		Login login = new Login();
		login.setSenha(senha);
		login.setEmail(email);
		
		return login;
	}

}
