package br.ifba.inf011.observer;

public interface ChangeStrategyObserver {
	public void strategyChanged(String tipoAntigo,
								String novo);
}
