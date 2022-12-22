package br.ifba.inf011;

import java.util.Random;

public class Ambiente{

	
	private static final double STD_TEMP = 27;
	
	private	String id;
	public double ultimaMedicao;

	
	public Ambiente(String id, double tempInicial) {
		this.id = id;
		this.ultimaMedicao = tempInicial; 
	}
	
	public Ambiente(String id) {
		this(id, Ambiente.STD_TEMP);
	}
	
	
	public String getId() {
		return this.id;
	}
	
	public double getTemperatura() {
		return this.ultimaMedicao; 
	}
	
	public void aquecer(double intensidade) {
		this.ultimaMedicao += this.getVariacao(intensidade);
	}
	
	public void esfriar(double intensidade) {
		this.ultimaMedicao -= this.getVariacao(intensidade);
	}
	

	private double getVariacao(double intensidade) {
		Random random = new Random();
		double variacao = random.nextDouble() * intensidade;
		return variacao;
	}	

	
	public void randomizar() {
		Random random = new Random();
		int valor = random.nextInt(3);
		if (random.nextBoolean()) 
			this.esfriar(valor); 
		else
			this.aquecer(valor); 
	}
	
	
}	