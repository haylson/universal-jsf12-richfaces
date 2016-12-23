package br.com.universal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6186534903189951907L;

	@Id
	@GeneratedValue(generator="sequence", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="sequence", sequenceName = "cidade_id_seq", allocationSize = 1)
	private Long id;
	
	@Column(nullable=false, length=40)
	private String nome;
	
	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Estado estado;
	
	public Cidade(){
		super();
	}
	
	public Cidade(Long id, String nome, Long idEstado, String nomeEstado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = new Estado(idEstado, nomeEstado);
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [estado=" + estado + ", id=" + id + ", nome=" + nome
				+ "]";
	}
	
}