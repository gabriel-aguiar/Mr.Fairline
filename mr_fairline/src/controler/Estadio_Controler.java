package controler;

import com.google.gson.JsonObject;

import entity.Estadio;

public class Estadio_Controler {

	public Estadio toEstadioJson(JsonObject json) {
		Estadio estadio = new Estadio();
		estadio.setEstadio_id(json.get("estadio_id").getAsLong());
		estadio.setNome_popular(json.get("nome_popular").getAsString());
		return estadio;
	}
	
}
