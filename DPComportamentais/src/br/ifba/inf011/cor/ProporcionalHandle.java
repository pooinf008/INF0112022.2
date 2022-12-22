package br.ifba.inf011.cor;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class ProporcionalHandle extends AbstractControleHandle implements ControleHandle{
	
	public ProporcionalHandle(ControleHandle proximo) {
		super(proximo);
	}

	@Override
	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint, 
			double energia, List<Double> historico,
			List<Double> deltas, Double ganho, Ambiente ambiente) {
		
		if(energia > 50 &&
			Math.abs(delta) > 0.05 * setPoint) {
		
			double tempAtuacao = 0;
		
			System.err.print("Proporcional\t");
			tempAtuacao = Math.abs(delta * ganho);
			if(delta > 0) {
				ambiente.esfriar(tempAtuacao);
			}	
			else{
				ambiente.aquecer(tempAtuacao);
			}
			return tempAtuacao;
		}
		
		return this.proximo.calcularDeltaAtuacao(temperatura, delta, setPoint, energia, historico, deltas, ganho, ambiente);
		
	}
	
}
