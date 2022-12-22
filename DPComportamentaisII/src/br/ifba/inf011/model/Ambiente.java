package br.ifba.inf011.model;

import br.ifba.inf011.model.iterator.TermometroIterator;

public class Ambiente implements TermometroIterator{
	
	private Termometro termometro;
	
	public Ambiente(Termometro termometro) {
		this.termometro = termometro;
	}
	
	public String toString() {
		return "Ambiente\n" + this.termometro.toTab(0);
	}
	
	public Termometro getTermometro() {
		return this.termometro;
	}

	@Override
	public void reset() {
		this.termometro.iterator().reset();
	}

	@Override
	public void next() {
		this.termometro.iterator().next();
		
	}

	@Override
	public boolean hasNext() {
		return this.termometro.iterator().hasNext();
	}

	@Override
	public Termometro termometro() {
		return this.termometro.iterator().termometro();
	}

	public TermometroIterator iterator() {
		return this.termometro.iterator();
	}
	
	
	

}
