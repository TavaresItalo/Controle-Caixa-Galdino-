package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Cliente;

public class dataCliente {
	PreparedStatement stmt;
	Connection con = null;
	ResultSet result;
	
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
			fecharStatement();
			fecharConexao();
		}
		return resultado;
	}
	
	
	public ArrayList<String> buscarNomesTodosOsClientes() throws ExcecaoDados {
		
		ArrayList<String> nomeClientes = new ArrayList<>();
		try {
			con = new ConexaoBd().getConnection();
			String buscarClientes = "SELECT * FROM clientes";
			stmt = con.prepareStatement(buscarClientes);
			
			result = stmt.executeQuery();
			while(result.next() ) {
				String nome = result.getNString("nome_Cliente");
				nomeClientes.add(nome);
			}
			
		} catch (ExcecaoDados e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao buscar leitores");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fecharStatement();
			fecharConexao();
		}
		
		return nomeClientes;
		
	}
	
	
	public Cliente buscarClientePorNome(String nome) throws ExcecaoDados {
		Cliente cliente = null;
		try {
			con = new ConexaoBd().getConnection();
			String buscarCliente = "SELECT * FROM clientes WHERE nome_Cliente = ?";
			stmt = con.prepareStatement(buscarCliente);
			stmt.setString(1, nome);
			
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				
			cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setEmail(result.getString("email_Cliente"));
			cliente.setTelefone(result.getString("telefone_Cliente"));
			
			}
			
		} catch (ExcecaoDados e) {
			
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao buscar cliente por nome");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharStatement();
			fecharConexao();
		}
		
		return cliente;
		}
		
	public void atualizarEmailCliente(String novoEmail, String nomeCliente) throws ExcecaoDados {
		try {
			con = new ConexaoBd().getConnection();
			String atualizarEmail = "UPDATE clientes "
					+ "SET email_Cliente = ?"
					+ "WHERE nome_Cliente = ?";
			stmt = con.prepareStatement(atualizarEmail);
			stmt.setString(1, novoEmail);
			stmt.setString(2, nomeCliente);
			
			stmt.execute();					
		} catch (ExcecaoDados e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao atualizar o email");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			fecharStatement();
			fecharConexao();
		}
	}
	
	public boolean verificarEmail(String novoEmail, String nomeCliente) throws ExcecaoDados {
		boolean resultado = false;
		
		try {
			con = new ConexaoBd().getConnection();
			String verificarEmail = "SELECT * "
					+ "FROM clientes "
					+ "WHERE nome_Cliente = ?";
			stmt = con.prepareStatement(verificarEmail);
			stmt.setString(1, nomeCliente);
			result = stmt.executeQuery();
			
			if (result.next()) {
				if (novoEmail.equalsIgnoreCase(result.getString("email_Cliente"))) {
					resultado = true;
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ExcecaoDados e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao verificar email");
		} finally {
			fecharStatement();
			fecharConexao();
		}
		
		return resultado;
	}
	
	public void atualizarTelefoneCliente(String novoTelefone, String nomeCliente) throws ExcecaoDados{
		try {
			con = new ConexaoBd().getConnection();
			String atualizarTelefone = "UPDATE clientes "
					+ "SET telefone_Cliente = ?"
					+ "WHERE nome_Cliente = ?";
			stmt = con.prepareStatement(atualizarTelefone);
			stmt.setString(1, novoTelefone);
			stmt.setString(2, nomeCliente);
			
			stmt.execute();
			
		} catch (ExcecaoDados e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao atualizar o telefone");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			fecharStatement();
			fecharConexao();
		}
	}
	
	public boolean verificarTelefone(String novoTelefone, String nomeCliente) throws ExcecaoDados {
		boolean resultado = false;
		try {
			con = new ConexaoBd().getConnection();
			String verificarTelefone = "SELECT * FROM clientes WHERE nome_Cliente = ?";
			stmt = con.prepareStatement(verificarTelefone);
			stmt.setString(1, nomeCliente);
			
			result = stmt.executeQuery();
			
			if(result.next()) {
				if(novoTelefone.equalsIgnoreCase(result.getString("telefone_Cliente"))) {
					resultado = true;
				}
			}
		} catch (ExcecaoDados e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao verificar o telefone");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			fecharStatement();
			fecharConexao();
		}
		
		return resultado;
	}
	
	public void ExcluirCliente(String nomeCliente) throws ExcecaoDados {
		
		try {
			con = new ConexaoBd().getConnection();
			String excluirCliente = "DELETE FROM clientes WHERE nome_Cliente = ?";
			stmt = con.prepareStatement(excluirCliente);
			
			stmt.setString(1, nomeCliente);
			
			stmt.execute();
		} catch (ExcecaoDados e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao excluir o cliente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fecharStatement();
			fecharConexao();
		}
	}
		
}
