package br.ifba.inf011.model;

public class Temperatura {
	
	public double temperaturaMedia;
	public int qtdePontos;
	
	public Temperatura(double temperaturaMedia, int qtdePontos) {
		this.temperaturaMedia = temperaturaMedia;
		this.qtdePontos = qtdePontos;
	}

	public double getTemperaturaMedia() {
		return temperaturaMedia;
	}

	public int getQtdePontos() {
		return qtdePontos;
	}
	
	public String toString() {
		return String.format("%.2f - %d", this.temperaturaMedia, this.qtdePontos);
	}
	

}
