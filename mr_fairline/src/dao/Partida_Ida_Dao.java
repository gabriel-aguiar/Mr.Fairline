package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Dao;
import entity.Partida_Ida;

public class Partida_Ida_Dao extends Dao{
	
	// TODO arrumar insert
	private static final String INSERT = "INSERT INTO Partida_Ida (partida_ida_id,"
			+ "campeonato_part_id,"
			+ "placar,"
			+ "time_mandante_id,"
			+ "time_visitante_id,"
			+ "placar_mandante,"
			+ "placar_visitante,"
			+ "status,"
			+ "slug,"
			+ "data_realizacao,"
			+ "hora_realizacao, "
			+ "data_realizacao_iso, "
			+ "estadio_id, "
			+ "link) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	//Salva no banco
	public void store(Partida_Ida partida_ida){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setInt(1, partida_ida.getPartida_ida_id());
			pst.setInt(2, partida_ida.getCampeonato_part_id());
			pst.setString(3, partida_ida.getPlacar());
			pst.setInt(4, partida_ida.getTime_mandante_id());
			pst.setInt(5, partida_ida.getTime_visitante_id());
			pst.setInt(6, partida_ida.getPlacar_mandante());
			pst.setInt(7, partida_ida.getPlacar_visitante());
			pst.setInt(8, partida_ida.getStatus());
			pst.setInt(9, partida_ida.getSlug());
			pst.setString(10, partida_ida.getData_realizacao());
			pst.setInt(11, partida_ida.getHora_realizacao());
			pst.setString(12, partida_ida.getData_realizacao_iso());
			pst.setInt(13, partida_ida.getEstadio_id());
			pst.setString(10, partida_ida.getLink());
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	


//	public  ArrayList<Times> selectAllCotation() {
//		
//		ArrayList<Times> listTime = new ArrayList<Times>();
//		try(Connection connection = this.conectar();
//				PreparedStatement pst = connection.prepareStatement(SELECT);)
//		{
//			ResultSet rs = pst.executeQuery();
//			
//			while(rs.next())
//			{				
//
//				Times tim = new Times();
//				tim.setPosicao(rs.getString("posicao"));
//				tim.setNome(rs.getString("nome"));
//				tim.setPontos(rs.getInt("pontos"));
//				tim.setJogos(rs.getInt("jogos"));
//				tim.setVitorias(rs.getInt("vitorias"));
//				tim.setEmpates(rs.getInt("empates"));
//				tim.setDerrotas(rs.getInt("derrotas"));
//			    tim.setGols_pro(rs.getInt("gols_pro"));
//			    tim.setGols_contra(rs.getInt("gols_contra"));
//			    tim.setTotal_gols(rs.getInt("total_gols"));
//			    tim.setAproveitamento(rs.getInt("aproveitamento"));	
//				
//				listTime.add (tim);
//			}		
//			
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		
//		return listTime;
//		
//	}

}
