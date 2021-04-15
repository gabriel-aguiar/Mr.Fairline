package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Dao;
import entity.Campeonato;

public class Campeonato_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Campeonato (campeonato_id,"
			+ "nome,"
			+ "slug,"
			+ "nome_popular,"
			+ "edicao_atual_id,"
			+ "fase_atual_id,"
			+ "rodada_atual,"
			+ "status,"
			+ "tipo,"
			+ "logo,"
			+ "link) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
	//Salva no banco
	public void store(Campeonato camp){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			// TODO - setar campos do insert
			pst.setLong(1, camp.getCampeonato_id());
			pst.setString(2, camp.getNome());
			pst.setString(3, camp.getSlug());
			pst.setString(4, camp.getNome_popular());
			pst.setLong(5, camp.getEdicao_atual_id());
			pst.setLong(6, camp.getFase_atual_id());
			pst.setString(7, camp.getRodada_atual());
			pst.setString(8, camp.getStatus());
			pst.setString(9, camp.getTipo());
			pst.setString(10, camp.getLogo());
			pst.setString(11, camp.getlink());
			
			pst.executeUpdate();	
			
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
