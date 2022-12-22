package br.ifba.inf011.criacional.fm.model.termometro;

public class TermometroFaixaFactory extends TermometroFactory implements TermometroCreator{
	
	public TermometroFaixaFactory() {
		super();
	}	

	@Override
	public Termometro criaTermometro() {
		return new TermometroFaixa();
	}

}
