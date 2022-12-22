package br.ifba.inf011;

import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.observer.ChangeStrategyObserver;
import br.ifba.inf011.observer.LowBatObserver;
import br.ifba.inf011.strategy.AlgoritmoControle;
import br.ifba.inf011.strategy.ControleProporcional;

public class StrategyControlador extends AbstractControlador implements Controlador{
	
	
	private static final double LOW_BAT = 10.0;
	
	private AlgoritmoControle politicaAtuacao;
	private List<ChangeStrategyObserver> changeStrategyObservers;
	private List<LowBatObserver> lowBatObservers;
	
	
	public StrategyControlador(Ambiente ambiente, double setPoint, double ganho) {
		super(ambiente, setPoint, ganho);
		this.politicaAtuacao = new ControleProporcional();
		this.changeStrategyObservers = new ArrayList<ChangeStrategyObserver>();
		this.lowBatObservers = new ArrayList<LowBatObserver>();
	}
	
	public StrategyControlador(Ambiente ambiente) {
		this(ambiente, 27, 1.0);
	}
	

	public StrategyControlador() {
		this(null);
	}

	
	public double monitorar(){
		double temperatura = ambiente.getTemperatura();
		double delta = temperatura - this.setPoint;  
		double valor_atuacao;
		this.historico.add(temperatura);
		this.diferenca.add(Math.abs(delta));
		valor_atuacao = this.politicaAtuacao.calcularDeltaAtuacao(temperatura, delta, 
																  this.setPoint, this.historico,
																  this.diferenca, this.ganho, this.ambiente);
		this.energia -= this.consumoRodada();
		if(this.energia < StrategyControlador.LOW_BAT)
			this.notifyLowBatObservers(this.energia);
		System.out.println("historico size: =" + this.historico.size());
		return valor_atuacao;
	}
	

	public double consumoRodada() {
		return this.politicaAtuacao.getGastoEnergia();
	}


	public void setPoliticaAtuacao(AlgoritmoControle politica) {
		if(this.politicaAtuacao.getNome().equals(politica.getNome()))
			return;
		String antigo = this.politicaAtuacao.getNome();
		String novo = politica.getNome();
		this.politicaAtuacao = politica;
		this.notifyChangeStrategyObserver(antigo, novo);
	}
	
	public void registrarChangeStrategyObserver(ChangeStrategyObserver observer) {
		this.changeStrategyObservers.add(observer);
	}
	
	public void desRegistrarChangeStrategyObserver(ChangeStrategyObserver observer) {
		this.changeStrategyObservers.remove(observer);
	}	
	
	public void registrarLowBatObserver(LowBatObserver observer) {
		this.lowBatObservers.add(observer);
	}
	
	
	private void notifyChangeStrategyObserver(String antigo,
											  String novo) {
		for(ChangeStrategyObserver observer : this.changeStrategyObservers)
			observer.strategyChanged(antigo, novo);
	}
	
	private void notifyLowBatObservers(double energy) {
		for(LowBatObserver observer : this.lowBatObservers)
			observer.lowBat(energy);
	}	
	
}
