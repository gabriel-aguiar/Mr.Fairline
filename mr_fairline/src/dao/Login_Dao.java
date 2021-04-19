package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Connect;
import entity.Login;

public class Login_Dao extends Connect{

	private static final String INSERT = "INSERT INTO Login (nome,"
			+ "email,"
			+ "senha)"
			+ "VALUES (?,?,?)";
	
	private static final String SELECT = "SELECT * FROM Login";
	
	private static final String SELECT_ID = "SELECT * FROM Login WHERE email = ";
	
	//Salva no banco
	public void store(Login login){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setString(1, login.getNome());
			pst.setString(2, login.getEmail());
			pst.setString(3, login.getSenha());
			
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou7");
		}

	}
	
	public  ArrayList<Login> selectAllCotation() {
		
		ArrayList<Login> listLogin = new ArrayList<Login>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Login login = new Login();
				login.setNome(rs.getString("nome"));
				login.setEmail(rs.getString("email"));
				login.setSenha(rs.getString("senha"));
			
				listLogin.add (login);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listLogin;
		
	}
	
	public boolean ValidaLogin(String email) {
		
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT_ID + email);)
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
