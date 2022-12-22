package br.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

public class NoRoteamento extends NoComposto implements Termometro{
	
	
	public NoRoteamento() {
	}
	
	@Override
	public List<Temperatura> getTemperatura() {
		List<Temperatura> temperaturas = new ArrayList<Temperatura>();
		for(int i = 0; i < this.filhos.size(); i++)
			temperaturas.addAll(this.filhos.get(0).getTemperatura());
		return temperaturas;
	}

	@Override
	public String getDescricao() {
		return "NO ROTEAMENTO";
	}
	

}
