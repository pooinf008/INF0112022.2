package br.ifba.inf011.strategy;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class PoliticaTipoI implements PoliticaAtuacao {

	@Override
	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint,
			List<Double> historico, List<Double> deltas,
			Double ganho, Ambiente ambiente) {
		if(Math.abs(delta) > 0.1 * setPoint) {
			double tempAtuacao = Math.abs(delta * ganho);
		    if(delta > 0) {
		    	ambiente.esfriar(tempAtuacao);
		    }	
		    else{
		    	ambiente.aquecer(tempAtuacao);
		    }
		}
		return delta;
	}
	
	

	@Override
	public double getGastoEnergia() {
		return 1.0;
	}

}
