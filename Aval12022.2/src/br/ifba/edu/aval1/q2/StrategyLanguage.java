package br.ifba.edu.aval1.q2;

import br.ifba.edu.aval1.model.Algoritmo;

public interface StrategyLanguage {
	
	public void verificarLexico(Algoritmo algoritmo) throws Exception;
	public void verificarSintaxe(Algoritmo algoritmo) throws Exception;
	public void verificarSemantica(Algoritmo algoritmo) throws Exception;
	public void gerarCodigo(Algoritmo algoritmo) throws Exception;

}
