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

import dao.Amistoso_Dao;
import entity.Amistoso;

@WebServlet(name = "amistososervlet", urlPatterns = { "/amistososervlet" })
public class AmistosoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Amistoso_Dao amistoso_dao;


    public AmistosoServlet() {
    	
    	this.amistoso_dao = new Amistoso_Dao();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Amistoso> amist =  amistoso_dao.selectAllAmistoso();
		request.setAttribute("amist", amist);
		Gson gson = new Gson();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(amist));
        
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome_time1 = request.getParameter("time1");
		String nome_time2 = request.getParameter("time2");
		String data_jogo = request.getParameter("data");
		String palpite_placar = request.getParameter("palpite");
		

		Amistoso amistoso = toRegister(nome_time1, nome_time2, data_jogo, palpite_placar);
		try {
			amistoso_dao = new Amistoso_Dao();
			amistoso_dao.store(amistoso);
			System.out.println("Save");
		} catch (Exception e) {
			System.out.println(e);
		}

		response.sendRedirect("Amistoso.jsp");
	}
	
	private Amistoso toRegister(String nome_time1, String nome_time2, String data_jogo, String palpite_placar) {
		Amistoso amistoso = new Amistoso();
		amistoso.setNome_time1(nome_time1);
		amistoso.setNome_time2(nome_time2);
		amistoso.setData_jogo(data_jogo);
		amistoso.setPalpite_placar(palpite_placar);

		return amistoso;
	}
		
	}
