package br.ifba.inf011.modelo.bridge;

import br.ifba.inf011.modelo.Album;
import br.ifba.inf011.modelo.Livro;
import br.ifba.inf011.modelo.visitor.ObraVisitor;

public class FullFormattedVisitor extends AbstractFormattedVisitor implements ObraVisitor{
	
	public FullFormattedVisitor(Formatter formatter) {
		super(formatter);
	}	
	
	@Override
	public void visit(Livro livro) {
		this.formatter.comment(livro.getTitulo());
		this.formatter.bold(livro.getTitulo());
		this.formatter.italic(livro.getAutor() + " (" + livro.getAno() + ")");
		this.formatter.standard("Editora: " + livro.getEditora() + "\n");
		this.formatter.standard("Numero de Páginas: " + livro.getNumeroPaginas() + "\n");
		this.formatter.standard("Avaliação: " + livro.getAvaliacao() + "\n");
		this.formatter.standard("\n");
	}

	@Override
	public void visit(Album album) {
		this.formatter.comment(album.getTitulo());
		this.formatter.bold(album.getTitulo());
		this.formatter.italic(album.getAutor() + " " + album.getAno());
		this.formatter.standard("Gravadora: " + album.getGravadora() + "\n");
		this.formatter.standard("Estúdio: " + album.getEstudio() + "\n");
		this.formatter.standard("Avaliação: " + album.getAvaliacao() + "\n");
		this.formatter.standard("\n");		
	}

}
