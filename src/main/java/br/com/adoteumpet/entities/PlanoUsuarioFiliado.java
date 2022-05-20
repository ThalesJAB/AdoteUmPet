package br.com.adoteumpet.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.adoteumpet.dtos.ONGDTO;
import br.com.adoteumpet.dtos.UsuarioDTO;

@Entity
public class PlanoUsuarioFiliado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="ong_id")
	private ONG ong;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data;
	private Double valor;
	private Integer tempo;
	private Boolean status;

	public PlanoUsuarioFiliado() {

	}

	public PlanoUsuarioFiliado(Integer id, ONG ong, Usuario usuario, Instant data, Double valor, Integer tempo, Boolean status) {
		super();
		this.id = id;
		this.ong = ong;
		this.usuario = usuario;
		this.data = data;
		this.valor = valor;
		this.tempo = tempo;
		this.status = status;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ONGDTO getOng() {
		ONGDTO ongDto = new ONGDTO(this.ong);
		return ongDto;
	}

	public void setOng(ONG ong) {
		this.ong = ong;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public UsuarioDTO getUsuario() {
		UsuarioDTO usuarioDto = new UsuarioDTO(this.usuario);
		return usuarioDto;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
		PlanoUsuarioFiliado other = (PlanoUsuarioFiliado) obj;
		return Objects.equals(id, other.id);
	}

}
