package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Dao;
import entity.Edicao;
import entity.Fase_Atual;

public class Fase_Atual_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Fase_Atual (fase_atual_id,"
			+ "nome,"
			+ "slug,"
			+ "tipo,"
			+ "link) "
			+ "VALUES (?,?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Fase_Atual";
	
	private static final String SELECT_ID = "SELECT * FROM Fase_Atual WHERE fase_atual_id = ";
	
	//Salva no banco
	public void store(Fase_Atual fase_atual){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, fase_atual.getFase_atual_id());
			pst.setString(2, fase_atual.getNome());
			pst.setString(3, fase_atual.getSlug());
			pst.setString(4, fase_atual.getTipo());
			pst.setString(5, fase_atual.getLink());
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	public  ArrayList<Fase_Atual> selectAllCotation() {
		
		ArrayList<Fase_Atual> listTime = new ArrayList<Fase_Atual>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Fase_Atual fase_atual = new Fase_Atual();
				fase_atual.setFase_atual_id(rs.getLong("fase_atual_id"));
				fase_atual.setNome(rs.getString("nome"));
				fase_atual.setSlug(rs.getString("slug"));
				fase_atual.setTipo(rs.getString("tipo"));
				fase_atual.setLink(rs.getString("link"));	
			
				listTime.add (fase_atual);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	public boolean ValidaFase_Atual(Long id) {
		
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
