package controler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dao.Campeonato_Dao;
import dao.Edicao_Dao;
import dao.Estadio_Dao;
import dao.Fase_Dao;
import dao.Jogos_Dao;
import dao.Login_Dao;
import dao.Time_Dao;
import entity.Campeonato;
import entity.Edicao;
import entity.Fase;
import entity.Estadio;
import entity.Jogos;
import entity.Login;
import entity.Time;

@WebServlet(name = "graficos", urlPatterns = { "/graficos" })
public class Graficos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Fase_Dao faseDao;
	private Campeonato_Dao campeonatoDao;
	private Edicao_Dao edicaoDao;
	private Estadio_Dao estadioDao;
	private Jogos_Dao jogosDao;
	private Time_Dao timeDao;
	private Login_Dao loginDao;
	private boolean Login;

	public Graficos() {

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("username");
		String senha = request.getParameter("password");
		HttpSession session=request.getSession();

		Login = toLogin(email, senha);
		if (Login) {
			
			session.setAttribute("status", "SUCCESS");

			// servico
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

			// conversao response to json
			JsonObject convertedObject = new Gson().fromJson(Response.toString(), JsonObject.class);

			// SALVAR
			Fase fase = toFaseJson(convertedObject);
			try {
				faseDao = new Fase_Dao();
				if (faseDao.ValidaFase(fase.getFase_id())) {
					faseDao.store(fase);
					toJogosJson(convertedObject, fase.getFase_id(), fase.getCampeonato_id());
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

	// TODO validar obj null
	private Fase toFaseJson(JsonObject json) {
		Fase fase = new Fase();
		fase.setFase_id(json.get("fase_id").getAsLong());
		Edicao edicao = toEdicaoJson(json.get("edicao").getAsJsonObject());
		try {
			edicaoDao = new Edicao_Dao();
			if (edicaoDao.ValidaEdicao(edicao.getEdicao_id())) {
				edicaoDao.store(edicao);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		fase.setEdicao_id(edicao.getEdicao_id());

		Campeonato campeonato = toCampeonatoJson(json.get("campeonato").getAsJsonObject(), edicao.getEdicao_id());
		try {
			campeonatoDao = new Campeonato_Dao();
			if (campeonatoDao.ValidaCampeonato(campeonato.getCampeonato_id())) {
				campeonatoDao.store(campeonato);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		fase.setCampeonato_id(campeonato.getCampeonato_id());
		fase.setNome(json.get("nome").getAsString());
		fase.setSlug(json.get("slug").getAsString());
		fase.setStatus(json.get("status").getAsString());
		fase.setDecisivo(json.get("decisivo").getAsBoolean() == true ? 1 : 0);
		fase.setEliminatorio(json.get("eliminatorio").getAsBoolean() == true ? 1 : 0);
		fase.setIda_e_volta(json.get("ida_e_volta").getAsBoolean() == true ? 1 : 0);
		fase.setTipo(json.get("tipo").getAsString());

		return fase;
	}

	private Edicao toEdicaoJson(JsonObject json) {
		Edicao edicao = new Edicao();
		edicao.setEdicao_id(json.get("edicao_id").getAsLong());
		edicao.setTemporada(json.get("temporada").getAsString());
		edicao.setNome(json.get("nome").getAsString());
		edicao.setNome_popular(json.get("nome_popular").getAsString());
		edicao.setSlug(json.get("slug").getAsString());
		return edicao;
	}

	private Campeonato toCampeonatoJson(JsonObject json, Long Edicao_id) {
		Campeonato campeonato = new Campeonato();

		campeonato.setCampeonato_id(json.get("campeonato_id").getAsLong());
		campeonato.setNome(json.get("nome").getAsString());
		campeonato.setSlug(json.get("slug").getAsString());
		campeonato.setNome_popular(json.get("nome_popular").getAsString());
		campeonato.setEdicao_id(Edicao_id);
		campeonato.setStatus(json.get("status").getAsString());
		campeonato.setTipo(json.get("tipo").getAsString());
		campeonato.setLogo(json.get("logo").getAsString());
		campeonato.setLink(json.get("_link").getAsString());
		return campeonato;
	}

	private void toJogosJson(JsonObject jsonRequest, Long Fase, Long Campeonato) {

		jsonRequest.getAsJsonArray("chaves").forEach(chave -> {

			JsonObject json = chave.getAsJsonObject();
			Jogos jogos = new Jogos();
			jogos.setJogos_id(json.get("partida_ida").getAsJsonObject().get("partida_id").getAsLong());
			jogos.setNome(json.get("nome").getAsString());
			jogos.setCampeonato_id(Campeonato);
			jogos.setPlacar(json.get("partida_ida").getAsJsonObject().get("placar").getAsString());

			Time time_v = toTimeJson(json.get("partida_ida").getAsJsonObject().get("time_visitante").getAsJsonObject());
			try {
				timeDao = new Time_Dao();
				if (timeDao.ValidaTime(time_v.getTime_id())) {
					timeDao.store(time_v);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			jogos.setTime_visitante_id(time_v.getTime_id());

			Time time_m = toTimeJson(json.get("partida_ida").getAsJsonObject().get("time_mandante").getAsJsonObject());
			try {
				timeDao = new Time_Dao();
				if (timeDao.ValidaTime(time_m.getTime_id())) {
					timeDao.store(time_m);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			jogos.setTime_mandante_id(time_m.getTime_id());

			jogos.setPlacar_mandante(json.get("partida_ida").getAsJsonObject().get("placar_mandante").getAsInt());
			jogos.setPlacar_visitante(json.get("partida_ida").getAsJsonObject().get("placar_visitante").getAsInt());
			jogos.setStatus(json.get("partida_ida").getAsJsonObject().get("status").getAsString());
			jogos.setSlug(json.get("partida_ida").getAsJsonObject().get("slug").getAsString());
			jogos.setData_realizacao(json.get("partida_ida").getAsJsonObject().get("data_realizacao").getAsString());
			jogos.setHora_realizacao(json.get("partida_ida").getAsJsonObject().get("hora_realizacao").getAsString());
			jogos.setData_realizacao_iso(
					json.get("partida_ida").getAsJsonObject().get("data_realizacao_iso").getAsString());

			Estadio estadio = toEstadioJson(json.get("partida_ida").getAsJsonObject().get("estadio").getAsJsonObject());
			try {
				estadioDao = new Estadio_Dao();
				if (estadioDao.ValidaEstadio(estadio.getEstadio_id())) {
					estadioDao.store(estadio);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			jogos.setEstadio_id(estadio.getEstadio_id());

			jogos.setLink(json.get("partida_ida").getAsJsonObject().get("_link").getAsString());
			jogos.setFase_id(Fase);

			try {
				jogosDao = new Jogos_Dao();
				if (jogosDao.ValidaJogos(jogos.getJogos_id())) {
					jogosDao.store(jogos);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		});
		return;
	}

	private Time toTimeJson(JsonObject json) {
		Time time = new Time();
		time.setTime_id(json.get("time_id").getAsLong());
		time.setNome_popular(json.get("nome_popular").getAsString());
		time.setSigla(json.get("sigla").getAsString());
		time.setEscudo(json.get("escudo").getAsString());
		return time;
	}

	private Estadio toEstadioJson(JsonObject json) {
		Estadio estadio = new Estadio();
		estadio.setEstadio_id(json.get("estadio_id").getAsLong());
		estadio.setNome_popular(json.get("nome_popular").getAsString());
		return estadio;
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
