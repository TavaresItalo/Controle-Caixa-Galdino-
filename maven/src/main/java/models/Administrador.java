package models;

public class Administrador {
	
	private String login;
	private String password;
	
	public Administrador(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public Administrador() {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
