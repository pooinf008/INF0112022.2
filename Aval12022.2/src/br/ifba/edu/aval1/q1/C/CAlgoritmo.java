package br.ifba.edu.aval1.q1.C;

import br.ifba.edu.aval1.model.Algoritmo;
import br.ifba.edu.aval1.model.Bloco;

public class CAlgoritmo extends Algoritmo{
	
	public CAlgoritmo(Bloco main) {
		super(main);
	}

	@Override
	public String getValor() {
		String valor = "main()\n" + this.main.getValor();
		return valor;
	}	

}
