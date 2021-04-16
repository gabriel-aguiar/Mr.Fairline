package controler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.Campeonato_Dao;
import dao.Campeonato_Part_Dao;
import dao.Chave_Dao;
import dao.Edicao_Atual_Dao;
import dao.Edicao_Dao;
import dao.Estadio_Dao;
import dao.Fase_Atual_Dao;
import dao.Fase_Dao;
import dao.Partida_Ida_Dao;
import dao.Proxima_Fase_Dao;
import dao.Time_Mandante_Dao;
import dao.Time_Visitante_Dao;
import entity.Campeonato;
import entity.Campeonato_Part;
import entity.Edicao;
import entity.Fase;
import entity.Chave;
import entity.Edicao_Atual;
import entity.Estadio;
import entity.Fase_Atual;
import entity.Partida_Ida;
import entity.Proxima_Fase;
import entity.Time_Mandante;
import entity.Time_Visitante;



@WebServlet(name = "graficos", urlPatterns = { "/graficos" })
public class Graficos extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private Fase_Dao faseDao;
	private Campeonato_Dao campeonatoDao;
	private Campeonato_Part_Dao campeonato_partDao;
	private Chave_Dao chaveDao;
	private Edicao_Atual_Dao edicao_atualDao;
	private Edicao_Dao edicaoDao;
	private Estadio_Dao estadioDao;
	private Fase_Atual_Dao fase_atualDao;
	private Partida_Ida_Dao partida_idaDao;
	private Proxima_Fase_Dao proxima_faseDao;
	private Time_Mandante_Dao time_mandanteDao;
	private Time_Visitante_Dao time_visitanteDao;
	

	public Graficos() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//servico
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

		response.getWriter().print(convertedObject);
		
		Edicao edicao = toEdicaoJson(convertedObject.get("edicao").getAsJsonObject());
		try {
			edicaoDao = new Edicao_Dao();
			if (edicaoDao.ValidaEdicao(edicao.getEdicao_id())){
				edicaoDao.store(edicao);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		// conversao manual
		Fase fase = toFaseJson(convertedObject);
		// salvar fases
		try {
			faseDao = new Fase_Dao();
			faseDao.store(fase);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Campeonato campeonato = toCampeonatoJson(convertedObject.get("campeonato").getAsJsonObject());
		try {
			campeonatoDao = new Campeonato_Dao();
			campeonatoDao.store(campeonato);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		fase = toFkUpdateFaseJson(convertedObject);
		try {
			faseDao.update(fase);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		/*
		Campeonato_Part campeonato_part = toCampeonato_PartJson(convertedObject.get("campeonato_part").getAsJsonObject());
		try {
			campeonato_partDao = new Campeonato_Part_Dao();
			campeonato_partDao.store(campeonato_part);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Chave chave = toChaveJson(convertedObject.get("chave").getAsJsonObject());
		try {
			chaveDao = new Chave_Dao();
			chaveDao.store(chave);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Edicao_Atual edicao_atual = toEdicao_AtualJson(convertedObject.get("edicao_atual").getAsJsonObject());
		try {
			edicao_atualDao = new Edicao_Atual_Dao();
			edicao_atualDao.store(edicao_atual);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Edicao edicao = toEdicaoJson(convertedObject.get("edicao").getAsJsonObject());
		try {
			edicaoDao = new Edicao_Dao();
			edicaoDao.store(edicao);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Estadio estadio = toEstadioJson(convertedObject.get("estadio").getAsJsonObject());
		try {
			estadioDao = new Estadio_Dao();
			estadioDao.store(estadio);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Fase_Atual fase_atual = toFase_AtualJson(convertedObject.get("fase_atual").getAsJsonObject());
		try {
			fase_atualDao = new Fase_Atual_Dao();
			fase_atualDao.store(fase_atual);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Partida_Ida partida_ida = toPartida_IdaJson(convertedObject.get("partida_ida").getAsJsonObject());
		try {
			partida_idaDao = new Partida_Ida_Dao();
			partida_idaDao.store(partida_ida);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Proxima_Fase proxima_fase = toProxima_FaseJson(convertedObject.get("proxima_fase").getAsJsonObject());
		try {
			proxima_faseDao = new Proxima_Fase_Dao();
			proxima_faseDao.store(proxima_fase);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Time_Mandante time_mandante = toTime_MandanteJson(convertedObject.get("time_mandante").getAsJsonObject());
		try {
			time_mandanteDao = new Time_Mandante_Dao();
			time_mandanteDao.store(time_mandante);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Time_Visitante time_visitante = toTime_VisitanteJson(convertedObject.get("time_visitante").getAsJsonObject());
		try {
			time_visitanteDao = new Time_Visitante_Dao();
			time_visitanteDao.store(time_visitante);
		} catch (Exception e) {
			System.out.println(e);
		}*/
		

	}

	// TODO validar obj null
	private Fase toFaseJson(JsonObject json) {
		Fase fase = new Fase();
		fase.setFase_id(json.get("fase_id").getAsLong());
		fase.setNome(json.get("nome").getAsString());
		fase.setSlug(json.get("slug").getAsString());
		fase.setDecisivo(json.get("decisivo").getAsBoolean() == true ? 1 : 0);
		fase.setEliminatorio(json.get("eliminatorio").getAsBoolean() == true ? 1 : 0);
		fase.setIda_e_volta(json.get("ida_e_volta").getAsBoolean() == true ? 1 : 0);
		fase.setTipo(json.get("tipo").getAsString());
		fase.setStatus(json.get("status").getAsString());
		
		return fase;
	}
	
	private Fase toFkUpdateFaseJson(JsonObject json) {
		Fase fase = new Fase();
		fase.setFase_id(json.get("fase_id").getAsLong());
		
		if(json.get("edicao") != null && json.get("edicao").getAsJsonObject().get("edicao_id") != null) {
			
			try {
				Edicao edicao = toEdicaoJson(json.get("edicao").getAsJsonObject());
				if (edicaoDao.ValidaEdicao(edicao.getEdicao_id())){
					edicaoDao.store(edicao);
				}
					fase.setEdicao_id(json.get("edicao").getAsJsonObject().get("edicao_id").getAsLong());
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		//fase.setCampeonato_id(json.get("campeonato").getAsJsonObject().get("campeonato_id").getAsInt());
		//fase.setChave_id(json.get("chave").getAsJsonObject().get("chave_id").getAsInt());
		//fase.setProxima_fase_id(json.get("proxima_fase").getAsJsonObject().get("proxima_fase_id").getAsInt());
		
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

	private Campeonato toCampeonatoJson(JsonObject json) {
		Campeonato campeonato = new Campeonato();

		campeonato.setCampeonato_id(json.get("campeonato_id").getAsLong());
		campeonato.setNome(json.get("nome").getAsString());
		campeonato.setSlug(json.get("slug").getAsString());
		campeonato.setNome_popular(json.get("nome_popular").getAsString());
		if(json.get("edicao_atual") != null && json.get("edicao_atual").getAsJsonObject().get("edicao_id") != null) {
			
			try {
				Edicao edicao = toEdicaoJson(json.get("edicao_atual").getAsJsonObject());
				if (edicaoDao.ValidaEdicao(edicao.getEdicao_id())){
					edicaoDao.store(edicao);
				}
					campeonato.setEdicao_atual_id(json.get("edicao_atual").getAsJsonObject().get("edicao_id").getAsLong());
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		//campeonato.setFase_atual_id(json.get("fase_atual").getAsJsonObject().get("fase_atual_id").getAsInt());
		campeonato.setStatus(json.get("status").getAsString());
		campeonato.setTipo(json.get("tipo").getAsString());
		campeonato.setLogo(json.get("logo").getAsString());
		campeonato.setLink(json.get("_link").getAsString());
		return campeonato;
	}
	
	private Edicao_Atual toEdicao_AtualJson(JsonObject json) {
		Edicao_Atual edicao_a = new Edicao_Atual();
		edicao_a.setEdicao_atual_id(json.get("edicao_atual_id").getAsLong());
		edicao_a.setTemporada(json.get("temporada").getAsString());
		edicao_a.setNome(json.get("nome").getAsString());
		edicao_a.setNome_popular(json.get("nome_popular").getAsString());
		edicao_a.setSlug(json.get("slug").getAsString());
		return edicao_a;
	}
	
	private Fase_Atual toFase_AtualJson(JsonObject json) {
		Fase_Atual fase_a = new Fase_Atual();
		fase_a.setFase_atual_id(json.get("fase_atual_id").getAsLong());
		fase_a.setNome(json.get("nome").getAsString());
		fase_a.setSlug(json.get("slug").getAsString());
		fase_a.setTipo(json.get("tipo").getAsString());
		fase_a.setLink(json.get("link").getAsString());
		return fase_a;
	}
	
	private Chave toChaveJson(JsonObject json) {
		Chave chave = new Chave();
		chave.setChave_id(json.get("chave_id").getAsLong());
		chave.setNome(json.get("nome").getAsString());
		chave.setSlug(json.get("slug").getAsString());
		chave.setPartida_ida_id(json.get("partida_ida").getAsJsonObject().get("partida_ida_id").getAsLong());
		return chave;
	}
	
	private Partida_Ida toPartida_IdaJson(JsonObject json) {
		Partida_Ida partida_Ida = new Partida_Ida();
		partida_Ida.setPartida_ida_id(json.get("partida_ida_id").getAsLong());
		partida_Ida.setCampeonato_part_id(json.get("campeonato").getAsJsonObject().get("campeonato_part_id").getAsLong());
		partida_Ida.setPlacar(json.get("placar").getAsString());
		partida_Ida.setTime_mandante_id(json.get("time_mandante").getAsJsonObject().get("time_mandante_id").getAsLong());
		partida_Ida.setTime_visitante_id(json.get("time_visitante").getAsJsonObject().get("time_visitante_id").getAsLong());
		partida_Ida.setPlacar_mandante(json.get("placar_mandante").getAsInt());
		partida_Ida.setPlacar_visitante(json.get("placar_visitante").getAsInt());
		partida_Ida.setStatus(json.get("status").getAsString());
		partida_Ida.setSlug(json.get("slug").getAsString());
		partida_Ida.setData_realizacao(json.get("data_realizacao").getAsString());
		partida_Ida.setHora_realizacao(json.get("hora_realizacao").getAsInt());
		partida_Ida.setData_realizacao_iso(json.get("data_realizacao_iso").getAsString());
		partida_Ida.setEstadio_id(json.get("estadio").getAsJsonObject().get("estadio_id").getAsLong());
		partida_Ida.setLink(json.get("link").getAsString());
		return partida_Ida;
	}
	
	private Campeonato_Part toCampeonato_PartJson(JsonObject json) {
		Campeonato_Part campeonato_p = new Campeonato_Part();

		campeonato_p.setCampeonato_part_id(json.get("campeonato_part_id").getAsLong());
		campeonato_p.setNome(json.get("nome").getAsString());
		campeonato_p.setSlug(json.get("slug").getAsString());
		return campeonato_p;
	}
	
	private Time_Mandante toTime_MandanteJson(JsonObject json) {
		Time_Mandante time_mandante = new Time_Mandante();
		time_mandante.setTime_mandante_id(json.get("time_mandante_id").getAsLong());
		time_mandante.setNome_popular(json.get("nome_popular").getAsString());
		time_mandante.setSigla(json.get("sigla").getAsString());
		time_mandante.setEscudo(json.get("escudo").getAsString());
		return time_mandante;
	}
	
	private Time_Visitante toTime_VisitanteJson(JsonObject json) {
		Time_Visitante time_visitante = new Time_Visitante();
		time_visitante.setTime_visitante_id(json.get("time_mandante_id").getAsLong());
		time_visitante.setNome_popular(json.get("nome_popular").getAsString());
		time_visitante.setSigla(json.get("sigla").getAsString());
		time_visitante.setEscudo(json.get("escudo").getAsString());
		return time_visitante;
	}
	
	private Estadio toEstadioJson(JsonObject json) {
		Estadio estadio = new Estadio();
		estadio.setEstadio_id(json.get("estadio_id").getAsLong());
		estadio.setNome_popular(json.get("nome_popular").getAsString());
		return estadio;
	}
	
	private Proxima_Fase toProxima_FaseJson(JsonObject json) {
		Proxima_Fase proxima_fase = new Proxima_Fase();
		proxima_fase.setProxima_fase_id(json.get("proxima_fase_id").getAsLong());
		proxima_fase.setNome(json.get("nome").getAsString());
		proxima_fase.setSlug(json.get("slug").getAsString());
		proxima_fase.setTipo(json.get("tipo").getAsString());
		proxima_fase.setLink(json.get("link").getAsString());
		return proxima_fase;
	}
}
