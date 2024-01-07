package models;

public class Cliente {
	
	private String nome;
	private String email;
	private String telefone;
	
	public Cliente(String nome, String telefone, String email) {	
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
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

	
	
	
	
	
}
