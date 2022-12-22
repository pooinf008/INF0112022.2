package br.ifba.edu.aval1.q1.portugol;

import br.ifba.edu.aval1.model.Algoritmo;
import br.ifba.edu.aval1.model.Bloco;

public class PortugolAlgoritmo extends Algoritmo{
	
	public PortugolAlgoritmo(Bloco main) {
		super(main);
	}

	@Override
	public String getValor() {
		String valor = "Principal()\n" + this.main.getValor();
		return valor;
	}	

}
