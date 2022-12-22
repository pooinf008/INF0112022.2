package br.ifba.inf011.criacional.fm.model.termometro;

import java.io.PrintStream;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.prototype.Prototype;

public interface Termometro extends Prototype<Termometro>{
	public void lerTemperatura(Ambiente ambiente);
	public void config(String conf);
	public void setAlarme(PrintStream alarme);
	public void setPadrao(PrintStream padrao);
	public void setTemperaturaMaxima(double maxima);
	public void setTemperaturaMinima(double minima);
}
