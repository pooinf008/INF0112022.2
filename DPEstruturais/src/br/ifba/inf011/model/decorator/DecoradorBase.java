package br.ifba.inf011.model.decorator;

import java.util.List;

import br.ifba.inf011.model.Temperatura;
import br.ifba.inf011.model.Termometro;

public abstract class DecoradorBase implements Termometro{
	
	protected Termometro termometro;
	
	public DecoradorBase(Termometro termometro) {
		this.termometro = termometro;
	}

	@Override
	public List<Temperatura> getTemperatura() {
		return this.termometro.getTemperatura();
	}

	@Override
	public double getTemperaturaMedia() {
		return this.termometro.getTemperaturaMedia();
	}

	@Override
	public String toTab(int tab) {
		return this.termometro.toTab(tab);
	}

	@Override
	public void atualizarFirmware(String version) {
		this.termometro.atualizarFirmware(version);
	}

	@Override
	public String getId() {
		return this.termometro.getId();
	}
	
	public String toString() {
		return this.termometro.toString();
	}
	
}
