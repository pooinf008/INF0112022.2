package br.ifba.inf011.tm;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.Controlador;
import br.ifba.inf011.FaultControladorException;
import br.ifba.inf011.strategy.AlgoritmoControle;
import br.ifba.inf011.strategy.ControleProporcional;

public abstract class ControleTemplate implements Controlador{
	
	protected Ambiente ambiente;
	protected double energia;
	protected double setPoint;
	protected List<Double> historico;
	protected List<Double> diferenca;	
	protected Double ganho;		
	
	public ControleTemplate(Ambiente ambiente, double setPoint, double ganho) {
		this.ambiente = ambiente;
		this.energia = 100;
		this.historico = new ArrayList<Double>();
		this.diferenca = new ArrayList<Double>();
		this.setPoint = setPoint;
		this.ganho = ganho;
	}
	
	public ControleTemplate(Ambiente ambiente) {
		this(ambiente, 27, 1.0);
	}
	

	public ControleTemplate() {
		this(null);
	}
	
	public double monitorar(Ambiente ambiente) throws FaultControladorException{
		this.ambiente = ambiente;
		return this.monitorar();
	}	
	
	public double monitorar() throws FaultControladorException{
		if (!this.hasEnergia())
			throw new FaultControladorException();
		this.registrarHistorico();
		this.logTipoAtuacao();
		this.energia -= this.getConsumoRodada();
		double valorAtuacao = this.getValorAtuacao();
		return this.atuar(valorAtuacao);
	}
	
	protected abstract double atuar(double tempAtuacao);

	private void registrarHistorico() {
		double temperatura = ambiente.getTemperatura();
		double delta = temperatura - this.setPoint;  
		this.historico.add(temperatura);
		this.diferenca.add(Math.abs(delta));
	}

	protected double getConsumoRodada() {;
		return 1.0;
	}

	protected abstract double getValorAtuacao();

	protected abstract void logTipoAtuacao();

	@Override
	public double getEnergia() {
		return this.energia;
	}

	@Override
	public boolean hasEnergia() {
		return this.getEnergia() > this.getConsumoRodada();
	}	
	
}
