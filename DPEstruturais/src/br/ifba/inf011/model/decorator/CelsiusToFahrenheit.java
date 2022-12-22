package br.ifba.inf011.model.decorator;

import java.util.Arrays;
import java.util.List;

import br.ifba.inf011.model.Temperatura;
import br.ifba.inf011.model.Termometro;

public class CelsiusToFahrenheit extends DecoradorBase {

	public CelsiusToFahrenheit(Termometro termometro) {
		super(termometro);
	}
	
	@Override
	public double getTemperaturaMedia() {
		double tempCelsius = super.getTemperaturaMedia();
		return fahrenheit(tempCelsius);
	}
	
	private double fahrenheit(double celsius) {
		return (celsius * 9.0/5.0) + 32.0;
	}
	
	@Override
	public List<Temperatura> getTemperatura() {
		Temperatura temperatura = super.getTemperatura().get(0);
		Temperatura tFahrenheit = new Temperatura(fahrenheit(temperatura.getTemperaturaMedia()), temperatura.getQtdePontos());
		return Arrays.asList(tFahrenheit);
	}	
	

	
}
