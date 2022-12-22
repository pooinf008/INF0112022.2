package br.ifba.inf011;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import br.ifba.inf011.memento.ControladorMemento;
import br.ifba.inf011.memento.Memento;
import br.ifba.inf011.strategy.ControleProporcional;

public abstract class AbstractControlador implements Controlador {

	protected Ambiente ambiente;
	protected double energia;
	protected double setPoint;
	protected List<Double> historico;
	protected List<Double> diferenca;	
	protected Double ganho;	
	
	public Stack<StateControlador> memento;
	
	
	public class StateControlador{
		
		protected String id;
		
		protected Ambiente ambiente;
		protected double energia;
		protected double setPoint;
		protected List<Double> historico;
		protected List<Double> diferenca;	
		protected Double ganho;
		
		private StateControlador(String id, Ambiente ambiente,
								 double energia,
								 double setPoint,
								 List<Double> historico,
								 List<Double> diferenca,	
								 Double ganho) {
			this.id = id; 
			this.ambiente = ambiente;
			this.energia = energia;
			this.setPoint = setPoint;
			this.historico = new ArrayList<Double>(historico);
			this.diferenca = new ArrayList<Double>(diferenca);
			this.ganho = ganho; 
		}
		
		public String getId() {
			return this.id;
		}
		
	}
	
	
	
	public AbstractControlador(Ambiente ambiente, double setPoint, double ganho) {
		super();
		this.ambiente = ambiente;
		this.energia = 100;
		this.historico = new ArrayList<Double>();
		this.diferenca = new ArrayList<Double>();
		this.setPoint = setPoint;
		this.ganho = ganho;
		this.memento = new Stack<StateControlador>();
	}
	
	public double monitorar(Ambiente ambiente){
		this.ambiente = ambiente;
		return this.monitorar();
	}

	public abstract double monitorar();
	
	public abstract double consumoRodada();
	
	@Override
	public double getEnergia() {
		return this.energia;
	}


	@Override
	public boolean hasEnergia() {
		return this.getEnergia() > this.consumoRodada();
	}
	
	@Override
	public void save() {
		System.out.println("Historico Salvo: " + this.historico.size());
		this.memento.push(this.snapshot("AUTO"));
	}
	
	@Override
	public void undo() {
		this.restore(this.memento.pop());
		System.out.println("Historico Restaurado: " + this.historico.size());
		
	}	
	
	
	
	public AbstractControlador.StateControlador snapshot(String id){
		return 
				new AbstractControlador.StateControlador(id,
												 this.ambiente,
				 								 this.energia,
				 								 this.setPoint,
				 								 this.historico,
				 								 this.diferenca,	
				 								 this.ganho);
	}
	
	public void restore(AbstractControlador.StateControlador state) {
		 this.ambiente = state.ambiente;
		 this.energia = state.energia;
		 this.setPoint = state.setPoint;
		 this.historico = state.historico;
		 this.diferenca = state.diferenca;
		 this.ganho = state.ganho;
	}
	
	public void restore(Memento state) {
		 ControladorMemento cState = (ControladorMemento)state;
		 this.ambiente = cState.getAmbiente();
		 this.energia = cState.getEnergia();
		 this.setPoint = cState.getSetPoint();
		 this.historico = cState.getHistorico();
		 this.diferenca = cState.getDiferenca();
		 this.ganho = cState.getGanho();
	}	

	public Memento memento(String id) {
		return new ControladorMemento(id,
						 			this.ambiente,
						 			this.energia,
						 			this.setPoint,
						 			this.historico,
						 			this.diferenca,	
						 			this.ganho);
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public double getSetPoint() {
		return setPoint;
	}

	public List<Double> getHistorico() {
		return historico;
	}

	public List<Double> getDiferenca() {
		return diferenca;
	}

	public Double getGanho() {
		return ganho;
	}

	public void consumir(double energia) {
		this.energia -= energia;
		if(this.energia > 100)
			this.energia = 100;
		else if(this.energia < 0)
			this.energia = 0;
	};


	
	
	
}
