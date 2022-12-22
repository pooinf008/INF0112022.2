package br.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class FichaCadastral {
	private String nome;
	private String matricula;
	private String cpf;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;
	private Cargo cargo;

	public FichaCadastral(String nome, String matricula, String cpf, BigDecimal salario, LocalDate dataUltimoReajuste, Cargo cargo) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.salario = salario;
		this.dataUltimoReajuste = dataUltimoReajuste;
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FichaCadastral other = (FichaCadastral) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(matricula, other.matricula);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}	
	
	
	
}
