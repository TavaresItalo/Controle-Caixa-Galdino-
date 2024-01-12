package controllers;

import data.DataAdmin;
import data.ExcecaoDados;

public class ControllerAdministrador {
	
	private DataAdmin dados = new DataAdmin();
	
	public void realizarLogin(String login, char[] senha) throws ExcecaoControladores {
		
		String stringSenha= "";
		
		for (char caractere : senha) {
			stringSenha = stringSenha + caractere;
		}
		
		if(login.isBlank()) {
			throw new ExcecaoControladores("O login não pode estra em branco.");
		}
		
		if(stringSenha.isBlank()) {
			throw new ExcecaoControladores("A senha não pode estar em branco.");
		}
		
		if(stringSenha.length() < 8) {
			throw new ExcecaoControladores("A senha não pode ter menos de 8 caracteres.");
		}
		
		try {
			if(!dados.buscarSenhaAdministrador(stringSenha)) {
				throw new ExcecaoControladores("Senha incorreta.");
			}
			if(!dados.buscarLoginAdministrador(login)) {
				throw new ExcecaoControladores("Login incorreto.");
			}
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
	

