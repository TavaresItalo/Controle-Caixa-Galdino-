package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBd {
	
	private String url = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String password = "Plughi123!";
	private String filePath = "/resources/database/scriptDatabaseGaldino.sql";
	
	public Connection getConnection() throws ExcecaoDados {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro de conexão com o banco de dados", e);
		}
		
		try {
			con = DriverManager.getConnection(url + "Galdino", user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro de conexão com o banco de dados", e);
		}
		
		return con;
	}
	
	public void criarBancoDados() {
		
		try (Connection con =  DriverManager.getConnection(url, user, password);){
			java.sql.Statement stmt = con.createStatement();
			
			String createDatabase = "CREATE DATABASE IF NOT EXISTS Galdino;";
			try {
			java.sql.Statement statement = con.createStatement();
			statement.executeUpdate(createDatabase);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}




}

