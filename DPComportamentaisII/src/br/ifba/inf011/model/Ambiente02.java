package br.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.model.iterator.Iteravel;
import br.ifba.inf011.model.iterator.TermometroIterator;

public class Ambiente02 implements TermometroIterator, Iteravel{
	
	public List<TermometroSimples> termometros;
	int posicao;
	
	public Ambiente02(double temp, int qtde){
		 this.reset(); 
		 this.termometros = new ArrayList<TermometroSimples>();	
		 for(int i = 0; i < qtde; i++)
			 this.termometros.add(new TermometroSimples(temp));
	}

	@Override
	public void reset() {
		this.posicao = -1;
	}

	@Override
	public void next() {
		if(this.hasNext())
			this.posicao++;
	}

	@Override
	public boolean hasNext() {
		return this.posicao < this.termometros.size() - 1;
	}

	@Override
	public Termometro termometro() {
		return  this.termometros.get(this.posicao);
	}
	
	public String toString() {
		String rep = "";
		for(Termometro t : this.termometros)
			rep = rep + t + "\n";
		return rep;
	}

	@Override
	public TermometroIterator iterator() {
		return this;
	}
	

}
