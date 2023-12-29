package models;

public class Cliente {
	
	private String nome;
	private String email;
	private String telefone;
	private int id;
	
	public Cliente(String nome, String email, String telefone, int id) {	
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}