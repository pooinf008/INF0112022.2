package br.ifba.inf011.model.adapter;

import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.model.MultiTermometro;
import br.ifba.inf011.model.Temperatura;
import br.ifba.inf011.model.Termometro;

public class MultiTermometro2Termometro implements Termometro{

	private MultiTermometro multiTermometro;
	
	public MultiTermometro2Termometro(MultiTermometro multiTermometro) {
		this.multiTermometro = multiTermometro;
	}
	
	@Override
	public List<Temperatura> getTemperatura() {
		double temperaturaMedia = 0;
		for(Double temperatura : this.multiTermometro.getTemperaturas())
			temperaturaMedia += temperatura;
		temperaturaMedia /= this.multiTermometro.getTemperaturas().length;
		Temperatura t = new Temperatura(temperaturaMedia, 1);
		List<Temperatura> temperatura = new ArrayList<Temperatura>();
		temperatura.add(t);
		return temperatura;
	}

	@Override
	public String toTab(int tab) {
		return this.multiTermometro.toTab(tab);
	}

	@Override
	public void atualizarFirmware(String version) {
		this.multiTermometro.atualizarVersao(version);
	}

	@Override
	public String getId() {
		return this.multiTermometro.getId();
	}

	@Override
	public double getTemperaturaMedia() {
		return this.getTemperatura().get(0).getTemperaturaMedia();
	}

}
