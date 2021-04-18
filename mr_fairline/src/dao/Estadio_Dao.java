package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Dao;
import entity.Estadio;

public class Estadio_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Estadio (estadio_id,"
			+ "nome_popular) "
			+ "VALUES (?,?)";
	
	private static final String SELECT = "SELECT * FROM Estadio";
	
	private static final String SELECT_ID = "SELECT * FROM Estadio WHERE estadio_id = ";
	
	//Salva no banco
	public void store(Estadio estadio){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, estadio.getEstadio_id());
			pst.setString(2, estadio.getNome_popular());
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou3");
		}

	}
	
	public  ArrayList<Estadio> selectAllCotation() {
		
		ArrayList<Estadio> listTime = new ArrayList<Estadio>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Estadio estadio = new Estadio();
				estadio.setEstadio_id(rs.getLong("estadio_id"));
				estadio.setNome_popular(rs.getString("nome_popular"));	
			
				listTime.add (estadio);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	public boolean ValidaEstadio(Long id) {
		
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
