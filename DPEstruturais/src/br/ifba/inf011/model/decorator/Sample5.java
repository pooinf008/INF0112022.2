package br.ifba.inf011.model.decorator;

import br.ifba.inf011.model.Termometro;

public class Sample5 extends DecoradorBase {

	public Sample5(Termometro termometro) {
		super(termometro);
	}
	
	@Override
	public double getTemperaturaMedia() {
		double tempMedia = 0;
		for(int iCont = 0; iCont < 5; iCont++)
			tempMedia += super.getTemperaturaMedia();
		return tempMedia / 5;
	}

	
}
