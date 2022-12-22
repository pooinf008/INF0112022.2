package br.ifba.inf011.criacional.fm.model.termometro;

public class TermometroAltaFactory extends TermometroFactory implements TermometroCreator{
	
	public TermometroAltaFactory() {
		super();
	}	

	@Override
	public Termometro criaTermometro() {
		return new TermometroAlta(temperatura);
	}

}
