package controler;

import com.google.gson.JsonObject;

import entity.Edicao;

public class Edicao_Controler {

	public Edicao toEdicaoJson(JsonObject json) {
		Edicao edicao = new Edicao();
		edicao.setEdicao_id(json.get("edicao_id").getAsLong());
		edicao.setTemporada(json.get("temporada").getAsString());
		edicao.setNome(json.get("nome").getAsString());
		edicao.setNome_popular(json.get("nome_popular").getAsString());
		edicao.setSlug(json.get("slug").getAsString());
		return edicao;
	}
	
}
