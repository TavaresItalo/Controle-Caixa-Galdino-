package models;

import java.sql.Date;
import java.time.LocalDate;

public class Venda {
	
	private double valor;
	private LocalDate  data;
	private Cliente cliente;
	
	public Venda(double valor, LocalDate data, Cliente cliente) {
		super();
		this.valor = valor;
		this.data = data;
		this.cliente = cliente;
	}

	public Venda() {
		super();
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
