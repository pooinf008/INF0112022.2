package br.ifba.inf011.model.bridge;

public class SummaryElemento {
	
	private String id;
	private double temp;
	private int qtde;
	
	public SummaryElemento(String id) {
		this.id = id;
		this.temp = 0;
		this.qtde = 0;
	}
	
	public void add(double temp) {
		this.temp += temp;
		this.qtde++;
	}
	
	public double mean() {
		return this.temp / this.qtde;
	}

}
