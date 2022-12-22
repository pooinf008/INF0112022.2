package br.ifba.inf011.criacional.fm.model.atuadores;

public class EstabilizadorFactory extends AtuadorFactory implements AtuadorCreator{
	
	public EstabilizadorFactory() {
		super();
	}

	@Override
	public Atuador criaAtuador() {
		return new Estabilizador();
	}	



}
