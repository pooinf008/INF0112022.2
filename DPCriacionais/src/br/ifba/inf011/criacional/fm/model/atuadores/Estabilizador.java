package br.ifba.inf011.criacional.fm.model.atuadores;

import br.ifba.inf011.Ambiente;

public class Estabilizador extends GenericAtuador implements Atuador{
	
	public Estabilizador() {
		this(0, 0);
	}
	
	public Estabilizador(Estabilizador estabilizador) {
		super(estabilizador);
	}	
	
	public Estabilizador(double minima, double maxima) {
		this.setTemperaturaMaxima(maxima);
		this.setTemperaturaMinima(minima);
	}	
	

	@Override
	public void config(String conf) {
		double[] temps = this.parseTemp(conf);
		this.setTemperaturaMinima(temps[0]);
		this.setTemperaturaMaxima(temps[1]);
	}

	@Override
	public void atuar(Ambiente ambiente) {
		double temperatura = ambiente.getTemperatura();
		if(temperatura > this.tempMaxima) {
			double delta = temperatura - this.tempMaxima;
			this.alarme.println(">>>> Resfriando: " + delta + "°C");
			ambiente.esfriar(delta);
		}else if (temperatura < this.tempMinima) {
			double delta = this.tempMinima - temperatura;
			this.alarme.println(">>>> Aquecer: " + delta + "°C");
			ambiente.aquecer(delta);
		}
	}

	@Override
	public Atuador prototipar() {
		return new Estabilizador(this);
	}
	
	

}
