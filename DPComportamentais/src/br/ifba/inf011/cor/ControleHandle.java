package br.ifba.inf011.cor;

import java.util.List;

import br.ifba.inf011.Ambiente;

public interface ControleHandle {
	
	public void setProximo(ControleHandle proximo);
	
	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint,
			   double energia, List<Double> historico, List<Double> deltas,
			   Double ganho, Ambiente ambiente);	
	

}
