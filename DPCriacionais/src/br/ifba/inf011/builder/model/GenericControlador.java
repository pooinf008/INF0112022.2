package br.ifba.inf011.builder.model;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.criacional.fm.model.atuadores.Atuador;
import br.ifba.inf011.criacional.fm.model.exception.AppException;
import br.ifba.inf011.criacional.fm.model.termometro.Termometro;

public class GenericControlador implements Controlador{
	
	private Termometro termometro;
	private Atuador atuador;
	private Ambiente ambiente;

	public GenericControlador(GenericControlador outro) {
		this.termometro = outro.termometro.prototipar();
		this.atuador = outro.atuador.prototipar();
		this.ambiente = outro.ambiente;
	}
	
	public GenericControlador(Termometro termometro, Atuador atuador, Ambiente ambiente) {
		super();
		this.termometro = termometro;
		this.atuador = atuador;
		this.ambiente = ambiente;
	}
	
	public Termometro getTermometro() {
		return this.termometro;
	}

	public void monitorar(Ambiente ambiente) throws InterruptedException, AppException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		this.ambiente = ambiente;
		this.monitorar();
	}
	
	public void monitorar() throws InterruptedException, AppException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		while(true) {
			this.ambiente.randomizar();
			this.termometro.lerTemperatura(ambiente);
			this.atuador.atuar(ambiente);
			Thread.sleep(100);
			Thread.yield();
		}
		
	}

	@Override
	public Controlador prototipar() {
		return new GenericControlador(this);
	}
	
	
}
