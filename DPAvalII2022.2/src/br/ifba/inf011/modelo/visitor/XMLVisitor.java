package br.ifba.inf011.modelo.visitor;

import br.ifba.inf011.modelo.Album;
import br.ifba.inf011.modelo.Livro;

public class XMLVisitor implements ObraVisitor{

	private String code;
	
	public XMLVisitor() {
		this.clear();
	}
	
	@Override
	public void visit(Livro livro) {
		
		this.code += "<livro titulo = \"" + livro.getTitulo() + "\" ano = \"" + livro.getAno() + "\">\n";
		this.code += "\t<avaliacao>" + livro.getAvaliacao() + "</avaliacao>\n";
		this.code += "\t<editora>" + livro.getEditora() + "</editora>\n";
		this.code += "\t<idioma>" + livro.getIdioma() + "</idioma>\n";
		this.code += "\t<autor>" + livro.getAutor() + "</autor>\n";
		this.code += "\t<num_paginas>" + livro.getNumeroPaginas() + "</num_paginas>\n";
		this.code += "</livro>\n";
		
	}

	@Override
	public void visit(Album album) {
		this.code += "<album titulo = \"" + album.getTitulo() + "\" ano = \"" + album.getAno() + "\">\n";
		this.code += "\t<avaliacao>" + album.getAvaliacao() + "</avaliacao>\n";
		this.code += "\t<estudio>" + album.getEstudio() + "</estudio>\n";
		this.code += "\t<gravadora>" + album.getGravadora() + "</gravadora>\n";
		this.code += "\t<autor>" + album.getAutor() + "</autor>\n";
		this.code += "\t<duracao>" + album.getDuracao() + "</duracao>\n";
		this.code += "</album>\n";
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
