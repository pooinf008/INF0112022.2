package br.ifba.inf011.modelo.bridge;

import br.ifba.inf011.modelo.Album;
import br.ifba.inf011.modelo.Livro;
import br.ifba.inf011.modelo.visitor.ObraVisitor;

public class SummaryFormattedVisitor extends AbstractFormattedVisitor implements ObraVisitor{
	
	public SummaryFormattedVisitor(Formatter formatter) {
		super(formatter);
	}	
	


	@Override
	public void visit(Livro livro) {
		this.formatter.comment(livro.getTitulo());
		this.formatter.bold(livro.getTitulo());
		this.formatter.italic(livro.getAutor() + " (" + livro.getAno() + ")");
		this.formatter.standard("\n");
	}

	@Override
	public void visit(Album album) {
		this.formatter.comment(album.getTitulo());
		this.formatter.bold(album.getTitulo());
		this.formatter.italic(album.getAutor() + " " + album.getAno());
		this.formatter.standard("\n");		
	}	
	
}
