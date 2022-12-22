package br.ifba.inf011.cor;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class ProporcionalTMHandle extends AbstractTMControleHandle implements ControleHandle{
	
	public ProporcionalTMHandle(ControleHandle proximo) {
		super(proximo);
	}

	@Override
	protected boolean deveAtuar(double temperatura, double delta, double setPoint, 
								double energia, List<Double> historico,
								List<Double> deltas, Double ganho, Ambiente ambiente) {
		return (energia > 50 && Math.abs(delta) > 0.05 * setPoint);
	}

	@Override
	protected double atuar(double temperatura, double delta, double setPoint, 
			double energia, List<Double> historico,
			List<Double> deltas, Double ganho, Ambiente ambiente) {
		double tempAtuacao = 0;
		
		tempAtuacao = Math.abs(delta * ganho);
		if(delta > 0) {
			ambiente.esfriar(tempAtuacao);
		}	
		else{
			ambiente.aquecer(tempAtuacao);
		}
		return tempAtuacao;
	}

	@Override
	protected void logar() {
		System.err.print("Proporcional\t");
	}
	
}
