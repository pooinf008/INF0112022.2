package br.ifba.edu.aval1.q1.portugol;

import br.ifba.edu.aval1.model.ComandoSimples;

public class PortugolCondicao extends ComandoSimples {

	public PortugolCondicao(String valor) {
		super(valor);
	}

	@Override
	public String getValor() {
		return this.valor;
	}

}
