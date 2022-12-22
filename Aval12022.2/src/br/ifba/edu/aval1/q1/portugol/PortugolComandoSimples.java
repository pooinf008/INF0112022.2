package br.ifba.edu.aval1.q1.portugol;

import br.ifba.edu.aval1.model.ComandoSimples;

public class PortugolComandoSimples extends ComandoSimples {

	public PortugolComandoSimples(String valor) {
		super(valor);
	}

	@Override
	public String getValor() {
		return this.valor;
	}

}
