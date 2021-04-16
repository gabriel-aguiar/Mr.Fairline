package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Dao;
import entity.Campeonato_Part;
import entity.Edicao;

public class Campeonato_Part_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Campeonato_Part (campeonato_part_id,"
			+ "nome,"
			+ "slug) "
			+ "VALUES (?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Campeonato_Part";
	
	private static final String SELECT_ID = "SELECT * FROM Campeonato_Part WHERE campeonato_part_id = ";
	
	//Salva no banco
	public void store(Campeonato_Part camp_p){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, camp_p.getCampeonato_part_id());
			pst.setString(2, camp_p.getNome());
			pst.setString(3, camp_p.getSlug());
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	public  ArrayList<Campeonato_Part> selectAllCotation() {
		
		ArrayList<Campeonato_Part> listTime = new ArrayList<Campeonato_Part>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Campeonato_Part campeonato_Part = new Campeonato_Part();
				campeonato_Part.setCampeonato_part_id(rs.getLong("campeonato_part_id"));
				campeonato_Part.setNome(rs.getString("nome"));
				campeonato_Part.setSlug(rs.getString("slug"));	
			
				listTime.add (campeonato_Part);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	public boolean ValidaCampeonato_Part(Long id) {
		
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
