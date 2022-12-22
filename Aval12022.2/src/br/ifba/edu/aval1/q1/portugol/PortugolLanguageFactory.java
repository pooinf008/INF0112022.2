package br.ifba.edu.aval1.q1.portugol;

import br.ifba.edu.aval1.model.Algoritmo;
import br.ifba.edu.aval1.model.Bloco;
import br.ifba.edu.aval1.model.Comando;
import br.ifba.edu.aval1.model.ComandoSimples;
import br.ifba.edu.aval1.model.Repeticao;
import br.ifba.edu.aval1.model.Selecao;
import br.ifba.edu.aval1.q1.AbstractLanguageFactory;

public class PortugolLanguageFactory implements AbstractLanguageFactory{

	@Override
	public Algoritmo createAlgoritmo(Bloco bloco) {
		return new PortugolAlgoritmo(bloco);
	}

	@Override
	public Bloco createBloco() {
		return new PortugolBloco();
	}

	@Override
	public Selecao createSelecao(ComandoSimples condicao, Comando comandoPositivo) {
		return new PortugolSelecao(condicao, comandoPositivo);
	}

	@Override
	public Selecao createSelecao(ComandoSimples condicao, Comando comandoPositivo, Comando comandoNegativo) {
		return new PortugolSelecao(condicao, comandoPositivo, comandoNegativo);
	}

	@Override
	public Repeticao createRepeticao(ComandoSimples condicao, Comando comando) {
		return new PortugolRepeticao(condicao, comando);
	}

	@Override
	public ComandoSimples createComandoSimples(String comando) {
		return new PortugolComandoSimples(comando);
	}
	
	@Override
	public ComandoSimples createCondicao(String comando) {
		return new PortugolCondicao(comando);
	}	

}
