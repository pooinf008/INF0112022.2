package br.ifba.inf011.cor;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class ProporcionalHandleTipoII extends AbstractControleHandle implements ControleHandle{
	
	public ProporcionalHandleTipoII(ControleHandle proximo) {
		super(proximo);
	}

	@Override
	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint, 
			double energia, List<Double> historico,
			List<Double> deltas, Double ganho, Ambiente ambiente) {

		double tempAtuacao = 0;
		
		if(energia > 50 &&
			Math.abs(delta) > 0.05 * setPoint) {
			System.err.print("Proporcional\t");
			tempAtuacao = Math.abs(delta * ganho);
			return tempAtuacao + this.proximo.calcularDeltaAtuacao(temperatura, delta, setPoint, energia, historico, deltas, ganho, ambiente);
		}
		
		return this.proximo.calcularDeltaAtuacao(temperatura, delta, setPoint, energia, historico, deltas, ganho, ambiente);
		
	}
	
}
