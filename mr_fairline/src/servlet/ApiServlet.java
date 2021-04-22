package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import controler.Fase_Controler;
import controler.Jogos_Controler;
import dao.Fase_Dao;
import dao.Login_Dao;
import dao.Ranking_Dao;
import entity.Fase;
import entity.Login;
import entity.Ranking;

@WebServlet(name = "graficos", urlPatterns = { "/graficos" })
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Fase_Dao faseDao;
	private Login_Dao loginDao;
	private boolean Login;

	public ApiServlet() {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("name");
		String email = request.getParameter("email");
		String senha = request.getParameter("password");

		Login login = toRegister(nome, email, senha);
		try {
			loginDao = new Login_Dao();
			loginDao.store(login);
			System.out.println("Save");
		} catch (Exception e) {
			System.out.println(e);
		}

		response.sendRedirect("Login.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		String email = request.getParameter("username");
		String senha = request.getParameter("password");

		Login = toLogin(email, senha);
		if (Login) {
			
			session.setAttribute("status", "SUCCESS");

			String SURL = "https://api.api-futebol.com.br/v1/campeonatos/2/fases/91";
			URL url = new URL(SURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestProperty("Authorization", "Bearer " + "live_3c47619e72400c2f456998647bf3ec");

			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output;

			StringBuffer Response = new StringBuffer();
			while ((output = in.readLine()) != null) {
				Response.append(output);
			}

			in.close();

			JsonObject convertedObject = new Gson().fromJson(Response.toString(), JsonObject.class);
			Fase_Controler fase_controler = new Fase_Controler();
			fase_controler.toFaseJson(convertedObject);
			
			// SALVAR

			Fase fase = fase_controler.toFaseJson(convertedObject);
			try {
				faseDao = new Fase_Dao();
				if (faseDao.ValidaFase(fase.getFase_id())) {
					faseDao.store(fase);
					Jogos_Controler jogos_controler = new Jogos_Controler();
					jogos_controler.toJogosJson(convertedObject, fase.getFase_id(), fase.getCampeonato_id());
					System.out.println("CARGA DE DADOS FINALIZADA");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

			session.setAttribute("Status", "SUCCESS");
			response.sendRedirect("Principal.jsp");
			
		}else{
			
			session.setAttribute("username", "");
			session.setAttribute("password", "");
		    session.setAttribute("Status", "ERROR");
		    response.sendRedirect("Login.jsp");
			
		}

	}

	private Login toRegister(String nome, String email, String senha) {
		Login login = new Login();
		login.setNome(nome);
		login.setEmail(email);
		login.setSenha(senha);

		return login;
	}

	private boolean toLogin(String email, String senha) {
		Login login = new Login();
		boolean valide = false;
		login.setEmail(email);
		login.setSenha(senha);

		try {
			loginDao = new Login_Dao();
			if (loginDao.ValidaLoginEmail(login.getEmail())) {
				if (loginDao.ValidaLoginSenha(login.getSenha())) {

					valide = true;

				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return valide;
	}

}
