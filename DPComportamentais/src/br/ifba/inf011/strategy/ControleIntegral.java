package br.ifba.inf011.strategy;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class ControleIntegral implements AlgoritmoControle {

/*	@Override
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
*/	
	@Override
	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint,
			List<Double> historico, List<Double> deltas,
			Double ganho, Ambiente ambiente) {

		System.err.print("Integral\t");
		
		double temp = historico.get(historico.size() - 1);
		int qtdeAtuacao = (historico.size() > 5) ?
					  	  5 : historico.size();
		double deltaHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeAtuacao; i--, j++)
			deltaHistorico =  (historico.get(i) - setPoint) + deltaHistorico;
		
		deltaHistorico = deltaHistorico / qtdeAtuacao;
		double tempAtuacao = Math.abs(deltaHistorico * ganho);
		
	    if(temp > setPoint) {
	    	ambiente.esfriar(tempAtuacao);
	    }	
	    else{
	    	ambiente.aquecer(tempAtuacao);
	    }
	    
	    return tempAtuacao;
	}

	@Override
	public double getGastoEnergia() {
		return 2.0;
	}

	@Override
	public String getNome() {
		return "Controle Integral";
	}

}
