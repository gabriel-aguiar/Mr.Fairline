package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Dao;
import entity.Time_Mandante;
import entity.Time_Visitante;

public class Time_Visitante_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Time_Visitante (time_visitante_id,"
			+ "nome_popular,"
			+ "sigla,"
			+ "escudo) "
			+ "VALUES (?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Time_Visitante";
	
	private static final String SELECT_ID = "SELECT * FROM Time_Visitante WHERE time_visitante_id = ";
	
	//Salva no banco
	public void store(Time_Visitante time_visitante){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, time_visitante.getTime_visitante_id());
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
	
	public  ArrayList<Time_Visitante> selectAllCotation() {
		
		ArrayList<Time_Visitante> listTime = new ArrayList<Time_Visitante>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Time_Visitante time_visitante = new Time_Visitante();
				time_visitante.setTime_visitante_id(rs.getLong("time_visitante_id"));
				time_visitante.setNome_popular(rs.getString("nome_popular"));
				time_visitante.setSigla(rs.getString("sigla"));
				time_visitante.setEscudo(rs.getString("escudo"));
			
				listTime.add (time_visitante);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	public boolean ValidaTime_Visitante(Long id) {
		
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

