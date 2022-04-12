package br.com.adoteumpet.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String raca;
	private Integer idade;
	private Double peso;
	private String observacoes;
	private String descricao;
	private byte[] imagem;
	private Boolean adotado;
	private Boolean status;

	
	@ManyToOne
	@JoinColumn(name="ong_id")
	private ONG ong;

	public Animal() {

	}

	public Animal(Long id, String nome, String raca, Integer idade, Double peso, String observacoes, String descricao,
			byte[] imagem, Boolean adotado, Boolean status, ONG ong) {
		super();
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.peso = peso;
		this.observacoes = observacoes;
		this.descricao = descricao;
		this.imagem = imagem;
		this.adotado = adotado;
		this.status = status;
		this.ong = ong;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Boolean getAdotado() {
		return adotado;
	}

	public void setAdotado(Boolean adotado) {
		this.adotado = adotado;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ONG getOng() {
		return ong;
	}

	public void setOng(ONG ong) {
		this.ong = ong;
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
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}


	
}
