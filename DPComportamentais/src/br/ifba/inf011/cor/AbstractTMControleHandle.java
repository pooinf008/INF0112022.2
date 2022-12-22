package br.ifba.inf011.cor;

import java.util.List;

import br.ifba.inf011.Ambiente;

public abstract class AbstractTMControleHandle implements ControleHandle{

	protected ControleHandle proximo;
	
	public AbstractTMControleHandle(ControleHandle proximo) {
		this.proximo = proximo;
	}
	
	public void setProximo(ControleHandle proximo) {
		this.proximo = proximo;
	}

	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint, 
			double energia, List<Double> historico,
			List<Double> deltas, Double ganho, Ambiente ambiente) {
		if(this.deveAtuar(temperatura, delta, setPoint, 
						  energia, historico, deltas,
						  ganho, ambiente)) {
			this.logar();
			this.atuar(temperatura, delta, setPoint, 
							  energia, historico, deltas,
							  ganho, ambiente);
		}
		if(this.proximo != null)
			return this.proximo.calcularDeltaAtuacao(temperatura, delta, setPoint, energia, historico, deltas, ganho, ambiente);
		else
			return 0;
	}
	
	protected abstract void logar();

	protected abstract boolean deveAtuar(double temperatura, double delta, double setPoint, 
			double energia, List<Double> historico,
			List<Double> deltas, Double ganho, Ambiente ambiente);
	
	protected abstract double atuar(double temperatura, double delta, double setPoint, 
			double energia, List<Double> historico,
			List<Double> deltas, Double ganho, Ambiente ambiente);
}
