package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBd {
	
	private String url = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String password = "Plughi123!";
	
	
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
			
			String createDatabase = "CREATE DATABASE IF NOT EXISTS galdino;";
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
	
	public void criarTabelas() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			java.sql.Statement stmt = con.createStatement();
			
			String createTables = "CREATE TABLE IF NOT EXISTS administrador (\r\n"
					+ "	login_Administrador VARCHAR(50),\r\n"
					+ "	senha_Administrador VARCHAR(8),\r\n"
					+ "	PRIMARY KEY (login_Administrador)\r\n"
					+ ");\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "CREATE TABLE IF NOT EXISTS clientes(\r\n"
					+ "	nome_Cliente VARCHAR(50), \r\n"
					+ "	email_Cliente VARCHAR(100), \r\n"
					+ "    telefone_Cliente VARCHAR(50),\r\n"
					+ "	PRIMARY KEY (nome_Cliente)\r\n"
					+ ");\r\n"
					+ "\r\n"
					+ "CREATE TABLE IF NOT EXISTS vendas (\r\n"
					+ "	id_Venda INTEGER AUTO_INCREMENT,\r\n"
					+ "    valor DOUBLE,\r\n"
					+ "    data DATE,\r\n"
					+ "    cliente_fk VARCHAR(100),\r\n"
					+ "	FOREIGN KEY (cliente_fk) REFERENCES clientes (nome_Cliente),\r\n"
					+ "	PRIMARY KEY (id_Venda)\r\n"
					+ ");\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "INSERT INTO administrador (login_Administrador, senha_Administrador) VALUES (\"Admin\", \"12345678\");";
			
			stmt.executeUpdate(createTables);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}

