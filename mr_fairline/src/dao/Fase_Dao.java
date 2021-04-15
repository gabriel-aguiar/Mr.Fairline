package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import conexao.Dao;
import entity.Fase;

public class Fase_Dao extends Dao{
	
	// TODO arrumar insert
	private static final String INSERT = "INSERT INTO Fase (fase_id,"
			+ "edicao_id,"
			+ "campeonato_id,"
			+ "nome,"
			+ "slug,"
			+ "status,"
			+ "decisivo,"
			+ "eliminatorio,"
			+ "ida_e_volta,"
			+ "tipo,"
			+ "chave_id, "
			+ "proxima_fase_id, "
			+ "fase_anterior) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE = "UPDATE Fase";
	
	
	//Salva no banco
	public void store(Fase fase){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, fase.getFase_id());
			if(fase.getEdicao_id() != null) {
				pst.setLong(2, fase.getEdicao_id());
			}else {
				pst.setNull(2, Types.INTEGER);
			}
			if(fase.getCampeonato_id() != null) {
				pst.setLong(3, fase.getCampeonato_id());
			}else {
				pst.setNull(3, Types.INTEGER);
			}
			pst.setString(4, fase.getNome());
			pst.setString(5, fase.getSlug());
			pst.setString(6, fase.getStatus());
			pst.setLong(7, fase.getDecisivo());
			pst.setLong(8, fase.getEliminatorio());
			pst.setLong(9, fase.getIda_e_volta());
			pst.setString(10, fase.getTipo());
			if(fase.getChave_id() != null) {
				pst.setLong(11, fase.getChave_id());
			}else {
				pst.setNull(11, Types.INTEGER);
			}
			if(fase.getProxima_fase_id() != null) {
				pst.setLong(12, fase.getProxima_fase_id());
			}else {
				pst.setNull(12, Types.INTEGER);
			}
			pst.setLong(13, fase.getFase_anterior());
			
			pst.executeUpdate();
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	public void update(Fase fase){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(UPDATE);) {
		
			pst.setLong(1, fase.getFase_id());
			if(fase.getEdicao_id() != null) {
				pst.setLong(2, fase.getEdicao_id());
			}else {
				pst.setNull(2, Types.INTEGER);
			}
			if(fase.getCampeonato_id() != null) {
				pst.setLong(3, fase.getCampeonato_id());
			}else {
				pst.setNull(3, Types.INTEGER);
			}
			pst.setString(4, fase.getNome());
			pst.setString(5, fase.getSlug());
			pst.setString(6, fase.getStatus());
			pst.setLong(7, fase.getDecisivo());
			pst.setLong(8, fase.getEliminatorio());
			pst.setLong(9, fase.getIda_e_volta());
			pst.setString(10, fase.getTipo());
			if(fase.getChave_id() != null) {
				pst.setLong(11, fase.getChave_id());
			}else {
				pst.setNull(11, Types.INTEGER);
			}
			if(fase.getProxima_fase_id() != null) {
				pst.setLong(12, fase.getProxima_fase_id());
			}else {
				pst.setNull(12, Types.INTEGER);
			}
			pst.setLong(13, fase.getFase_anterior());
			
			pst.executeUpdate();
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	public void updatefk(Fase fase){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(
					
					
					UPDATE + " SET "
					
					+ (fase.getEdicao_id() != null ? "edicao_id =" + fase.getEdicao_id() : "")
					+ (fase.getCampeonato_id() != null ? "campeonato_id =" + fase.getCampeonato_id() : "")
					+ (fase.getProxima_fase_id() != null ? "proxima_fase_id =" + fase.getProxima_fase_id() : "")
					
					
					
					+ "WHERE fase_id = " + fase.getFase_id()
					
					
					);) {
		
			
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
