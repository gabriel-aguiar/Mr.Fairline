package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controler.Email_Controler;

@WebServlet(name = "recuperaservlet", urlPatterns = { "/recuperaservlet" })
public class RecuperaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Email_Controler enviarEmail;
	
    public RecuperaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("adasd");
	    String email = request.getParameter("email");
		Email_Controler enviarEmail = new Email_Controler();
		enviarEmail.EnviarEmail(email);
		response.sendRedirect("Login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}
