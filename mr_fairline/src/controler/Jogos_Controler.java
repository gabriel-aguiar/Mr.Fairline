package controler;

import com.google.gson.JsonObject;

import dao.Estadio_Dao;
import dao.Jogos_Dao;
import dao.Time_Dao;
import entity.Estadio;
import entity.Jogos;
import entity.Time;

public class Jogos_Controler {


	private Estadio_Dao estadioDao;
	private Jogos_Dao jogosDao;
	private Time_Dao timeDao;

	
	public void toJogosJson(JsonObject jsonRequest, Long Fase, Long Campeonato) {

		jsonRequest.getAsJsonArray("chaves").forEach(chave -> {

			JsonObject json = chave.getAsJsonObject();
			Jogos jogos = new Jogos();
			jogos.setJogos_id(json.get("partida_ida").getAsJsonObject().get("partida_id").getAsLong());
			jogos.setNome(json.get("nome").getAsString());
			jogos.setCampeonato_id(Campeonato);
			jogos.setPlacar(json.get("partida_ida").getAsJsonObject().get("placar").getAsString());
			Time_Controler time_controler = new Time_Controler();
			Time time_v = time_controler.toTimeJson(json.get("partida_ida").getAsJsonObject().get("time_visitante").getAsJsonObject());
			try {
				timeDao = new Time_Dao();
				if (timeDao.ValidaTime(time_v.getTime_id())) {
					timeDao.store(time_v);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			jogos.setTime_visitante_id(time_v.getTime_id());
			Time_Controler time_controler_M = new Time_Controler();
			Time time_m = time_controler_M.toTimeJson(json.get("partida_ida").getAsJsonObject().get("time_mandante").getAsJsonObject());
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
			Estadio_Controler estadio_controler = new Estadio_Controler();
			Estadio estadio = estadio_controler.toEstadioJson(json.get("partida_ida").getAsJsonObject().get("estadio").getAsJsonObject());
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
	
}
