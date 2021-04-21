package controler;

import com.google.gson.JsonObject;

import dao.Campeonato_Dao;
import dao.Edicao_Dao;
import entity.Campeonato;
import entity.Edicao;
import entity.Fase;

public class Fase_Controler {
	
	private Campeonato_Dao campeonatoDao;
	private Edicao_Dao edicaoDao;

	public Fase toFaseJson(JsonObject json) {
		Fase fase = new Fase();
		fase.setFase_id(json.get("fase_id").getAsLong());
		Edicao_Controler edicao_controler = new Edicao_Controler();
		Edicao edicao = edicao_controler.toEdicaoJson(json.get("edicao").getAsJsonObject());
		try {
			edicaoDao = new Edicao_Dao();
			if (edicaoDao.ValidaEdicao(edicao.getEdicao_id())) {
				edicaoDao.store(edicao);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		fase.setEdicao_id(edicao.getEdicao_id());
		Campeonato_Controler campeonato_controler = new Campeonato_Controler();
		Campeonato campeonato = campeonato_controler.toCampeonatoJson(json.get("campeonato").getAsJsonObject(), edicao.getEdicao_id());
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
	
}
