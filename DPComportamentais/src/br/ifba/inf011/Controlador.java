package br.ifba.inf011;

import br.ifba.inf011.strategy.AlgoritmoControle;

public interface Controlador{
	public double monitorar() throws FaultControladorException;
	public double monitorar(Ambiente ambiente) throws FaultControladorException;
	public double getEnergia();
	public boolean hasEnergia();
	public void save();
	public void undo();
}
