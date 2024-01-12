package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Administrador;

public class DataAdmin {
	
	private Connection con; 
	private PreparedStatement stmt;
	private ResultSet result;
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public PreparedStatement getStmt() {
		return stmt;
	}

	public void setStmt(PreparedStatement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}

	public void fecharStatement() {
		if(stmt != null ) {try {
			stmt.close();
		} 
			catch (SQLException e) {
			e.printStackTrace();
			}
		}
	}
	
	public void fecharConexao( ) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean buscarLoginAdministrador(String login) throws ExcecaoDados {
		
		boolean resultado = false;
		
		try {
			con = new ConexaoBd().getConnection();
			String buscarLogin = "SELECT * FROM administrador WHERE login_Administrador = ?";
			stmt = con.prepareStatement(buscarLogin);
			stmt.setString(1, login);
			
			result = stmt.executeQuery();
			
			resultado = result.next();
			
		} catch (ExcecaoDados e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao buscar Login");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fecharStatement();
			fecharConexao();
		}
		
		return resultado;
		
	}
	
	
	public boolean buscarSenhaAdministrador(String senha) throws ExcecaoDados {
		
		boolean resultado = false;
		
		try {
			con = new ConexaoBd().getConnection();
			String buscarSenha = "SELECT * FROM administrador WHERE senha_Administrador = ?";
			stmt = con.prepareStatement(buscarSenha);
			stmt.setString(1, senha);
			result = stmt.executeQuery();
			
			resultado = result.next();
			
		} catch (ExcecaoDados e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao buscar senha");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fecharStatement();
			fecharConexao();
		}
		
		return resultado;
	}
}
