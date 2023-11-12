package br.ifba.inf011.modelo.visitor;

import br.ifba.inf011.modelo.Album;
import br.ifba.inf011.modelo.Livro;

public class JSonVisitor implements ObraVisitor{

	private String code;
	
	
	public JSonVisitor() {
		this.clear();
	}	
	
	
	@Override
	public void visit(Livro livro) {
		this.code += "{\n";
		this.code += "\t\"titulo\" : \"" + livro.getTitulo() + "\",\n";
		this.code += "\t\"avaliacao\" : " + livro.getAvaliacao() + ",\n";
		this.code += "\t\"editora\" : " + livro.getEditora() + ",\n";
		this.code += "\t\"idioma\" : " + livro.getIdioma() + ",\n";
		this.code += "\t\"autor\" : " + livro.getAutor() + ",\n";
		this.code += "\t\"numeroPaginas\" : " + livro.getNumeroPaginas() + "\n";
		this.code += "}\n";
	}

	@Override
	public void visit(Album album) {
		this.code += "{\n";
		this.code += "\t\"titulo\" : \"" + album.getTitulo() + "\",\n";
		this.code += "\t\"avaliacao\" : " + album.getAvaliacao() + ",\n";
		this.code += "\t\"estudio\" : " + album.getEstudio() + ",\n";
		this.code += "\t\"gravadora\" : " + album.getGravadora() + ",\n";
		this.code += "\t\"autor\" : " + album.getAutor() + ",\n";
		this.code += "\t\"duracao\" : " + album.getDuracao() + "\n";
		this.code += "}\n";

	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void clear() {
		this.code = "";
	}

}
