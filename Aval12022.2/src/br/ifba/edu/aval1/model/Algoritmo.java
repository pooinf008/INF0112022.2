package br.ifba.edu.aval1.model;

public abstract class Algoritmo {
	
	protected Bloco main;
	
	public Algoritmo(Bloco main) {
		this.main = main;
	}
	
	public abstract String getValor();

}
