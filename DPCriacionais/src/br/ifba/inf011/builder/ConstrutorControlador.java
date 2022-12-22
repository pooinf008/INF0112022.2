package br.ifba.inf011.builder;

import java.io.PrintStream;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.builder.model.Controlador;
import br.ifba.inf011.builder.model.GenericControlador;
import br.ifba.inf011.criacional.fm.model.atuadores.Atuador;
import br.ifba.inf011.criacional.fm.model.termometro.Termometro;

public class ConstrutorControlador implements Construtor{

	private Termometro termometro;
	private Atuador atuador;
	private PrintStream alarme;
	private PrintStream padrao;
	private Ambiente ambiente;
	private double tempMaxima;
	private double tempMinima;
	
	public ConstrutorControlador() {
		this.reset();
	}
	
	@Override
	public ConstrutorControlador reset() {
		this.termometro = null;
		this.atuador = null;
		this.ambiente = null;
		this.alarme = System.err;
		this.padrao = System.out;
		this.tempMinima = 25;
		this.tempMaxima = 29;
		return this;
	}

	@Override
	public ConstrutorControlador withTermometro(Termometro termometro) {
		this.termometro = termometro;
		return this;
	}

	@Override
	public ConstrutorControlador withAtuador(Atuador atuador) {
		this.atuador = atuador;
		return this;
	}

	@Override
	public ConstrutorControlador setTemperaturaMaxima(double temperatura) {
		this.tempMaxima = temperatura;
		return this;
		
	}

	@Override
	public ConstrutorControlador setTemperaturaMinima(double temperatura) {
		this.tempMinima = temperatura;
		return this;
	}

	@Override
	public ConstrutorControlador setSaidaAlarme(PrintStream alarme) {
		this.alarme = alarme;
		return this;
	}

	@Override
	public ConstrutorControlador setSaidaPadrao(PrintStream padrao) {
		this.padrao = padrao;
		return this;
	}

	@Override
	public ConstrutorControlador monitorar(Ambiente ambiente) {
		this.ambiente = ambiente;
		return this;
	}
	
	public Controlador build(Ambiente ambiente) {
		this.termometro.setTemperaturaMinima(this.tempMinima);		
		this.termometro.setTemperaturaMaxima(this.tempMaxima);
		this.termometro.setAlarme(this.alarme);
		this.termometro.setPadrao(this.padrao);

		this.atuador.setTemperaturaMinima(this.tempMinima);		
		this.atuador.setTemperaturaMaxima(this.tempMaxima);
		this.atuador.setAlarme(this.alarme);
		this.atuador.setPadrao(this.padrao);

		return new GenericControlador(termometro, atuador, ambiente);
		
	}

}
