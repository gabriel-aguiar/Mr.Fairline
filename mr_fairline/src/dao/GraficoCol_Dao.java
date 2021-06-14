package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Connect;
import entity.Graficos;
import entity.GraficosCol;

public class GraficoCol_Dao extends Connect{
	
	private static final String INNER_JOIN2 = "SELECT nome_popular, "
			+ "       GOLS "
			+ " FROM "
			+ "  (SELECT time.nome_popular, "
			+ "          jogo.placar_visitante AS GOLS "
			+ "   FROM TIME "
			+ "   INNER JOIN jogo ON time_id = jogo.time_visitante_id "
			+ "   UNION SELECT time.nome_popular, "
			+ "                jogo.placar_mandante AS GOLS "
			+ "   FROM TIME "
			+ "   INNER JOIN jogo ON time_id = jogo.time_mandante_id) AS GOLS "
			+ " ORDER BY GOLS DESC "
			+ " LIMIT 15;";
	
	public ArrayList<GraficosCol> selectAllGraficosCol() {
		
		ArrayList<GraficosCol> listGraficosCol = new ArrayList<GraficosCol>();
		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(INNER_JOIN2);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				GraficosCol graficoscol = new GraficosCol();		
				graficoscol.setNome_popular(rs.getString("nome_popular"));
				graficoscol.setGols(rs.getInt("GOLS"));

				listGraficosCol.add(graficoscol);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listGraficosCol;

	}	

}
