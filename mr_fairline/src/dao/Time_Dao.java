package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Connect;
import entity.Time;

public class Time_Dao extends Connect{
	
	private static final String INSERT = "INSERT INTO Time (time_id,"
			+ "nome_popular,"
			+ "sigla,"
			+ "escudo) "
			+ "VALUES (?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Time";
	
	private static final String SELECT_ID = "SELECT * FROM Time WHERE time_id = ";
	
	//Salva no banco
	public void store(Time time_mandante){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, time_mandante.getTime_id());
			pst.setString(2, time_mandante.getNome_popular());
			pst.setString(3, time_mandante.getSigla());
			pst.setString(4, time_mandante.getEscudo());
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou6");
		}

	}
	
	public  ArrayList<Time> selectAllCotation() {
		
		ArrayList<Time> listTime = new ArrayList<Time>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Time time_mandante = new Time();
				time_mandante.setTime_id(rs.getLong("time_id"));
				time_mandante.setNome_popular(rs.getString("nome_popular"));
				time_mandante.setSigla(rs.getString("sigla"));
				time_mandante.setEscudo(rs.getString("escudo"));
			
				listTime.add (time_mandante);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	public boolean ValidaTime(Long id) {
		
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
