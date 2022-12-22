package br.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario implements Trabalhador {
	
	private FichaCadastral ficha;
	
	public Funcionario(String nome, String matricula, String cpf, BigDecimal salario, LocalDate dataUltimoReajuste, Cargo cargo) {
		super();
		this.ficha = new FichaCadastral(nome, matricula, cpf, salario, dataUltimoReajuste, cargo);
	}
	
	public Funcionario(String nome, String matricula, String cpf, BigDecimal salario) {
		this(nome, matricula, cpf, salario,
			 LocalDate.now(), Cargo.JUNIOR);
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + ficha.getNome() + ", cargo=" + ficha.getCargo() + 
				", matricula=" + ficha.getMatricula() + ", cpf=" + ficha.getCpf() + ", salario=" + 
				ficha.getSalario()
				+ ", dataUltimoReajuste=" + 
				ficha.getDataUltimoReajuste() + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ficha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(ficha, other.ficha);
	}

	public BigDecimal getSalario() {
		return this.ficha.getSalario();
	}

	public void setSalario(BigDecimal salario) {
		this.ficha.setSalario(salario); 
	}
	
	public void reajustar(BigDecimal indice) {
		BigDecimal salarioOriginal = this.getSalario();
		BigDecimal aumento = salarioOriginal.multiply(indice);
		BigDecimal salarioReajustado = salarioOriginal.add(aumento);
		this.setSalario(salarioReajustado);
		this.ficha.setDataUltimoReajuste(LocalDate.now());
	}

	public Cargo getCargo() {
		return this.ficha.getCargo();
	}

	public void setCargo(Cargo proximo) {
		this.ficha.setCargo(proximo);
	}

	public void promover(Cargo cargoNovo) {
		this.setCargo(cargoNovo);
	}
	

}
