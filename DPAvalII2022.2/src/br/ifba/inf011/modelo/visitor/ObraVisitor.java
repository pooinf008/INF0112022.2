package br.ifba.inf011.modelo.visitor;

import br.ifba.inf011.modelo.Album;
import br.ifba.inf011.modelo.Livro;

public interface ObraVisitor {
	
	public void clear();
	
	public void visit(Livro livro);
	public void visit(Album album);
	
	public String getCode();
	
}
