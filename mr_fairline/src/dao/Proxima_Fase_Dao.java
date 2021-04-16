package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Dao;
import entity.Edicao;
import entity.Proxima_Fase;

public class Proxima_Fase_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Proxima_Fase (proxima_fase_id,"
			+ "nome,"
			+ "slug,"
			+ "tipo,"
			+ "link) "
			+ "VALUES (?,?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Proxima_Fase";
	
	private static final String SELECT_ID = "SELECT * FROM Proxima_Fase WHERE proxima_fase_id = ";
	
	//Salva no banco
	public void store(Proxima_Fase proxima_fase){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, proxima_fase.getProxima_fase_id());
			pst.setString(2, proxima_fase.getNome());
			pst.setString(3, proxima_fase.getSlug());
			pst.setString(4, proxima_fase.getTipo());
			pst.setString(5, proxima_fase.getLink());
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	public  ArrayList<Proxima_Fase> selectAllCotation() {
		
		ArrayList<Proxima_Fase> listTime = new ArrayList<Proxima_Fase>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Proxima_Fase proxima_fase_id = new Proxima_Fase();
				proxima_fase_id.setProxima_fase_id(rs.getLong("proxima_fase_id"));
				proxima_fase_id.setNome(rs.getString("nome"));
				proxima_fase_id.setSlug(rs.getString("slug"));
				proxima_fase_id.setTipo(rs.getString("tipo"));
				proxima_fase_id.setLink(rs.getString("link"));	
			
				listTime.add (proxima_fase_id);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	public boolean ValidaProxima_Fase(Long id) {
		
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

