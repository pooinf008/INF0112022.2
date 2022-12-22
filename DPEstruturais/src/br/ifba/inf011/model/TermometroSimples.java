package br.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TermometroSimples extends AbstractTermometro implements Termometro{
	
	private double tempReferencia;
	
	public TermometroSimples(double tempReferencia) {
		this.tempReferencia= tempReferencia;
	}	
	
	public TermometroSimples(String id, double tempReferencia) {
		super(id);
		this.tempReferencia= tempReferencia;
	}
	
	public List<Temperatura> getTemperatura() {
		Random random = new Random();
		tempReferencia += random.nextGaussian() * 1;
		List<Temperatura> temperaturas = new ArrayList<Temperatura>();
		temperaturas.add(new Temperatura(this.tempReferencia, 1)); 
		return temperaturas;
	}
	
	public String toString() {
		return super.toString() + tempReferencia;
	}
	
	public String toTab(int tab) {
		String s = super.toTab(tab+1) + super.toString() + "Termometro Simples\n";
		return s;
	}	
	
	public double getTemperaturaReferencia() {
		return this.tempReferencia;
	}

	@Override
	public double getTemperaturaMedia() {
		return this.getTemperatura().get(0).getTemperaturaMedia();
	}
	
	public void atualizarFirmware(String version) {
		this.version = version;
	}


}
