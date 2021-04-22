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

import dao.Graficos_Dao;
import entity.Graficos;

@WebServlet(name = "graficoservlet", urlPatterns = { "/graficoservlet" })
public class GraficoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Graficos_Dao graficoDao;
	
    public GraficoServlet() {
        
    	this.graficoDao = new Graficos_Dao();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Graficos> grafic =  graficoDao.selectAllGraficos();
		Gson gson = new Gson();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(grafic));
        
	}

}
