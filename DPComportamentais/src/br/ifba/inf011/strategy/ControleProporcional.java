package br.ifba.inf011.strategy;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class ControleProporcional implements AlgoritmoControle {

	@Override
	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint,
			List<Double> historico, List<Double> deltas,
			Double ganho, Ambiente ambiente) {
		
		System.err.print("Proporcional\t");
		
		double tempAtuacao = 0;
		
		if(Math.abs(delta) > 0.1 * setPoint) {
			tempAtuacao = Math.abs(delta * ganho);
		    if(delta > 0) {
		    	ambiente.esfriar(tempAtuacao);
		    }	
		    else{
		    	ambiente.aquecer(tempAtuacao);
		    }
		}
		return tempAtuacao;
	}
	
	

	@Override
	public double getGastoEnergia() {
		return 1.0;
	}



	@Override
	public String getNome() {
		return "Controle Proporcional";
	}

}
