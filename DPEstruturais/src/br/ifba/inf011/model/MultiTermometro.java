package br.ifba.inf011.model;

import java.util.Random;

public class MultiTermometro {
	
	private static final int QTDE_PONTOS = 5;
	
	private double tempReferencia;
	private Double[] temps;
	private double x, y;
	private String id;
	private String versao = "1.0";
	
	public MultiTermometro(String id, double x, double y, double tempReferencia) {
		this.id = id;
		this.x = x;
		this.y = y;	
		this.tempReferencia = tempReferencia;
		this.temps= new Double[MultiTermometro.QTDE_PONTOS];
		for(int i = 0; i < this.temps.length; i++)
			this.temps[i] = tempReferencia;
	}
	
	
	
	public String getId() {
		return id;
	}



	private void readTemps() {
		Random random = new Random();
		for(int i = 0; i < this.temps.length; i++)
			this.temps[i] += random.nextGaussian() * 1.5;  
	}
	
	public Double[] getTemperaturas() {
		this.readTemps();
		return this.temps;
	}
	
	public Double getTemperatura(int ponto) {
		this.readTemps();
		return this.temps[ponto];
	}
	
	
	public String toString() {
		String sTemps = "[ ";
		for(Double d : this.temps)
			sTemps = sTemps + d + " ";
		sTemps +="]";
		
		return String.format("%s (%.2f; %.2f) - v%s - ", this.id, this.x, this.y, this.versao)  + sTemps;   
	}	
	
	public String toTab(int tab) {
		String s = "";
		for(int i = 0; i < tab; i++)
			s +="\t";
		s += "\t";
		s += this.toString() + " MultiTermometro Simples\n";
		return s;
	}	
	
	public double getTemperaturaReferencia() {
		return this.tempReferencia;
	}
	
	public void atualizarVersao(String nova) {
		this.versao = nova;
	}

}
