package br.ifba.inf011.solid.exception;

import java.math.BigDecimal;

public class RHException extends Exception {
	private BigDecimal indiceTentado;
	private String mensagemErro;
	
	public RHException(String mensagemErro, BigDecimal indiceTentado) {
		this.mensagemErro = mensagemErro;
		this.indiceTentado = indiceTentado;
	}

	@Override
	public String toString() {
		return "RHException [indiceTentado=" + indiceTentado + ", mensagemErro=" + mensagemErro + "]";
	}
	
	

}
