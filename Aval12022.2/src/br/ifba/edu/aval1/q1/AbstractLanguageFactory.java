package br.ifba.edu.aval1.q1;

import br.ifba.edu.aval1.model.Algoritmo;
import br.ifba.edu.aval1.model.Bloco;
import br.ifba.edu.aval1.model.Comando;
import br.ifba.edu.aval1.model.ComandoSimples;
import br.ifba.edu.aval1.model.Repeticao;
import br.ifba.edu.aval1.model.Selecao;

public interface AbstractLanguageFactory {

	public Algoritmo createAlgoritmo(Bloco bloco);
	public Bloco createBloco();
	public Selecao createSelecao(ComandoSimples condicao, Comando comandoPositivo);
	public Selecao createSelecao(ComandoSimples condicao, Comando comandoPositivo, 
								 Comando comandoNegativo);
	public Repeticao createRepeticao(ComandoSimples condicao, Comando comando);
	public ComandoSimples createComandoSimples(String comando);
	public ComandoSimples createCondicao(String comando);
}
