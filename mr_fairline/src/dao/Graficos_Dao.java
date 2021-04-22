package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Connect;
import entity.Graficos;

public class Graficos_Dao extends Connect{
	
	private static final String INNER_JOIN = "SELECT nome_popular, "
			+ "       GOLS "
			+ " FROM "
			+ "  (SELECT time.nome_popular,"
			+ "          jogo.placar_mandante AS GOLS "
			+ "   FROM TIME "
			+ "   INNER JOIN jogo ON time_id = jogo.time_mandante_id "
			+ "   UNION SELECT time.nome_popular, "
			+ "                jogo.placar_visitante AS GOLS "
			+ "   FROM TIME "
			+ "   INNER JOIN jogo ON time_id = jogo.time_visitante_id) AS GOLS "
			+ " ORDER BY GOLS DESC "
			+ " LIMIT 5;";
			
	
	public ArrayList<Graficos> selectAllGraficos() {
		
		ArrayList<Graficos> listGraficos = new ArrayList<Graficos>();
		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(INNER_JOIN);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Graficos graficos = new Graficos();		
				graficos.setNome_popular(rs.getString("nome_popular"));
				graficos.setGols(rs.getInt("GOLS"));

				listGraficos.add(graficos);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listGraficos;

	}

}
