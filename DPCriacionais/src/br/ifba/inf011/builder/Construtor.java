package br.ifba.inf011.builder;

import java.io.PrintStream;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.criacional.fm.model.atuadores.Atuador;
import br.ifba.inf011.criacional.fm.model.termometro.Termometro;

public interface Construtor {
	public Construtor reset();
	public Construtor withTermometro(Termometro termometro);
	public Construtor withAtuador(Atuador atuador);
	public Construtor setTemperaturaMaxima(double temperatura);
	public Construtor setTemperaturaMinima(double temperatura);
	public Construtor setSaidaAlarme(PrintStream alarme);
	public Construtor setSaidaPadrao(PrintStream alarme);
	public Construtor monitorar(Ambiente ambiente);
}
