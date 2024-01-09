package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Cliente;
import models.Venda;

public class DataVenda {
	private Connection con = null;
	private PreparedStatement stmt;
	
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
}
