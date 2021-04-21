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

import dao.Partidas_Dao;
import entity.Partidas;

@WebServlet(name = "tabelaservlet", urlPatterns = { "/tabelaservlet" })
public class TabelaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Partidas_Dao partidasDao;
	
    public TabelaServlet() {
    	
    	this.partidasDao = new Partidas_Dao(); 
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ArrayList<Partidas> partidas = partidasDao.selectAllPartidas();
		request.setAttribute("listaPartidas", partidas);
		Gson gson = new Gson();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(partidas));
		
		
		//RequestDispatcher rd = request.getRequestDispatcher("ranking.jsp");
		//rd.forward(request, response);
		
	}

}
