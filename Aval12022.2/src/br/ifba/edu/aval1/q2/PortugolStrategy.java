package br.ifba.edu.aval1.q2;

import br.ifba.edu.aval1.model.Algoritmo;

public class PortugolStrategy implements StrategyLanguage {

	@Override
	public void verificarLexico(Algoritmo algoritmo) throws Exception {
		System.out.println("...");
	}

	@Override
	public void verificarSintaxe(Algoritmo algoritmo) throws Exception {
		System.out.println("...");		
	}

	@Override
	public void verificarSemantica(Algoritmo algoritmo) throws Exception {
		System.out.println("...");
		
	}

	@Override
	public void gerarCodigo(Algoritmo algoritmo) throws Exception {
		System.out.println("...");
		System.out.println(algoritmo.getValor());
	}

}
