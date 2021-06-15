package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Connect;
import entity.Amistoso;

public class Amistoso_Dao extends Connect{
	
	private static final String INSERT = "INSERT INTO Amistoso (nome_time1,"
			+ "nome_time2,"
			+ "data_jogo,"
			+ "palpite_placar) "
			+ "VALUES (?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Amistoso";
	
	public void store(Amistoso amistoso){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setString(1, amistoso.getNome_time1());
			pst.setString(2, amistoso.getNome_time2());
			pst.setString(3, amistoso.getData_jogo());
			pst.setString(4, amistoso.getPalpite_placar());
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou3");
		}

	}
	
	public  ArrayList<Amistoso> selectAllAmistoso() {
		
		ArrayList<Amistoso> listTime = new ArrayList<Amistoso>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Amistoso amistoso = new Amistoso();
				amistoso.setNome_time1(rs.getString("nome_time1"));	
				amistoso.setNome_time2(rs.getString("nome_time2"));
				amistoso.setData_jogo(rs.getString("data_jogo"));
				amistoso.setPalpite_placar(rs.getString("palpite_placar"));
			
				listTime.add (amistoso);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
}