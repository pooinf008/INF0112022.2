package br.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

public abstract class NoComposto extends AbstractTermometro implements Termometro{
	
	protected List<Termometro> filhos;
	
	
	public NoComposto() {
		this.filhos = new ArrayList<Termometro>();
	}
	
	public void addTermometro(Termometro filho) {
		this.filhos.add(filho);
	}
	
	protected boolean hasChild() {
		return this.filhos.size() > 0; 
	}

	public abstract List<Temperatura> getTemperatura();
	
	public abstract String getDescricao();
	
	public String toString() {
		String s = super.toString() + 
				   this.getDescricao(); 
		for(Termometro termometro : this.filhos)
			s = s + termometro.toString() + "\n";
		return s;
	}
	
	public String toTab(int tab) {
		String s = super.toTab(tab+1) + super.toString() + this.getDescricao() + "\n";
		for(Termometro termometro : this.filhos)
			s = s + termometro.toTab(tab+1);
		return s;
	}

	public int qtdeFilhos() {
		return this.filhos.size();
	}

	public String idFilhos() {
		String ids = "[";
		for(Termometro termometro : this.filhos)
			ids = ids + termometro.getId() + " ";
		return ids + "]";
	}
	
	@Override
	public double getTemperaturaMedia() {
		double temperatura = 0;
		int quantidadePontos = 0;
		for(Temperatura t : this.getTemperatura()) {
			temperatura += t.getTemperaturaMedia() * t.getQtdePontos();
			quantidadePontos += t.getQtdePontos();
		}
		return temperatura / quantidadePontos;
	}
	
	public void atualizarFirmware(String version) {
		this.version = version;
		for(Termometro termometro : this.filhos)
			termometro.atualizarFirmware(version);
	}
	

}
