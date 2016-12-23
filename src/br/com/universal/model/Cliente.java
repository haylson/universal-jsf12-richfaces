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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7717394165336346316L;

	@Id
	@GeneratedValue(generator="sequence", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="sequence", sequenceName = "cliente_id_seq", allocationSize = 1)
	private Long id;
	
	//TODO
	//Deixamos EAGER nesse caso, devido a dependencia de cliente com pessoa. Todo cliente tem necessariamente
	//uma pessoa. Resolvendo o problema da DataTable, mas preferencial usar LAZY.
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	@Column(length = 60)
	private String nomePai;
	
	@Column(length = 60)
	private String nomeMae;
	
	@Column(nullable = false, length = 60)
	private String nomePessoaReferencia;
	
	@Column(nullable = false, length = 30)
	private String familiariedadePessoaReferencia;
	
	@Column(nullable = false, length = 10)
	private String fonePessoaReferencia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Promotor promotor;
	
	@Column(nullable = false)
	private Boolean ativo;
	
	public Cliente(){
		this.ativo = true;
		this.promotor = new Promotor();
		this.pessoa = new Pessoa();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePessoaReferencia() {
		return nomePessoaReferencia;
	}

	public void setNomePessoaReferencia(String nomePessoaReferencia) {
		this.nomePessoaReferencia = nomePessoaReferencia;
	}

	public String getFamiliariedadePessoaReferencia() {
		return familiariedadePessoaReferencia;
	}

	public void setFamiliariedadePessoaReferencia(
			String familiariedadePessoaReferencia) {
		this.familiariedadePessoaReferencia = familiariedadePessoaReferencia;
	}

	public String getFonePessoaReferencia() {
		return fonePessoaReferencia;
	}

	public void setFonePessoaReferencia(String fonePessoaReferencia) {
		this.fonePessoaReferencia = fonePessoaReferencia;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void setPromotor(Promotor promotor) {
		this.promotor = promotor;
	}

	public Promotor getPromotor() {
		return promotor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime
				* result
				+ ((familiariedadePessoaReferencia == null) ? 0
						: familiariedadePessoaReferencia.hashCode());
		result = prime
				* result
				+ ((fonePessoaReferencia == null) ? 0 : fonePessoaReferencia
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeMae == null) ? 0 : nomeMae.hashCode());
		result = prime * result + ((nomePai == null) ? 0 : nomePai.hashCode());
		result = prime
				* result
				+ ((nomePessoaReferencia == null) ? 0 : nomePessoaReferencia
						.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result
				+ ((promotor == null) ? 0 : promotor.hashCode());
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
		Cliente other = (Cliente) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (familiariedadePessoaReferencia == null) {
			if (other.familiariedadePessoaReferencia != null)
				return false;
		} else if (!familiariedadePessoaReferencia
				.equals(other.familiariedadePessoaReferencia))
			return false;
		if (fonePessoaReferencia == null) {
			if (other.fonePessoaReferencia != null)
				return false;
		} else if (!fonePessoaReferencia.equals(other.fonePessoaReferencia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeMae == null) {
			if (other.nomeMae != null)
				return false;
		} else if (!nomeMae.equals(other.nomeMae))
			return false;
		if (nomePai == null) {
			if (other.nomePai != null)
				return false;
		} else if (!nomePai.equals(other.nomePai))
			return false;
		if (nomePessoaReferencia == null) {
			if (other.nomePessoaReferencia != null)
				return false;
		} else if (!nomePessoaReferencia.equals(other.nomePessoaReferencia))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (promotor == null) {
			if (other.promotor != null)
				return false;
		} else if (!promotor.equals(other.promotor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [ativo=" + ativo + ", familiariedadePessoaReferencia="
				+ familiariedadePessoaReferencia + ", fonePessoaReferencia="
				+ fonePessoaReferencia + ", id=" + id + ", nomeMae=" + nomeMae
				+ ", nomePai=" + nomePai + ", nomePessoaReferencia="
				+ nomePessoaReferencia + ", pessoa=" + pessoa + ", promotor="
				+ promotor + "]";
	}
	
}
