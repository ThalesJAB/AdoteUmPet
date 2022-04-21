package br.com.adoteumpet.dtos;

import java.io.Serializable;
import java.util.Objects;

import br.com.adoteumpet.entities.Endereco;
import br.com.adoteumpet.entities.ONG;

public class ONGDTO implements Serializable, Comparable<ONGDTO> {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private String email;
	private String biografia;
	private Endereco endereco;

	private byte[] imagem;
	private Boolean status;

	public ONGDTO() {

	}

	public ONGDTO(ONG obj) {
		this.id = obj.getId();
		this.razaoSocial = obj.getRazaoSocial();
		this.nomeFantasia = obj.getNomeFantasia();
		this.cnpj = obj.getCnpj();
		this.email = obj.getEmail();
		this.biografia = obj.getBiografia();
		this.endereco = obj.getEndereco();
		this.imagem = obj.getImagem();
		this.status = obj.getStatus();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
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
		ONGDTO other = (ONGDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int compareTo(ONGDTO outraOng) {
		// return this.id.compareTo(outraOng.id);
		int returnValue = 0;
		if (this.id > outraOng.id) {
			returnValue = 1;
			
		} else if (this.id < outraOng.id) {
			returnValue = -1;
			
		} else if (this.id == outraOng.id) {
			returnValue = 0;
		}
		
		return returnValue;
	}

	@Override
	public String toString() {
		return "ONGDTO [id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + "]\n";
	}

}
