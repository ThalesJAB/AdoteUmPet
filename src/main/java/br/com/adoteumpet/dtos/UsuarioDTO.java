package br.com.adoteumpet.dtos;

import java.io.Serializable;

import br.com.adoteumpet.entities.Usuario;

public class UsuarioDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String nome;
	private String telefone;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Usuario obj) {
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.nome = obj.getNome();
		this.telefone = obj.getTelefone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
