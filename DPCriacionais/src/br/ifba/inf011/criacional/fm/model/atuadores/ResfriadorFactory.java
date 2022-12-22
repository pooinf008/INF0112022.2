package br.ifba.inf011.criacional.fm.model.atuadores;

public class ResfriadorFactory extends AtuadorFactory implements AtuadorCreator{
	
	public ResfriadorFactory() {
		super();
	}

	@Override
	public Atuador criaAtuador() {
		return new Resfriador();
	}	



}
