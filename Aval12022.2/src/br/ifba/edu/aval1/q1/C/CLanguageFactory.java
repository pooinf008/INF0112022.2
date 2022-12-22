package br.ifba.edu.aval1.q1.C;

import br.ifba.edu.aval1.model.Algoritmo;
import br.ifba.edu.aval1.model.Bloco;
import br.ifba.edu.aval1.model.Comando;
import br.ifba.edu.aval1.model.ComandoSimples;
import br.ifba.edu.aval1.model.Repeticao;
import br.ifba.edu.aval1.model.Selecao;
import br.ifba.edu.aval1.q1.AbstractLanguageFactory;

public class CLanguageFactory implements AbstractLanguageFactory{

	@Override
	public Algoritmo createAlgoritmo(Bloco bloco) {
		return new CAlgoritmo(bloco);
	}

	@Override
	public Bloco createBloco() {
		return new CBloco();
	}

	@Override
	public Selecao createSelecao(ComandoSimples condicao, Comando comandoPositivo) {
		return new CSelecao(condicao, comandoPositivo);
	}

	@Override
	public Selecao createSelecao(ComandoSimples condicao, Comando comandoPositivo, Comando comandoNegativo) {
		return new CSelecao(condicao, comandoPositivo, comandoNegativo);
	}

	@Override
	public Repeticao createRepeticao(ComandoSimples condicao, Comando comando) {
		return new CRepeticao(condicao, comando);
	}

	@Override
	public ComandoSimples createComandoSimples(String comando) {
		return new CComandoSimples(comando);
	}
	
	@Override
	public ComandoSimples createCondicao(String comando) {
		return new CCondicao(comando);
	}	

}
