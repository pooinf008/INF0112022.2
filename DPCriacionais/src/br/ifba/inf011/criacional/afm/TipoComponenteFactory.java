package br.ifba.inf011.criacional.afm;

public enum TipoComponenteFactory {
	
	Alta("br.ifba.inf011.criacional.afm.fm.AFComponenteAltaFactory"), 
	Faixa("br.ifba.inf011.criacional.afm.fm.AFComponenteFaixaFactory");
	
	String componenteFaixaFactoryClassName;
	
	TipoComponenteFactory(String componenteFaixaFactoryClassName){
		this.componenteFaixaFactoryClassName = componenteFaixaFactoryClassName;
	}
	
	public String factoryName() {
		return this.componenteFaixaFactoryClassName;
	}
	
	
	
}
