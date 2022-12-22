package br.ifba.inf011.memento;

import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.Ambiente;

public class ControladorMemento implements Memento{
	
	protected String id;
	
	protected Ambiente ambiente;
	protected double energia;
	protected double setPoint;
	protected List<Double> historico;
	protected List<Double> diferenca;	
	protected Double ganho;
	
	public ControladorMemento(String id, Ambiente ambiente,
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

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public double getEnergia() {
		return this.energia;
	}

	public double getSetPoint() {
		return this.setPoint;
	}

	public List<Double> getHistorico() {
		return this.historico;
	}

	public List<Double> getDiferenca() {
		return this.diferenca;
	}

	public Double getGanho() {
		return this.ganho;
	}
	

}
