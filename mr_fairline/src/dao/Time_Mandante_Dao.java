package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Dao;
import entity.Proxima_Fase;
import entity.Time_Mandante;

public class Time_Mandante_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Time_Mandante (time_mandante_id,"
			+ "nome_popular,"
			+ "sigla,"
			+ "escudo) "
			+ "VALUES (?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Time_Mandante";
	
	private static final String SELECT_ID = "SELECT * FROM Time_Mandante WHERE time_mandante_id = ";
	
	//Salva no banco
	public void store(Time_Mandante time_mandante){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, time_mandante.getTime_mandante_id());
			pst.setString(2, time_mandante.getNome_popular());
			pst.setString(3, time_mandante.getSigla());
			pst.setString(4, time_mandante.getEscudo());
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	public  ArrayList<Time_Mandante> selectAllCotation() {
		
		ArrayList<Time_Mandante> listTime = new ArrayList<Time_Mandante>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Time_Mandante time_mandante = new Time_Mandante();
				time_mandante.setTime_mandante_id(rs.getLong("time_mandante_id"));
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
	
	public boolean ValidaTime_Mandante(Long id) {
		
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
