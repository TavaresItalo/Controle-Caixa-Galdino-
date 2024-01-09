package controllers;

import java.time.LocalDate;

import data.DataVenda;
import data.ExcecaoDados;
import models.Cliente;
import models.Venda;

public class ControllerVendas {

	private DataVenda dados = new DataVenda();
	private ControllerCliente controllerCliente = new ControllerCliente();
	
	public void  realizarVenda(String valor, String data, String nomeCliente) throws ExcecaoControladores {
		
		verificarCamposVenda(valor, data, nomeCliente);
		LocalDate novaData = formatarData(data);
		Cliente cliente = controllerCliente.buscarClientePorNome(nomeCliente);
		double valorVenda = Double.parseDouble(valor);
		
		Venda venda = new Venda(valorVenda, novaData, cliente);
		
		try {
			dados.realizarVenda(venda);
		} catch (ExcecaoDados e) {
			e.printStackTrace();
		}	
		
	}
	
	public void verificarCamposVenda(String valor, String data, String nomeCliente ) throws ExcecaoControladores {
		
		if(valor.isBlank()) {
			throw new ExcecaoControladores("O campo valor não pode ser vazio.");
		}
		if(valor.matches("^[0-9]+$")) {
			throw new ExcecaoControladores("O campo não pode conter letras.");
		}
		if(valor.contains(",")) {
			throw new ExcecaoControladores("O valor deve estar no formato ##.###, não pode possuir vírgulas.");
		}
		if(data.isBlank()) {
			throw new ExcecaoControladores("O campo data não pode ser vazio.");
		}
		if(nomeCliente.isBlank()) {
			throw new ExcecaoControladores("O campo cliente não pode ser vazio.");
		}
	}
	
	public LocalDate formatarData(String data) {
		String[] dataSeparada = data.split("/");
		
		LocalDate novaData = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]), Integer.parseInt(dataSeparada[0]));
		
		return novaData;
	}
	
	
	
}
