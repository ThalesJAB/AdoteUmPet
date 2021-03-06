package br.com.adoteumpet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.adoteumpet.dtos.ONGDTO;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private String email;
	private String nome;
	private String cpf;
	private String telefone;
	private String biografia;
	private String imagem;

	@OneToOne
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;

	
	@ManyToMany
	@JoinTable(name = "ongs_favoritas_usuario", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "ong_id"))
	private List<ONG> ongsFavoritas = new ArrayList<>();
	

	@OneToMany(mappedBy = "usuario")
	private List<PlanoUsuarioFiliado> planosUsuario = new ArrayList<>();
	
	

	private Boolean status;

	public Usuario() {

	}

	public Usuario(Long id, String login, String senha, String email, String nome, String cpf, String telefone,
			String biografia, String imagem, Endereco endereco, Boolean status) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.biografia = biografia;
		this.imagem = imagem;
		this.endereco = endereco;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<ONGDTO> getOngsFavoritas() {
		List<ONGDTO> ongsDTO = this.ongsFavoritas.stream().map(obj -> new ONGDTO(obj)).collect(Collectors.toList());
		return ongsDTO;
	}
	
	public void addOngsFavoritas(ONG ong) {
		this.ongsFavoritas.add(ong);
	}

	public List<PlanoUsuarioFiliado> getPlanosUsuario() {
		return this.planosUsuario;
	}

	public void addPlanosUsuario(PlanoUsuarioFiliado ongFiliada) {
		this.planosUsuario.add(ongFiliada);
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
