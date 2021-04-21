package controler;

import com.google.gson.JsonObject;

import entity.Campeonato;

public class Campeonato_Controler {

	public Campeonato toCampeonatoJson(JsonObject json, Long Edicao_id) {
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
	
}
