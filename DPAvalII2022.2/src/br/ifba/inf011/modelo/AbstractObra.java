package br.ifba.inf011.modelo;

public abstract class AbstractObra implements Obra{

	protected String titulo;
	protected Integer ano;
	protected Double avaliacao;	

	public AbstractObra(String titulo, Integer ano, Double avaliacao) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.avaliacao = avaliacao;
	}
	
	@Override
	public String getTitulo() {
		return titulo;
	}

	@Override
	public Integer getAno() {
		return ano;
	}

	@Override
	public Double getAvaliacao() {
		return avaliacao;
	}

	



}
