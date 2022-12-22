package br.ifba.inf011.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmbienteLocalNTermometros implements AmbienteNTermometros{
	
	private List<Termometro> termometros;
	
	public AmbienteLocalNTermometros(List<Termometro> termometros) {
		this.termometros = termometros;
	}
	
	public String toString() {
		String s = "Ambiente\n";
		for(Termometro t : this.termometros)
			s = s + t + "\n";
		return s;
	}
	
	public double getTemperatura(String id) {
		for(Termometro t : this.termometros)
			if(t.getId().equals(id))
				return t.getTemperaturaMedia();
		return 0;
	}

	@Override
	public Set<String> getIds() {
		Set<String> ids = new HashSet<String>();
		for(Termometro t : this.termometros)
			ids.add(t.getId());
		return ids;
	}

}
