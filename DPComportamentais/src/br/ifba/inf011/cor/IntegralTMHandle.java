package br.ifba.inf011.cor;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class IntegralTMHandle extends AbstractTMControleHandle implements ControleHandle{

	
	public IntegralTMHandle(ControleHandle proximo) {
		super(proximo);
	}
	

	@Override
	protected void logar() {
		System.err.print("Integral\t");
	}

	@Override
	protected boolean deveAtuar(double temperatura, double delta, double setPoint, double energia,
			List<Double> historico, List<Double> deltas, Double ganho, Ambiente ambiente) {
		double tempAtuacao = this.calcularTempBaseAtuacao(setPoint, historico, ganho);	
		return ((energia > 5) && (Math.abs(tempAtuacao) > 0.1 * setPoint));
	}

	private double calcularTempBaseAtuacao(double setPoint, List<Double> historico, Double ganho) {
		int qtdeAtuacao = (historico.size() > 5) ?
					  	  5 : historico.size();
		double deltaHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeAtuacao; i--, j++)
			deltaHistorico =  (historico.get(i) - setPoint) + deltaHistorico;
		
		deltaHistorico = deltaHistorico / qtdeAtuacao;
		double tempAtuacao = Math.abs(deltaHistorico * ganho);
		return tempAtuacao;
	}

	@Override
	protected double atuar(double temperatura, double delta, double setPoint, double energia,
			List<Double> historico, List<Double> deltas, Double ganho, Ambiente ambiente) {
		double temp = historico.get(historico.size() - 1);
		double tempAtuacao = this.calcularTempBaseAtuacao(setPoint, historico, ganho);
	    if(temp > setPoint) {
	    	ambiente.esfriar(tempAtuacao);
	    }	
	    else{
	    	ambiente.aquecer(tempAtuacao);
	    }
	    
	    return tempAtuacao;		
	}
	
}
