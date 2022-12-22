package br.ifba.inf011.criacional.fm.model.termometro;

public class TermometroLockFactory extends TermometroFactory  implements TermometroCreator{

	
	public TermometroLockFactory() {
		super();
	}	

	@Override
	public Termometro criaTermometro() {
		return new TermometroLock(temperatura);
	}

}
