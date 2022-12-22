package br.ifba.inf011.strategy;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class PoliticaTipoII implements PoliticaAtuacao {

	@Override
	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint,
			List<Double> historico, List<Double> deltas,
			Double ganho, Ambiente ambiente) {
		double deltaMedio = 0;
		for(int i = deltas.size() - 1, j = 0;
				i >= 0 && j < 5; i--, j++) 
			deltaMedio += deltas.get(i);
		deltaMedio /= 5.0;
		
		if(Math.abs(deltaMedio) > 0.1 * setPoint) {
			double tempAtuacao = Math.abs(deltaMedio * ganho);
		    if(deltaMedio > 0) {
		    	ambiente.esfriar(tempAtuacao);
		    }	
		    else{
		    	ambiente.aquecer(tempAtuacao);
		    }
		}
		return deltaMedio;
	}
	

	@Override
	public double getGastoEnergia() {
		return 2.0;
	}

}
