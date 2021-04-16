package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import conexao.Dao;
import entity.Fase;
import entity.Partida_Ida;

public class Partida_Ida_Dao extends Dao{
	
	// TODO arrumar insert
	private static final String INSERT = "INSERT INTO Partida_Ida (partida_ida_id,"
			+ "campeonato_part_id,"
			+ "placar,"
			+ "time_mandante_id,"
			+ "time_visitante_id,"
			+ "placar_mandante,"
			+ "placar_visitante,"
			+ "status,"
			+ "slug,"
			+ "data_realizacao,"
			+ "hora_realizacao, "
			+ "data_realizacao_iso, "
			+ "estadio_id, "
			+ "link) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Partida_Ida";
	
	private static final String SELECT_ID = "SELECT * FROM Partida_Ida WHERE partida_ida_id = ";
	
	//Salva no banco
	public void store(Partida_Ida partida_ida){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, partida_ida.getPartida_ida_id());

			if(partida_ida.getCampeonato_part_id() != null) {
				pst.setLong(11, partida_ida.getCampeonato_part_id());
			}else {
				pst.setNull(11, Types.INTEGER);
			}
			
			pst.setString(3, partida_ida.getPlacar());
			
			if(partida_ida.getTime_mandante_id() != null) {
				pst.setLong(11, partida_ida.getTime_mandante_id());
			}else {
				pst.setNull(11, Types.INTEGER);
			}
			
			if(partida_ida.getTime_visitante_id() != null) {
				pst.setLong(11, partida_ida.getTime_visitante_id());
			}else {
				pst.setNull(11, Types.INTEGER);
			}
			
			pst.setInt(6, partida_ida.getPlacar_mandante());
			pst.setInt(7, partida_ida.getPlacar_visitante());
			pst.setString(8, partida_ida.getStatus());
			pst.setString(9, partida_ida.getSlug());
			pst.setString(10, partida_ida.getData_realizacao());
			pst.setInt(11, partida_ida.getHora_realizacao());
			pst.setString(12, partida_ida.getData_realizacao_iso());

			if(partida_ida.getEstadio_id() != null) {
				pst.setLong(11, partida_ida.getEstadio_id());
			}else {
				pst.setNull(11, Types.INTEGER);
			}
			
			pst.setString(10, partida_ida.getLink());
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	public  ArrayList<Partida_Ida> selectAllCotation() {
		
		ArrayList<Partida_Ida> listTime = new ArrayList<Partida_Ida>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Partida_Ida partida_Ida = new Partida_Ida();
				partida_Ida.setPartida_ida_id(rs.getLong("partida_ida_id"));
				partida_Ida.setCampeonato_part_id(rs.getLong("campeonato_part_id"));
				partida_Ida.setPlacar(rs.getString("placar"));
				partida_Ida.setTime_mandante_id(rs.getLong("time_mandante_id"));
				partida_Ida.setTime_visitante_id(rs.getLong("time_visitante_id"));
				partida_Ida.setPlacar_mandante(rs.getInt("placar_mandante"));
				partida_Ida.setPlacar_visitante(rs.getInt("placar_visitante"));
				partida_Ida.setStatus(rs.getString("status"));
				partida_Ida.setSlug(rs.getString("slug"));
				partida_Ida.setData_realizacao(rs.getString("data_realizacao"));
				partida_Ida.setHora_realizacao(rs.getInt("hora_realizacao"));
				partida_Ida.setData_realizacao_iso(rs.getString("data_realizacao_iso"));
				partida_Ida.setEstadio_id(rs.getLong("estadio_id"));
				partida_Ida.setLink(rs.getString("link"));
			
				listTime.add (partida_Ida);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	
	public boolean ValidaPartida_Ida(Long id) {
		
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
