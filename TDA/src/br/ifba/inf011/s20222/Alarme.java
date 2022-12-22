package br.ifba.inf011.s20222;

public class Alarme {
	
	private Double limiarInf;
	private Double limiarSup;
	
	public Alarme(Double limiarInf, Double limiarSup) {
		super();
		this.limiarInf = limiarInf;
		this.limiarSup = limiarSup;
	}

	private Double getLimiarInferior() {
		return limiarInf;
	}

	private Double getLimiarSuperior() {
		return limiarSup;
	}
	
	public void alarmar() {
		System.err.println("TEMPERATURA FORA DOS LIMITES");
	}
	
	public void lerTemperatura(Double temperatura) {
		if(temperatura < 0)
			throw new RuntimeException("TEMPERATURA NEGATIVA NÃO É VÁLIDA");
		System.err.println(temperatura );
		if(temperatura < this.getLimiarInferior())
			this.alarmar();
		else if(temperatura > this.getLimiarSuperior())
			this.alarmar();		
	}
	
}
