package br.com.universal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.universal.model.enumeration.TipoPessoa;

@Entity
public class Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8907711014386410395L;

	@Id
	@GeneratedValue(generator="sequence", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="sequence", sequenceName = "pessoa_id_seq", allocationSize = 1)
	private Long id;

	@Column(nullable = false, length = 60)
	private String nome;
	
	@Embedded
	private Endereco endereco;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false,length = 10)
	private TipoPessoa tipoPessoa;
	
	@Column(nullable = false, length = 14)
	private String cpfCnpj;
	
	@Column(length = 15)
	private String rg;
	
	@Column(length = 10)
	private String foneResidencial;
	
	@Column(length = 10)
	private String foneComercial;
	
	@Column(length = 10)
	private String foneCelular1;
	
	@Column(length = 10)
	private String foneCelular2;
	
	@Column(length = 60)
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataDeCadastro;
	
	private String observacao;

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getFoneResidencial() {
		return foneResidencial;
	}

	public void setFoneResidencial(String foneResidencial) {
		this.foneResidencial = foneResidencial;
	}

	public String getFoneComercial() {
		return foneComercial;
	}

	public void setFoneComercial(String foneComercial) {
		this.foneComercial = foneComercial;
	}

	public String getFoneCelular1() {
		return foneCelular1;
	}

	public void setFoneCelular1(String foneCelular1) {
		this.foneCelular1 = foneCelular1;
	}

	public String getFoneCelular2() {
		return foneCelular2;
	}

	public void setFoneCelular2(String foneCelular2) {
		this.foneCelular2 = foneCelular2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getObservacao() {
		return observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
		result = prime * result
				+ ((dataDeCadastro == null) ? 0 : dataDeCadastro.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((foneCelular1 == null) ? 0 : foneCelular1.hashCode());
		result = prime * result
				+ ((foneCelular2 == null) ? 0 : foneCelular2.hashCode());
		result = prime * result
				+ ((foneComercial == null) ? 0 : foneComercial.hashCode());
		result = prime * result
				+ ((foneResidencial == null) ? 0 : foneResidencial.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result
				+ ((tipoPessoa == null) ? 0 : tipoPessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cpfCnpj == null) {
			if (other.cpfCnpj != null)
				return false;
		} else if (!cpfCnpj.equals(other.cpfCnpj))
			return false;
		if (dataDeCadastro == null) {
			if (other.dataDeCadastro != null)
				return false;
		} else if (!dataDeCadastro.equals(other.dataDeCadastro))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (foneCelular1 == null) {
			if (other.foneCelular1 != null)
				return false;
		} else if (!foneCelular1.equals(other.foneCelular1))
			return false;
		if (foneCelular2 == null) {
			if (other.foneCelular2 != null)
				return false;
		} else if (!foneCelular2.equals(other.foneCelular2))
			return false;
		if (foneComercial == null) {
			if (other.foneComercial != null)
				return false;
		} else if (!foneComercial.equals(other.foneComercial))
			return false;
		if (foneResidencial == null) {
			if (other.foneResidencial != null)
				return false;
		} else if (!foneResidencial.equals(other.foneResidencial))
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
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (tipoPessoa == null) {
			if (other.tipoPessoa != null)
				return false;
		} else if (!tipoPessoa.equals(other.tipoPessoa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [cpfCnpj=" + cpfCnpj + ", dataDeCadastro="
				+ dataDeCadastro + ", dataNascimento=" + dataNascimento
				+ ", email=" + email + ", endereco=" + endereco
				+ ", foneCelular1=" + foneCelular1 + ", foneCelular2="
				+ foneCelular2 + ", foneComercial=" + foneComercial
				+ ", foneResidencial=" + foneResidencial + ", id=" + id
				+ ", nome=" + nome + ", observacao=" + observacao + ", rg="
				+ rg + ", tipoPessoa=" + tipoPessoa + "]";
	}

}