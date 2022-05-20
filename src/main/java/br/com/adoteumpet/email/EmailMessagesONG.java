package br.com.adoteumpet.email;

import br.com.adoteumpet.entities.ONG;

public class EmailMessagesONG {
	
	public static String createTitle(ONG ong) {
		return ong.getNomeFantasia() + " seu cadastro foi recebido!";
		
	}
	
	
	public static String messageToNewONG(ONG ong ) {
		
		return "<div><h2>Olá " + ong.getNomeFantasia() + "! Seja muito bem-vindo(a) ao AdoteUmPet.</h2>"
				+ "Os seus dados estão logo abaixo.</div>"
				+"<br>"
				+"<div>================================</div>"
				+"<div>Nome: <strong>"+ong.getNomeFantasia() + "</strong></div>"
				+"<div>Email: <strong>"+ong.getEmail() + "</strong></div>"
				+"<div>Telefone: <strong>"+ong.getTelefone() + "</strong></div>"
				+"<div>Login: <strong>"+ong.getLogin() + "</strong></div>"
				+"<div>Senha: <strong>"+ong.getSenha() + "</strong></div>"
						
				
				//+"<div>Endereco: Rua: <strong>"+usuario.getEndereco().getLogradouro() + "</strong></div>"
				+"<div> ================================= </div>";
				
	}

}
