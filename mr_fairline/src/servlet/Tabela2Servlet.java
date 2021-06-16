package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Ranking_Dao;
import entity.Ranking;

@WebServlet(name = "tabela2servlet", urlPatterns = { "/tabela2servlet" })
public class Tabela2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Ranking_Dao rankingDao;
	
    public Tabela2Servlet() {
   
    	this.rankingDao = new Ranking_Dao(); 
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Ranking> partidas = rankingDao.selectAllRanking();
		for (Ranking partida : partidas) {
			
			System.out.println(partida.getNome_popular() + partida.getGols());
			
		}
		request.setAttribute("listaPartidas", partidas);
		Gson gson = new Gson();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(partidas));
		
	}

}
