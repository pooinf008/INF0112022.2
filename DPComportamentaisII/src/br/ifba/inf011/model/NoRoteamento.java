package br.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.model.iterator.TermometroIterator;
import br.ifba.inf011.model.visitor.TermometroVisitor;

public class NoRoteamento extends NoComposto implements Termometro{
	
	
	
	private List<Termometro> filhos;
	
	
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

	@Override
	public void accept(TermometroVisitor visitor) {
		visitor.visitNoRoteamento(this);
	}
	
	

}
