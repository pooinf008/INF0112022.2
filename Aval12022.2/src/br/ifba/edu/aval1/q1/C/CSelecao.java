package br.ifba.edu.aval1.q1.C;

import br.ifba.edu.aval1.model.Comando;
import br.ifba.edu.aval1.model.ComandoSimples;
import br.ifba.edu.aval1.model.Selecao;

public class CSelecao extends Selecao{
	
	public CSelecao(ComandoSimples condicao, Comando comandoPositivo) {
		super(condicao, comandoPositivo, null);
	}
	
	public CSelecao(ComandoSimples condicao, Comando comandoPositivo, 
				   Comando comandoNegativo) {
		super(condicao, comandoPositivo, comandoNegativo);
	}

	public String getValor() {
		String valor = "if(" + this.getCondicao().getValor() + ")\n"; 
			   valor += "\t" + this.comandoPositivo.getValor();
		if(this.comandoNegativo != null) {
			valor += "\nelse\n";
			valor += "\t" + this.comandoNegativo.getValor();		
		}
		return valor;
	}	

}
