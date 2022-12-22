package br.ifba.inf011.model;

import java.util.List;

public interface Termometro{
	
	public List<Temperatura> getTemperatura();
	public double getTemperaturaMedia();
	public String toTab(int tab);
	public void atualizarFirmware(String version);
	public String getId();

}
