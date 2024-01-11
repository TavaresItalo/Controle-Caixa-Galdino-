package controllers;

import data.DataAdmin;
import data.ExcecaoDados;

public class ControllerAdministrador {
	
	private DataAdmin dados = new DataAdmin();
	
	public boolean realizarLogin(String login, char[] senha) throws ExcecaoControladores {
		
		boolean resultado = false;
		String stringSenha= "";
		
		for (char caractere : senha) {
			stringSenha = stringSenha + caractere;
		}
		
		try {
			verificarCamposLogin(login, stringSenha);
			
			String loginAdmin = dados.buscarLoginAdministrador();
			String senhaAdmin = dados.buscarSenhaAdministrador();
			
			if (login.matches(loginAdmin) && stringSenha.matches(senhaAdmin)) {
				resultado = true;
			} else {
				throw new ExcecaoControladores("E-mail ou senha incorretos ");
			}
			
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcecaoControladores e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public void verificarCamposLogin(String login, String senha) throws ExcecaoControladores {
		
		if(login.isBlank()) {
			throw new ExcecaoControladores("O campo login não pode ser vazio");
		}
		if(senha.isBlank()) {
			throw new ExcecaoControladores("O campo senha não pode ser vazio");
		}
		if(senha.length() < 8) {
			throw new ExcecaoControladores("A senha deve ter 8 caracteres");
		}
	}

}
