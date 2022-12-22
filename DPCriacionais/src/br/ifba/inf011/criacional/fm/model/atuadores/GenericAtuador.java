package br.ifba.inf011.criacional.fm.model.atuadores;

import java.io.PrintStream;

import br.ifba.inf011.criacional.fm.model.termometro.GenericTermometro;

public abstract class GenericAtuador implements Atuador{
	
	
	protected PrintStream alarme;
	protected PrintStream padrao;
	protected double tempMaxima;
	protected double tempMinima;
	
	public GenericAtuador(GenericAtuador atuador) {
		this.alarme = atuador.alarme;
		this.padrao = atuador.padrao;
		this.tempMaxima = atuador.tempMaxima;
		this.tempMinima = atuador.tempMinima;
	}	
	
	public GenericAtuador(){
		this.alarme = System.err;
		this.padrao = System.out;
	}
	
	public void setAlarme(PrintStream alarme) {
		this.alarme = alarme;
	};
	
	public void setPadrao(PrintStream padrao) {
		this.padrao = padrao;
	};
	
	public void setTemperaturaMaxima(double tempMaxima) {
		this.tempMaxima = tempMaxima;
	};	
	
	public void setTemperaturaMinima(double tempMinima) {
		this.tempMinima = tempMinima;
	};		
	
	protected double[] parseTemp(String conf) {
		
		double[] temps = new double[2];
		temps[0] = 0;
		temps[1] = 0;
		int pos = conf.indexOf(':');
		if(pos > 0) {
			temps[0] = Double.parseDouble(conf.substring(0, pos));
			temps[1] = Double.parseDouble(conf.substring(pos+1, conf.length()));	
		}else
			temps[1] = Double.parseDouble(conf);
		return temps;
	}
	
	

}
