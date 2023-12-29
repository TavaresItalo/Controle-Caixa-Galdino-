package models;

public class Venda {
	
	private double valor;
	private String data;
	private int id;
	private Cliente cliente;
	
	public Venda(double valor, String data, int id, Cliente cliente) {
		super();
		this.valor = valor;
		this.data = data;
		this.id = id;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
