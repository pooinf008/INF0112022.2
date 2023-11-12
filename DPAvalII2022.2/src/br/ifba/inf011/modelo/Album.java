package br.ifba.inf011.modelo;

import br.ifba.inf011.modelo.visitor.ObraVisitor;

public class Album extends AbstractObra{

	private String gravadora;
	private String estudio;
	private String autor;
	private Integer duracao;
		
	public Album(String titulo, Integer ano, Double avaliacao,
				 String gravadora, String estudio,
				 String autor, Integer duracao) {
		super(titulo, ano, avaliacao);
		this.gravadora = gravadora;
		this.estudio = estudio;
		this.autor = autor;
		this.duracao = duracao;
	}

	public String getGravadora() {
		return gravadora;
	}

	public String getAutor() {
		return autor;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public String getEstudio() {
		return estudio;
	}
	
	@Override
	public void accept(ObraVisitor visitor) {
		visitor.visit(this);
	}		

}
