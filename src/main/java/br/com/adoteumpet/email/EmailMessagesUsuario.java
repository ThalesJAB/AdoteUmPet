package br.com.adoteumpet.email;

import br.com.adoteumpet.entities.Usuario;

public class EmailMessagesUsuario {
	
	public static String createTitle(Usuario usuario) {
		return usuario.getNome() + " seu cadastro foi recebido!";
		
	}
	
	
	public static String messageToNewUser(Usuario usuario) {
		
		return "<div><h2>Olá " + usuario.getNome() + "! Seja muito bem-vindo(a) ao AdoteUmPet.</h2>"
				+ "Os seus dados estão logo abaixo.</div>"
				+"<br>"
				+"<div>================================</div>"
				+"<div>Nome: <strong>"+usuario.getNome() + "</strong></div>"
				+"<div>Email: <strong>"+usuario.getEmail() + "</strong></div>"
				+"<div>Telefone: <strong>"+usuario.getTelefone() + "</strong></div>"
				+"<div>Login: <strong>"+usuario.getLogin() + "</strong></div>"
				+"<div>Senha: <strong>"+usuario.getSenha() + "</strong></div>"
						
				
				//+"<div>Endereco: Rua: <strong>"+usuario.getEndereco().getLogradouro() + "</strong></div>"
				+"<div> ================================= </div>";
				
	}

}
