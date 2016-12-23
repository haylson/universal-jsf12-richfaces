package br.com.universal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.com.universal.model.enumeration.TipoPessoa;

@Entity
public class Promotor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3949756795653810601L;

	@Id
	@GeneratedValue(generator="sequence", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="sequence", sequenceName = "promotor_id_seq", allocationSize = 1)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	@Column(nullable = false)
	private Boolean ativo;
	
	public Promotor(){
		this.ativo = true;
		this.pessoa = new Pessoa();
		this.pessoa.setTipoPessoa(TipoPessoa.valueOf("FISICA"));
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		Promotor other = (Promotor) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Promotor [ativo=" + ativo + ", id=" + id + ", pessoa=" + pessoa
				+ "]";
	}
	
}
