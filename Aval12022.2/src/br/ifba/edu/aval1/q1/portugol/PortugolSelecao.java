package br.ifba.edu.aval1.q1.portugol;

import br.ifba.edu.aval1.model.Comando;
import br.ifba.edu.aval1.model.ComandoSimples;
import br.ifba.edu.aval1.model.Selecao;

public class PortugolSelecao extends Selecao{
	
	public PortugolSelecao(ComandoSimples condicao, Comando comandoPositivo) {
		super(condicao, comandoPositivo, null);
	}
	
	public PortugolSelecao(ComandoSimples condicao, Comando comandoPositivo, 
				   Comando comandoNegativo) {
		super(condicao, comandoPositivo, comandoNegativo);
	}

	public String getValor() {
		String valor = "Se(" + this.getCondicao().getValor() + ")\n"; 
			   valor += "\t" + this.comandoPositivo.getValor();
		if(this.comandoNegativo != null) {
			valor += "\nSenão\n";
			valor += "\t" + this.comandoNegativo.getValor();		
		}
		return valor;
	}	

}
