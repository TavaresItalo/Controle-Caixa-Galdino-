package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Cliente;

public class dataCliente {
	PreparedStatement stmt;
	Connection con = null;
	ResultSet result;
	
	
	public void cadastrarCliente(Cliente cliente) {
		try {
			con = new ConexaoBd().getConnection();
			String cadastrarCliente = "INSERT INTO clientes (nome_Cliente, telefone_Cliente, email_Cliente) VALUES (?, ?, ?)";
			
			stmt = con.prepareStatement(cadastrarCliente);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getEmail());
			
			stmt.execute();
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean verificarCliente(String nome) throws ExcecaoDados {
		boolean resultado = false;
		try {
			con = new ConexaoBd().getConnection();
			String verificarCliente = "SELECT * FROM clientes WHERE nome_Cliente = ?";
			stmt = con.prepareStatement(verificarCliente);
			
			stmt.setString(1, nome);
			result = stmt.executeQuery();
			
			if(result.next()) {
				resultado = true;
			} else {
				resultado = false;
			}
				
		
		} catch (ExcecaoDados  e) {
			e = new ExcecaoDados("Erro ao tentar buscar cliente");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null ) {try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultado;
		
		
		
	}
}
