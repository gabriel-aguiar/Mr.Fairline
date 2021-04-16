package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Dao;
import entity.Chave;
import entity.Edicao_Atual;

public class Edicao_Atual_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Edicao_Atual (edicao_atual_id,"
			+ "temporada,"
			+ "nome,"
			+ "nome_popular,"
			+ "slug) "
			+ "VALUES (?,?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Edicao_Atual";
	
	private static final String SELECT_ID = "SELECT * FROM Edicao_Atual WHERE edicao_atual_id = ";
	
	//Salva no banco
	public void store(Edicao_Atual edicao_atual){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, edicao_atual.getEdicao_atual_id());
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
	
	public  ArrayList<Edicao_Atual> selectAllCotation() {
		
		ArrayList<Edicao_Atual> listTime = new ArrayList<Edicao_Atual>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Edicao_Atual edicao_atual = new Edicao_Atual();
				edicao_atual.setEdicao_atual_id(rs.getLong("edicao_atual_id"));
				edicao_atual.setTemporada(rs.getString("temporada"));
				edicao_atual.setNome(rs.getString("nome"));
				edicao_atual.setNome_popular(rs.getString("nome_popular"));
				edicao_atual.setSlug(rs.getString("slug"));
				
				listTime.add (edicao_atual);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	public boolean ValidaEdicao_Atual(Long id) {
		
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
