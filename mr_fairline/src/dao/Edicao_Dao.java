package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Dao;
import entity.Edicao;


public class Edicao_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Edicao (edicao_id,"
			+ "temporada,"
			+ "nome,"
			+ "nome_popular,"
			+ "slug) "
			+ "VALUES (?,?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Edicao";
	
	private static final String SELECT_ID = "SELECT * FROM Edicao WHERE edicao_id = ";
	
	//Salva no banco
	public void store(Edicao edicao){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, edicao.getEdicao_id());
			pst.setString(2, edicao.getTemporada());
			pst.setString(3, edicao.getNome());
			pst.setString(4, edicao.getNome_popular());
			pst.setString(5, edicao.getSlug());
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou2");
		}

	}
	
	public  ArrayList<Edicao> selectAllCotation() {
		
		ArrayList<Edicao> listTime = new ArrayList<Edicao>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Edicao edi = new Edicao();
				edi.setEdicao_id(rs.getLong("edicao_id"));
				edi.setTemporada(rs.getString("temporada"));
				edi.setNome(rs.getString("nome"));
				edi.setNome_popular(rs.getString("nome_popular"));
				edi.setSlug(rs.getString("slug"));	
			
				listTime.add (edi);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	public boolean ValidaEdicao(Long id) {
		
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