package br.ifba.inf011;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.strategy.PoliticaAtuacao;
import br.ifba.inf011.strategy.PoliticaTipoI;

public class GenericControlador implements Controlador{
	
	private Ambiente ambiente;
	private double energia;
	private double setPoint;
	private List<Double> historico;
	private List<Double> diferenca;	
	private Double ganho;
	
	private PoliticaAtuacao politicaAtuacao;
	
	public GenericControlador(Ambiente ambiente, double setPoint, double ganho) {
		super();
		this.ambiente = ambiente;
		this.energia = 100;
		this.historico = new ArrayList<Double>();
		this.diferenca = new ArrayList<Double>();
		this.setPoint = setPoint;
		this.ganho = ganho;
		this.politicaAtuacao = new PoliticaTipoI();
	}
	
	
	
	public GenericControlador(Ambiente ambiente) {
		this(ambiente, 27, 1.0);
	}
	

	public GenericControlador() {
		this(null);
	}


	public double monitorar(Ambiente ambiente){
		this.ambiente = ambiente;
		return this.monitorar();
	}
	
	public double monitorar(){
		double temperatura = ambiente.getTemperatura();
		double delta = temperatura - this.setPoint;  
		this.historico.add(temperatura);
		this.diferenca.add(Math.abs(delta));
		this.politicaAtuacao.calcularDeltaAtuacao(temperatura, delta, this.setPoint, this.historico, 
				this.diferenca, this.ganho, this.ambiente);
		this.energia -= this.consumoRodada();
		return delta;
	}
	


	@Override
	public double getEnergia() {
		return this.energia;
	}


	@Override
	public boolean hasEnergia() {
		return this.getEnergia() > this.consumoRodada();
	}


	private double consumoRodada() {
		return this.politicaAtuacao.getGastoEnergia();
	}



	@Override
	public void setPoliticaAtuacao(PoliticaAtuacao politica) {
		this.politicaAtuacao = politica;
		
	}


	
}
