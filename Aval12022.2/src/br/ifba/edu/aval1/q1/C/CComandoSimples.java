package br.ifba.edu.aval1.q1.C;

import br.ifba.edu.aval1.model.ComandoSimples;

public class CComandoSimples extends ComandoSimples {

	public CComandoSimples(String valor) {
		super(valor);
	}

	@Override
	public String getValor() {
		return this.valor + ";";
	}

}
