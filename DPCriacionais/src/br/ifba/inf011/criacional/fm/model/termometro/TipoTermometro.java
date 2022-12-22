package br.ifba.inf011.criacional.fm.model.termometro;

public enum TipoTermometro {
	
	TermometroAlta("br.ifba.inf011.criacional.fm.model.termometro.TermometroAltaFactory"), 
	TermometroLock("br.ifba.inf011.criacional.fm.model.termometro.TermometroLockFactory");
	
	String factoryName;
	
	TipoTermometro(String factoryName){
		this.factoryName = factoryName;
	}
	
	public String getFactoryName() {
		return factoryName;
	}

}
