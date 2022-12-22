package br.ifba.inf011.cor;

import java.util.List;

import br.ifba.inf011.Ambiente;

public abstract class AbstractControleHandle implements ControleHandle{

	protected ControleHandle proximo;
	
	public AbstractControleHandle(ControleHandle proximo) {
		this.proximo = proximo;
	}
	
	public void setProximo(ControleHandle proximo) {
		this.proximo = proximo;
	}

	public abstract double calcularDeltaAtuacao(double temperatura, double delta, double setPoint, 
			double energia, List<Double> historico,
			List<Double> deltas, Double ganho, Ambiente ambiente);	
}
