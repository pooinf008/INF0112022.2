package br.ifba.inf011.cor;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class OffHandle extends AbstractControleHandle implements ControleHandle{
	
	public OffHandle() {
		super(null);
	}

	@Override
	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint, 
		   double energia, List<Double> historico,
		   List<Double> deltas, Double ganho, Ambiente ambiente) {
		System.err.print("Off Handle\t");
		return 0;
	}

}
