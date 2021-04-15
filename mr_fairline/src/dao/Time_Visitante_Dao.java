package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Dao;
import entity.Time_Visitante;

public class Time_Visitante_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Time_Visitante (time_visitante_id,"
			+ "nome_popular,"
			+ "sigla,"
			+ "escudo) "
			+ "VALUES (?,?,?,?)";
	
	//Salva no banco
	public void store(Time_Visitante time_visitante){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setInt(1, time_visitante.getTime_visitante_id());
			pst.setString(2, time_visitante.getNome_popular());
			pst.setString(3, time_visitante.getSigla());
			pst.setString(4, time_visitante.getEscudo());
			
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

