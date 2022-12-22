package br.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Terceiro implements Reajustavel{

	private String nomeEmpresa;
	
	private FichaCadastral ficha;
	
	public Terceiro(String nome, String matricula, String cpf, BigDecimal salario, LocalDate dataUltimoReajuste, Cargo cargo) {
		super();
		this.ficha = new FichaCadastral(nome, matricula, cpf, salario, dataUltimoReajuste, cargo);
	}
	
	public Terceiro(String nome, String matricula, String cpf, BigDecimal salario) {
		this(nome, matricula, cpf, salario,
			 LocalDate.now(), Cargo.JUNIOR);
	}

	@Override
	public String toString() {
		return "Terceiro [nome=" + ficha.getNome() + ", cargo=" + ficha.getCargo() + 
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
		Terceiro other = (Terceiro) obj;
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

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}


}
