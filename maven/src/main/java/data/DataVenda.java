package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import models.Cliente;
import models.Venda;

public class DataVenda {
	private Connection con = null;
	private PreparedStatement stmt;
	private ResultSet result;
	private dataCliente dadosCliente = new dataCliente();
	
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
	
	public void realizarVenda(Venda venda) throws ExcecaoDados {
		
		try {
			con = new ConexaoBd().getConnection();
			String realizarVenda = "INSERT INTO vendas (valor, data, cliente_fk) VALUES (?, ?, ?)";
			
			stmt = con.prepareStatement(realizarVenda);
			stmt.setDouble(1, venda.getValor());;
			Date dataSqlVenda = Date.valueOf(venda.getData());
			stmt.setDate(2, dataSqlVenda);
			String nomeCliente = venda.getCliente().getNome();
			stmt.setString(3, nomeCliente);
			
			stmt.execute();
			
			dadosCliente.atualizarDebitoClientes(venda.getValor(), nomeCliente);
			
		} catch (ExcecaoDados e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao realizar venda");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fecharStatement();
			fecharConexao();
		}
		
		
	}
	
	public ArrayList<Venda> buscarVendasCliente(String nomeCliente) throws ExcecaoDados {
		
		ArrayList<Venda> vendasCliente = new ArrayList<Venda>();
		Cliente cliente = new Cliente(nomeCliente);
		
		try {
			con = new ConexaoBd().getConnection();
			String buscarVendas = "SELECT * FROM vendas WHERE cliente_fk = ?";
			stmt = con.prepareStatement(buscarVendas);
			stmt.setString(1, nomeCliente);
			
			result = stmt.executeQuery();
			
			while(result.next()) {
					
				double valor = result.getDouble("valor");
				Date dataSql = result.getDate("data");
				java.util.Date utilDate = new java.util.Date(dataSql.getTime());
				LocalDate dataVenda = LocalDate.ofInstant(utilDate.toInstant(), ZoneId.systemDefault());
				Venda venda = new Venda(valor, dataVenda, cliente);
				vendasCliente.add(venda);
				
			}
			
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fecharStatement();
			fecharConexao();
		}
		
		return vendasCliente;
	}
	
	
	
}
