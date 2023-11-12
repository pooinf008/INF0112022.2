package br.ifba.inf011.modelo;

import br.ifba.inf011.modelo.visitor.ObraVisitor;

public interface Obra {
	
	public String getTitulo();
	public Integer getAno();
	public Double getAvaliacao();
	public void accept(ObraVisitor visitor);

}
