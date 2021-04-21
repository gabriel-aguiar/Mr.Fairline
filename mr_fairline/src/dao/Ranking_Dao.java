package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Connect;
import entity.Ranking;

public class Ranking_Dao extends Connect{
	
	private static final String INNER_JOIN = "SELECT escudo,"
			+ "       nome_popular,"
			+ "       GOLS "
			+ " FROM"
			+ "  (SELECT time.nome_popular,"
			+ "          time.escudo AS ESCUDO,"
			+ "          jogo.placar_mandante AS GOLS"
			+ "   FROM TIME"
			+ "   INNER JOIN jogo ON time_id = jogo.time_mandante_id"
			+ "   UNION SELECT time.nome_popular,"
			+ "                time.escudo AS ESCUDO,"
			+ "                jogo.placar_visitante AS GOLS"
			+ "   FROM TIME"
			+ "   INNER JOIN jogo ON time_id = jogo.time_visitante_id) AS GOLS "
			+ " ORDER BY "
			+ " GOLS DESC;";
			
	
	public ArrayList<Ranking> selectAllRanking() {
		
		ArrayList<Ranking> listRanking = new ArrayList<Ranking>();
		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(INNER_JOIN);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Ranking ranking = new Ranking();
				ranking.setEscudo(rs.getString("ESCUDO"));
				ranking.setNome_popular(rs.getString("nome_popular"));
				ranking.setGols(rs.getInt("GOLS"));

				listRanking.add(ranking);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listRanking;

	}

}
