package br.ifba.edu.aval1.q1.portugol;

import br.ifba.edu.aval1.model.Comando;
import br.ifba.edu.aval1.model.ComandoSimples;
import br.ifba.edu.aval1.model.Repeticao;

public class PortugolRepeticao extends Repeticao{

	public PortugolRepeticao(ComandoSimples condicao, Comando comando) {
		super(condicao, comando);
	}

	@Override
	public String getValor() {
		String valor = "Enquanto(" + this.getCondicao().getValor() + ")\n";
		       valor += "\t" + this.comando.getValor() + ";";  
		return valor;
	}
	
	

	
	
}
