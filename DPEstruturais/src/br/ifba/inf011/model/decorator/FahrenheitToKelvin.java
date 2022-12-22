package br.ifba.inf011.model.decorator;

import java.util.Arrays;
import java.util.List;

import br.ifba.inf011.model.Temperatura;
import br.ifba.inf011.model.Termometro;

public class FahrenheitToKelvin extends DecoradorBase {

	public FahrenheitToKelvin(Termometro termometro) {
		super(termometro);
	}
	
	@Override
	public double getTemperaturaMedia() {
		double tempFahrenheit = super.getTemperaturaMedia();
		return kelvin(tempFahrenheit); 
	}
	
	private double kelvin(double fahrenheit) {
		return ((fahrenheit - 32.0) * (5.0/9.0)) + 273.15;
	}
	
	@Override
	public List<Temperatura> getTemperatura() {
		Temperatura temperatura = super.getTemperatura().get(0);
		Temperatura tKelvin = new Temperatura(kelvin(temperatura.getTemperaturaMedia()), temperatura.getQtdePontos());
		return Arrays.asList(tKelvin);
	}	

	
}
