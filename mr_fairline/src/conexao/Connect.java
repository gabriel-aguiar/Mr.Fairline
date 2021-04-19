package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/mr.fairline?useTimezone=true&serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	private String user = "root";
	private String password = "";
	
	
	public Connection conectar() {
		Connection con = null;
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
	
