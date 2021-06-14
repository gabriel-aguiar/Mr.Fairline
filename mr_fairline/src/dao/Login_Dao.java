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
	
	private static final String SELECT_email = "SELECT * FROM Login WHERE email = ";
	
	private static final String SELECT_senha = "SELECT * FROM Login WHERE senha = ";
	
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
	
public  ArrayList<Login> selectDisparaEmail(String email) {
		
		ArrayList<Login> listLogin = new ArrayList<Login>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT_email + "'" + email + "'");)
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
	
	public boolean ValidaLoginEmail(String email) {
		
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT_email + "'" + email + "'");)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				
				return true;
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean ValidaLoginSenha(String senha) {
		
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT_senha + senha);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				
				return true;
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
}
