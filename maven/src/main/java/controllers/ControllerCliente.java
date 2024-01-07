package controllers;

import java.util.ArrayList;

import data.ExcecaoDados;
import data.dataCliente;
import models.Cliente;

public class ControllerCliente {
	
	private dataCliente dados;
	
	
	public  Cliente cadastrarCliente(String nome, String telefone, String email) throws ExcecaoControladores {
		 dados = new dataCliente();
		
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
		dados = new dataCliente();
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

}
