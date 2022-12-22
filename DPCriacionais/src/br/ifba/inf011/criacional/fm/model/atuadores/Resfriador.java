package br.ifba.inf011.criacional.fm.model.atuadores;

import br.ifba.inf011.Ambiente;

public class Resfriador extends GenericAtuador implements Atuador{

	public Resfriador() {
		this(0);
	}
	
	public Resfriador(Resfriador resfriador) {
		super(resfriador);
	}		
	
	public Resfriador(double maxima) {
		this.setTemperaturaMaxima(maxima);
	}	
	
	@Override
	public void config(String conf) {
		double[] temps = this.parseTemp(conf);
		this.setTemperaturaMaxima(temps[1]);
	}

	@Override
	public void atuar(Ambiente ambiente) {
		double temperatura = ambiente.getTemperatura();
		if(temperatura > this.tempMaxima) {
			double delta = temperatura - this.tempMaxima;
			this.alarme.println(">>>> Resfriando: " + delta + "°C");
			ambiente.esfriar(delta);
		}
	}

	@Override
	public Atuador prototipar() {
		return new Resfriador(this);
	}
	
	

}
