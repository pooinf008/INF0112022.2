package br.ifba.inf011.builder;

import java.io.PrintStream;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.criacional.fm.model.atuadores.Atuador;
import br.ifba.inf011.criacional.fm.model.termometro.Termometro;

public class ManualControladorConstrutor implements Construtor{

	private String termometro;
	private String atuador;
	private String alarme;
	private String padrao;
	private String ambiente;
	private double tempMaxima;
	private double tempMinima;
	
	@Override
	public ManualControladorConstrutor reset() {
		this.termometro = "SEM TERMOMETRO";
		this.atuador = "SEM ATUADOR";
		this.alarme = System.err.toString();
		this.padrao = System.out.toString();
		this.tempMinima = 25;
		this.tempMaxima = 29;
		return this;
	}

	@Override
	public ManualControladorConstrutor withTermometro(Termometro termometro) {
		this.termometro = termometro.getClass().getName();
		return this;
	}

	@Override
	public ManualControladorConstrutor withAtuador(Atuador atuador) {
		this.atuador = atuador.getClass().getName();	
		return this;
	}

	@Override
	public ManualControladorConstrutor setTemperaturaMaxima(double temperatura) {
		this.tempMaxima = temperatura;
		return this;
		
	}

	@Override
	public ManualControladorConstrutor setTemperaturaMinima(double temperatura) {
		this.tempMinima = temperatura;
		return this;
		
	}

	@Override
	public ManualControladorConstrutor setSaidaAlarme(PrintStream alarme) {
		this.alarme = alarme.toString();
		return this;
	}

	@Override
	public ManualControladorConstrutor setSaidaPadrao(PrintStream padrao) {
		this.padrao = padrao.toString();
		return this;		
	}

	@Override
	public ManualControladorConstrutor monitorar(Ambiente ambiente) {
		this.ambiente = ambiente.getClass().getName();
		return this;		
	}
	
	public String build(Ambiente ambiente) {
		this.monitorar(ambiente);
		String representacao = "controlador{ \n";
		representacao += "\t ambiente : " + this.ambiente + ",\n";
		representacao += "\t termometro : " + this.termometro + ",\n";
		representacao += "\t atuador : " + this.atuador + ",\n";
		representacao += "\t saida_alarme : " + this.alarme + ",\n";
		representacao += "\t saida_padrao : " + this.padrao + ",\n";
		representacao += "\t temperatura_max : " + this.tempMaxima + ",\n";
		representacao += "\t temperatura_min : " + this.tempMinima + ",\n";
		representacao += "}";		
		return representacao;		
	}

}
