package br.ifba.edu.aval1.model;

public enum Lang {
	
	C("br.ifba.edu.aval1.q1.C.CLanguageFactory", "br.ifba.edu.aval1.q2.CStrategy"),
	Portugol("br.ifba.edu.aval1.q1.portugol.PortugolLanguageFactory", "br.ifba.edu.aval1.q2.PortugolStrategy");

	Lang(String factoryName, String strategyName){
		this.factoryName = factoryName;
		this.strategyName = strategyName;
	}
	
	String factoryName;
	String strategyName;
	
	public String getFactoryName() {
		return this.factoryName;
	}

	public String getStrategyLanguage() {
		return this.strategyName;
	}

}
