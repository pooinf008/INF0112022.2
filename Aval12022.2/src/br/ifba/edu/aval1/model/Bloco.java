package br.ifba.edu.aval1.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Bloco implements Comando{
	
	protected List<Comando> comandos;
	
	public Bloco() {
		this.comandos = new ArrayList<Comando>();
	}
	
	public Bloco addComando(Comando comando) {
		this.comandos.add(comando);
		return this;
	}

	public abstract String getValor();

}
