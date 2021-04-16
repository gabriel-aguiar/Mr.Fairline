package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import conexao.Dao;
import entity.Campeonato;
import entity.Edicao;

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
	
	private static final String SELECT = "SELECT * FROM Campeonato";
	
	private static final String SELECT_ID = "SELECT * FROM Campeonato WHERE campeonato_id = ";
	
	//Salva no banco
	public void store(Campeonato camp){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			// TODO - setar campos do insert
			pst.setLong(1, camp.getCampeonato_id());
			pst.setString(2, camp.getNome());
			pst.setString(3, camp.getSlug());
			pst.setString(4, camp.getNome_popular());
			
			if(camp.getEdicao_atual_id() != null) {
				pst.setLong(5, camp.getEdicao_atual_id());
			}else {
				pst.setNull(5, Types.INTEGER);
			}
			
			pst.setLong(6, camp.getFase_atual_id());
			if(camp.getFase_atual_id() != null) {
				pst.setLong(2, camp.getFase_atual_id());
			}else {
				pst.setNull(2, Types.INTEGER);
			}
			
			pst.setString(7, camp.getRodada_atual());
			pst.setString(8, camp.getStatus());
			pst.setString(9, camp.getTipo());
			pst.setString(10, camp.getLogo());
			pst.setString(11, camp.getLink());
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	

	public  ArrayList<Campeonato> selectAllCotation() {
		
		ArrayList<Campeonato> listTime = new ArrayList<Campeonato>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Campeonato camp = new Campeonato();
				camp.setCampeonato_id(rs.getLong("campeonato_id"));
				camp.setNome(rs.getString("nome"));
				camp.setSlug(rs.getString("slug"));
				camp.setNome_popular(rs.getString("nome_popular"));
				camp.setEdicao_atual_id(rs.getLong("edicao_atual_id"));
				camp.setFase_atual_id(rs.getLong("fase_atual_id"));
				camp.setRodada_atual(rs.getString("rodada_atual"));
				camp.setStatus(rs.getString("status"));
				camp.setTipo(rs.getString("tipo"));
				camp.setLogo(rs.getString("logo"));	
				camp.setLink(rs.getString("link"));
			
				listTime.add (camp);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	
	public boolean ValidaCampeonato(Long id) {
		
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT_ID + id);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				
				return false;
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}

}
