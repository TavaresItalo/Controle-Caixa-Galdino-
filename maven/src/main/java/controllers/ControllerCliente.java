package controllers;

import java.util.ArrayList;

import data.ExcecaoDados;
import data.dataCliente;
import models.Cliente;

public class ControllerCliente {
	
	private dataCliente dados = new dataCliente();
	
	
	public  Cliente cadastrarCliente(String nome, String telefone, String email) throws ExcecaoControladores {
		
		try {
			dados.verificarCliente(nome);
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verificarCampos(nome, telefone, email);
		Cliente cliente = new Cliente(nome, telefone, email);
		
		dados.cadastrarCliente(cliente);
		
		return cliente;
		
	}
	
	
	public void verificarCampos(String nome, String telefone, String email) throws ExcecaoControladores {
		if(nome.isBlank()) {
			throw new ExcecaoControladores("O campo nome não pode ser vazio ");
		}
		
		if(telefone.isBlank()) {
			throw new ExcecaoControladores("O campo telefone não pode ser vazio");
		}
		
		if(telefone.length() != 9) {
			throw new ExcecaoControladores("O telefone deve ter 9 dígitos");
		}
		
		if(!telefone.matches("^[0-9]+$")) {
			throw new ExcecaoControladores("O telefone só pode ter números.");
		}
		
		if(email.isBlank()) {
			throw new ExcecaoControladores("O campo E-mail não pode ser vazio");
		}
		
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z.]+$")) {
			throw new ExcecaoControladores("O campo email deve estar no formato exemplo@exemplo.com");
		}
		
		if(email.length() < 7) {
			throw new ExcecaoControladores("Email inválido");
		}
	}
	
	public ArrayList<String> buscarNomeTodosOsClientes() throws ExcecaoDados {
		ArrayList<String> clientes = new ArrayList<>();
		
		try {
			clientes = dados.buscarNomesTodosOsClientes();
		} catch (ExcecaoDados e) {
			e.printStackTrace();
			throw new ExcecaoDados("Erro ao buscar leitores no banco de dados");
		} 
		
		return clientes;
	}
	
	public Cliente buscarClientePorNome(String nome) {
		dados = new dataCliente();
		Cliente cliente = null;
		
		try {
			cliente = dados.buscarClientePorNome(nome);
		} catch (ExcecaoDados e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public void AtualizarDadosCliente(String novoEmail, String novoTelefone, String nomeCliente) throws ExcecaoControladores {
		
		if (!novoEmail.isBlank()) {
			try {
				if (dados.verificarEmail(novoEmail, nomeCliente)) {
					throw new ExcecaoControladores("O email não foi alterado. Digite o novo email.");
				}
				
				dados.atualizarEmailCliente(novoEmail, nomeCliente);
				
			} catch (ExcecaoDados e) {
				
				e.printStackTrace();
			}
		}
		
		if (!novoTelefone.isBlank()) {
			try {
				if(dados.verificarTelefone(novoTelefone, nomeCliente)) {
					throw new ExcecaoControladores("O telefone não foi alterado. Digite o novo telefone");
				}
				
				dados.atualizarTelefoneCliente(novoTelefone, nomeCliente);
			} catch (ExcecaoDados e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (novoEmail.isBlank() && novoTelefone.isBlank()) {
			throw new ExcecaoControladores("Um dos campos email ou telefone deve ser preenchido");
		}
	}
	
	public void excluirCliente(String nomeCliente) throws ExcecaoControladores {
		
		try {
			if(dados.verificarCliente(nomeCliente)) {
				dados.ExcluirCliente(nomeCliente);
			} else {
				throw new ExcecaoControladores("Cliente inexistente");
			}
			
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double buscarDebitoCliente(String nomeCliente) {
		
		double debito = 0;
		
		try {
			debito = dados.buscarDebitoCliente(nomeCliente);
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return debito;
	}
	
	public void realizarPagamento(String nomeCliente) {
		
		try {
			dados.realizarPagamento(nomeCliente);
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int buscarTotalVendas(String nomeCliente) {
		
		int totalVendas = dados.buscarTotalVendas(nomeCliente);
		return totalVendas;
		
	}

}
