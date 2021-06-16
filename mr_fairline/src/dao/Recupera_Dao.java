package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Connect;
import entity.Login;

public class Recupera_Dao extends Connect{
	
	private static final String Update = "UPDATE Login "
			+ " SET senha = (?) "
			+ " WHERE email = (?);";
		
		public void store(Login login){

			try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(Update);) {
			
				pst.setString(1, login.getSenha());
				pst.setString(2, login.getEmail());
				
				pst.executeUpdate();	
				
				System.out.println("Atualizou");

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Não Salvou15");
			}

		}

}
