package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import conexao.Dao;
import entity.Chave;
import entity.Edicao;

public class Chave_Dao extends Dao{
	
	private static final String INSERT = "INSERT INTO Chave (chave_id,"
			+ "nome,"
			+ "slug,"
			+ "partida_ida_id) "
			+ "VALUES (?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Chave";
	
	private static final String SELECT_ID = "SELECT * FROM Chave WHERE chave_id = ";
	
	//Salva no banco
	public void store(Chave chave){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, chave.getChave_id());
			pst.setString(2, chave.getNome());
			pst.setString(3, chave.getSlug());
			
			if(chave.getPartida_ida_id() != null) {
				pst.setLong(5, chave.getPartida_ida_id());
			}else {
				pst.setNull(5, Types.INTEGER);
			}
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	public  ArrayList<Chave> selectAllCotation() {
		
		ArrayList<Chave> listTime = new ArrayList<Chave>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Chave chave = new Chave();
				chave.setChave_id(rs.getLong("chave_id"));
				chave.setNome(rs.getString("nome"));
				chave.setSlug(rs.getString("slug"));
				chave.setPartida_ida_id(rs.getLong("partida_ida_id"));
				
				listTime.add (chave);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	public boolean ValidaChave(Long id) {
		
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
