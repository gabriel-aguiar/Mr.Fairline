package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Dao;
import entity.Edicao_Atual;

public class Edicao_Atual_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Edicao_Atual (edicao_atual_id,"
			+ "temporada,"
			+ "nome,"
			+ "nome_popular,"
			+ "slug) "
			+ "VALUES (?,?,?,?,?)";
	
	//Salva no banco
	public void store(Edicao_Atual edicao_atual){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setInt(1, edicao_atual.getEdicao_atual_id());
			pst.setString(2, edicao_atual.getTemporada());
			pst.setString(3, edicao_atual.getNome());
			pst.setString(4, edicao_atual.getNome_popular());
			pst.setString(5, edicao_atual.getSlug());
			
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
