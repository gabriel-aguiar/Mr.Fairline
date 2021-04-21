package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Connect;
import entity.Partidas;

public class Partidas_Dao extends Connect {

	private static final String SELECT = "SELECT time_m.nome_popular AS TIME_MANDANTE,"
			+ "       time_v.nome_popular AS TIME_VISITANTE,"
			+ "       est.nome_popular AS NOME_ESTADIO,"
			+ "       time_m.sigla AS SIGLA_TIME_M,"
			+ "       time_v.sigla AS SIGLA_TIME_V,"
			+ "       time_m.escudo AS ESCUDO_TIME_M,"
			+ "       time_v.escudo AS ESCUDO_TIME_V,"
			+ "       jg.placar_mandante AS PLACAR_MANDANTE,"
			+ "       jg.placar_visitante AS PLACAR_VISITANTE,"
			+ "       jg.data_realizacao AS DATA,"
			+ "       jg.hora_realizacao AS HORA"
			+ "FROM jogo jg"
			+ "INNER JOIN TIME time_m ON jg.time_mandante_id = time_m.time_id"
			+ "INNER JOIN estadio est ON jg.estadio_id = est.estadio_id"
			+ "INNER JOIN TIME time_v ON jg.time_visitante_id = time_v.time_id;";

	
	public ArrayList<Partidas> selectAllPartidas() {

		ArrayList<Partidas> listPartidas = new ArrayList<Partidas>();
		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(SELECT);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Partidas partidas = new Partidas();
				partidas.setNome_time_mandante(rs.getString("TIME_MANDANTE"));
				partidas.setNome_time_visitante(rs.getString("TIME_VISITANTE"));
				partidas.setNome_estadio(rs.getString("NOME_ESTADIO"));
				partidas.setSigla_time_m(rs.getString("SIGLA_TIME_M"));
				partidas.setSigla_time_v(rs.getString("SIGLA_TIME_V"));
				partidas.setEscudo_time_m(rs.getString("ESCUDO_TIME_M"));
				partidas.setEscudo_time_v(rs.getString("ESCUDO_TIME_V"));
				partidas.setPlacar_mandante(rs.getInt("PLACAR_MANDANTE"));
				partidas.setPlacar_visitante(rs.getInt("PLACAR_VISITANTE"));
				partidas.setData_realizacao(rs.getString("DATA"));
				partidas.setHora_realizacao(rs.getString("HORA"));

				listPartidas.add(partidas);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listPartidas;

	}

}
