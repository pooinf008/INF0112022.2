package br.ifba.inf011.model;

import java.util.Set;

public interface AmbienteNTermometros {
	public double getTemperatura(String id);
	public Set<String> getIds();
}
