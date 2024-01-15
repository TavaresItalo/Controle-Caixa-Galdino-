package models;

public class Cliente {
	
	private String nome;
	private String email;
	private String telefone;
	private double total_debito;
	private int total_vendas;
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public Cliente(String nome, String telefone, String email) {	
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.total_debito = 0;
		this.total_vendas = 0;
	}

	public Cliente() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getTotal_debito() {
		return total_debito;
	}

	public void setTotal_debito(double total_debito) {
		this.total_debito = total_debito;
	}

	public int getTotal_vendas() {
		return total_vendas;
	}

	public void setTotal_vendas(int total_vendas) {
		this.total_vendas = total_vendas;
	}
	
	

	
	
	
	
	
}
