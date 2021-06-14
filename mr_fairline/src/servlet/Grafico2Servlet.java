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

import dao.GraficoCol_Dao;
import entity.Graficos;
import entity.GraficosCol;

@WebServlet(name = "grafico2servlet", urlPatterns = { "/grafico2servlet" })
public class Grafico2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GraficoCol_Dao GraficoColDao;
   
    public Grafico2Servlet() {
        
    	this.GraficoColDao = new GraficoCol_Dao(); 
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<GraficosCol> graficCol = GraficoColDao.selectAllGraficosCol();
		Gson gson = new Gson();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(graficCol));
		
	}

}
