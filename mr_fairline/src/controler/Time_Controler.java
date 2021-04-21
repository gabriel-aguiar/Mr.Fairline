package controler;

import com.google.gson.JsonObject;

import entity.Time;

public class Time_Controler {

	public Time toTimeJson(JsonObject json) {
		Time time = new Time();
		time.setTime_id(json.get("time_id").getAsLong());
		time.setNome_popular(json.get("nome_popular").getAsString());
		time.setSigla(json.get("sigla").getAsString());
		time.setEscudo(json.get("escudo").getAsString());
		return time;
	}
	
}
