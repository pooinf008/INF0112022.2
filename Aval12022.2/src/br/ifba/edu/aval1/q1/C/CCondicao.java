package br.ifba.edu.aval1.q1.C;

import br.ifba.edu.aval1.model.ComandoSimples;

public class CCondicao extends ComandoSimples {

	public CCondicao(String valor) {
		super(valor);
	}

	@Override
	public String getValor() {
		return this.valor;
	}

}
