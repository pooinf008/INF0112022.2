package br.ifba.inf011.cor;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class OffTMHandle extends AbstractTMControleHandle implements ControleHandle{
	
	public OffTMHandle() {
		super(null);
	}

	@Override
	protected void logar() {
		System.err.print("Off Handle\t");
		
	}

	@Override
	protected boolean deveAtuar(double temperatura, double delta, double setPoint, double energia,
			List<Double> historico, List<Double> deltas, Double ganho, Ambiente ambiente) {
		return true;
	}

	@Override
	protected double atuar(double temperatura, double delta, double setPoint, double energia, List<Double> historico,
			List<Double> deltas, Double ganho, Ambiente ambiente) {
		return 0;
	}

}
