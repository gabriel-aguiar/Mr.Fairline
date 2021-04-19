package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import conexao.Connect;
import entity.Jogos;

public class Jogos_Dao extends Connect{
	
	// TODO arrumar insert
	private static final String INSERT = "INSERT INTO Jogo (jogos_id,"
			+ "nome,"
			+ "campeonato_id,"
			+ "placar,"
			+ "time_visitante_id,"
			+ "time_mandante_id,"
			+ "placar_mandante,"
			+ "placar_visitante,"
			+ "status,"
			+ "slug,"
			+ "data_realizacao,"
			+ "hora_realizacao,"
			+ "data_realizacao_iso,"
			+ "estadio_id,"
			+ "link,"
			+ "fase_id)"
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Jogo";
	
	private static final String SELECT_ID = "SELECT * FROM Jogo WHERE jogos_id = ";
	
	//Salva no banco
	public void store(Jogos jogos){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setLong(1, jogos.getJogos_id());
			pst.setString(2, jogos.getNome());

			if(jogos.getCampeonato_id() != null) {
				pst.setLong(3, jogos.getCampeonato_id());
			}else {
				pst.setNull(3, Types.INTEGER);
			}
			
			pst.setString(4, jogos.getPlacar());
			pst.setLong(5, jogos.getTime_visitante_id());
			pst.setLong(6, jogos.getTime_mandante_id());
			pst.setInt(7, jogos.getPlacar_mandante());
			pst.setInt(8, jogos.getPlacar_visitante());
			pst.setString(9, jogos.getStatus());
			pst.setString(10, jogos.getSlug());
			pst.setString(11, jogos.getData_realizacao());
			pst.setString(12, jogos.getHora_realizacao());
			pst.setString(13, jogos.getData_realizacao_iso());

			if(jogos.getEstadio_id() != null) {
				pst.setLong(14, jogos.getEstadio_id());
			}else {
				pst.setNull(14, Types.INTEGER);
			}
			
			pst.setString(15, jogos.getLink());
			
			if(jogos.getFase_id() != null) {
				pst.setLong(16, jogos.getFase_id());
			}else {
				pst.setNull(16, Types.INTEGER);
			}
			
			pst.executeUpdate();
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou5");
		}

	}
	
	public  ArrayList<Jogos> selectAllCotation() {
		
		ArrayList<Jogos> listTime = new ArrayList<Jogos>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Jogos jogos = new Jogos();
				jogos.setJogos_id(rs.getLong("jogos_id"));
				jogos.setNome(rs.getString("nome"));
				jogos.setCampeonato_id(rs.getLong("campeonato_id"));
				jogos.setPlacar(rs.getString("placar"));
				jogos.setTime_visitante_id(rs.getLong("time_visitante_id"));
				jogos.setTime_mandante_id(rs.getLong("time_mandante_id"));
				jogos.setPlacar_mandante(rs.getInt("placar_mandante"));
				jogos.setPlacar_visitante(rs.getInt("placar_visitante"));
				jogos.setStatus(rs.getString("status"));
				jogos.setSlug(rs.getString("slug"));
				jogos.setData_realizacao(rs.getString("data_realizacao"));
				jogos.setHora_realizacao(rs.getString("hora_realizacao"));
				jogos.setData_realizacao_iso(rs.getString("data_realizacao_iso"));
				jogos.setEstadio_id(rs.getLong("estadio_id"));
				jogos.setLink(rs.getString("link"));
				jogos.setFase_id(rs.getLong("fase_id"));
			
				listTime.add (jogos);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listTime;
		
	}
	
	
	public boolean ValidaJogos(Long id) {
		
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
