package br.ifba.inf011.strategy;

import java.util.List;

import br.ifba.inf011.Ambiente;

public interface AlgoritmoControle {
	
	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint,
									   List<Double> historico, List<Double> deltas,
									   Double ganho, Ambiente ambiente);
	public double getGastoEnergia();
	public String getNome();
	
}
