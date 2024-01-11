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
	
	public String buscarLoginAdministrador() throws ExcecaoDados {
		
		String loginAdmin = null;
		
		try {
			con = new ConexaoBd().getConnection();
			String buscarLogin = "SELECT * FROM administrador";
			stmt = con.prepareStatement(buscarLogin);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				loginAdmin = result.getString("login_Administrador");
			}
			
			
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
		
		return loginAdmin;
	}
	
	
	public String buscarSenhaAdministrador() throws ExcecaoDados {
		
		String senhaAdmin = null;
		
		try {
			con = new ConexaoBd().getConnection();
			String buscarSenha = "SELECT * FROM administrador";
			stmt = con.prepareStatement(buscarSenha);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				senhaAdmin = result.getString("senha_Administrador");
			}
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
		
		return senhaAdmin;
	}
}
