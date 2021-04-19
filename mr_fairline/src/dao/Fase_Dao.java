package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import conexao.Connect;
import entity.Fase;

public class Fase_Dao extends Connect{
	
	// TODO arrumar insert
	private static final String INSERT = "INSERT INTO Fase (fase_id,"
			+ "edicao_id,"
			+ "campeonato_id,"
			+ "nome,"
			+ "slug,"
			+ "status,"
			+ "decisivo,"
			+ "eliminatorio,"
			+ "ida_e_volta,"
			+ "tipo) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Fase";
	
	private static final String SELECT_ID = "SELECT * FROM Fase WHERE fase_id = ";
	
	//private static final String UPDATE = "UPDATE Fase";
	
	
	//Salva no banco
	public void store(Fase fase){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, fase.getFase_id());
			
			if(fase.getEdicao_id() != null) {
				pst.setLong(2, fase.getEdicao_id());
			}else {
				pst.setNull(2, Types.INTEGER);
			}
			
			if(fase.getCampeonato_id() != null) {
				pst.setLong(3, fase.getCampeonato_id());
			}else {
				pst.setNull(3, Types.INTEGER);
			}
			
			pst.setString(4, fase.getNome());
			pst.setString(5, fase.getSlug());
			pst.setString(6, fase.getStatus());
			pst.setInt(7, fase.getDecisivo());
			pst.setInt(8, fase.getEliminatorio());
			pst.setInt(9, fase.getIda_e_volta());
			pst.setString(10, fase.getTipo());
			
			pst.executeUpdate();
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou4");
		}

	}
	
	public  ArrayList<Fase> selectAllCotation() {
		
		ArrayList<Fase> listTime = new ArrayList<Fase>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Fase fase = new Fase();
				fase.setFase_id(rs.getLong("fase_id"));
				fase.setEdicao_id(rs.getLong("edicao_id"));
				fase.setCampeonato_id(rs.getLong("campeonato_id"));
				fase.setNome(rs.getString("nome"));
				fase.setSlug(rs.getString("slug"));
				fase.setStatus(rs.getString("status"));
				fase.setDecisivo(rs.getInt("decisivo"));
				fase.setEliminatorio(rs.getInt("eliminatorio"));
				fase.setIda_e_volta(rs.getInt("ida_e_volta"));
				fase.setTipo(rs.getString("tipo"));
				
			
				listTime.add (fase);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	
	public boolean ValidaFase(Long id) {
		
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
	
	/*
	public void update(Fase fase){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(UPDATE);) {
		
			pst.setLong(1, fase.getFase_id());
			if(fase.getEdicao_id() != null) {
				pst.setLong(2, fase.getEdicao_id());
			}else {
				pst.setNull(2, Types.INTEGER);
			}
			if(fase.getCampeonato_id() != null) {
				pst.setLong(3, fase.getCampeonato_id());
			}else {
				pst.setNull(3, Types.INTEGER);
			}
			pst.setString(4, fase.getNome());
			pst.setString(5, fase.getSlug());
			pst.setString(6, fase.getStatus());
			pst.setLong(7, fase.getDecisivo());
			pst.setLong(8, fase.getEliminatorio());
			pst.setLong(9, fase.getIda_e_volta());
			pst.setString(10, fase.getTipo());
			
			pst.executeUpdate();
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	public void updatefk(Fase fase){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(
					
					
					UPDATE + " SET "
					
					+ (fase.getEdicao_id() != null ? "edicao_id =" + fase.getEdicao_id() : "")
					+ (fase.getCampeonato_id() != null ? "campeonato_id =" + fase.getCampeonato_id() : "")
					
					
					+ "WHERE fase_id = " + fase.getFase_id()
					
					
					);) {
		
			
			pst.executeUpdate();
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}*/
	
}
