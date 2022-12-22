package br.ifba.inf011.model.visitor;

import br.ifba.inf011.model.NoFusor;
import br.ifba.inf011.model.NoRoteamento;
import br.ifba.inf011.model.TermometroSimples;

public interface TermometroVisitor {
	
	public void visitTermometroSimples(TermometroSimples ts);
	public void visitNoFusor(NoFusor nf);
	public void visitNoRoteamento(NoRoteamento nr);

}
